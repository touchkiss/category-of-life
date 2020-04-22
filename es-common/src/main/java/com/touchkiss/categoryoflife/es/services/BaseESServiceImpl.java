package com.touchkiss.categoryoflife.es.services;

import com.touchkiss.categoryoflife.es.bean.ESPage;
import com.touchkiss.categoryoflife.es.repositories.BaseRepository;
import com.touchkiss.categoryoflife.es.utils.EsUtil;
import com.touchkiss.categoryoflife.utils.MapUtil;
import com.touchkiss.categoryoflife.utils.StringUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created on 2020/04/09 23:40
 *
 * @author Touchkiss
 */
public abstract class BaseESServiceImpl<T> implements BaseESService<T> {
    @Autowired
    private BaseRepository baseRepository;

    @Override
    public List<T> getMulti(String[] fields, String... ids) {
        try {
            MultiGetResponse mget = baseRepository.mget(getTClass(), ids);
            if (ArrayUtils.isEmpty(fields)) {
                return Arrays.stream(mget.getResponses())
                        .map(MultiGetItemResponse::getResponse)
                        .map(GetResponse::getSourceAsMap)
                        .map(m -> MapUtil.mapToObject(m, getTClass()))
                        .collect(Collectors.toList());
            } else {
                Set<String> fieldSet = Arrays.stream(fields).collect(Collectors.toSet());
                return Arrays.stream(mget.getResponses())
                        .map(MultiGetItemResponse::getResponse)
                        .map(GetResponse::getSourceAsMap)
                        .map(m -> m.entrySet().stream()
                                .filter(ma -> fieldSet.contains(ma.getKey()))
                                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
                        .map(m -> MapUtil.mapToObject(m, getTClass()))
                        .collect(Collectors.toList());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ESPage<T> search(String[] fields, Map<String, Object> must, Map<String, Object> should, Map<String, Object> must_not, int pageNo, int pageSize) {
        try {
            pageSize = pageSize == 0 ? 10 : pageSize;
            int from = pageNo <= 0 ? 0 : ((pageNo - 1) * pageSize);
            String datatableorderby = CollectionUtils.isEmpty(must) ? "" : (must.containsKey("datatableorderby") ? must.get("datatableorderby").toString() : "");
            datatableorderby = datatableorderby.contains(",") ? datatableorderby.substring(0, datatableorderby.indexOf(",")) : datatableorderby;
            String orderby = (datatableorderby.contains("order by") ? datatableorderby.substring(datatableorderby.indexOf("order by") + 8).trim() : "").trim();
            orderby = StringUtils.isBlank(orderby) ? "" : orderby.substring(0, orderby.indexOf(" "));
            SearchResponse search = baseRepository.search(EsUtil.getEsTableAnnotation(getTClass()).index(), orderby, datatableorderby.contains("asc"), fields, null, filterMap(must), filterMap(should), filterMap(must_not), null, from, pageSize);
            return new ESPage<T>(search.getHits().getTotalHits()==null?null:search.getHits().getTotalHits().value, Arrays.stream(search.getHits().getHits())
                    .map(hit -> MapUtil.mapToObject(hit.getSourceAsMap(), getTClass()))
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean batchUpdate(Map<String, Object> updates, Object... ids) {
        if (ArrayUtils.isEmpty(ids)) {
            return false;
        }
        try {
            return Arrays.stream(baseRepository.mupdate(getTClass(), updates, ids).getItems())
                    .noneMatch(BulkItemResponse::isFailed);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean saveOrUpdate(T entity) {
        try {
            IndexResponse indexResponse = baseRepository.save(entity);
            DocWriteResponse.Result result = indexResponse.getResult();
            boolean createSuccess = DocWriteResponse.Result.CREATED.equals(result);
            if (createSuccess) {
                Field idField = getTClass().getDeclaredField(EsUtil.getEsTableAnnotation(getTClass()).id());
                idField.setAccessible(true);
                if (StringUtil.isNullOrBlank(idField.get(entity))) {
                    idField.set(entity, indexResponse.getId());
                    return saveOrUpdate(entity);
                }
            }
            return createSuccess || DocWriteResponse.Result.UPDATED.equals(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String... ids) {
        try {
            return Arrays.stream(baseRepository.mdelete(getTClass(), ids).getItems())
                    .map(BulkItemResponse::getResponse)
                    .map(obj -> (DocWriteResponse) obj)
                    .map(DocWriteResponse::getResult)
                    .allMatch(DocWriteResponse.Result.DELETED::equals);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public T getOne(String id) {
        try {
            Class<T> tClass = getTClass();
            return MapUtil.mapToObject(baseRepository.get(tClass, id).getSource(), tClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    Class<T> getTClass() {
        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }

    Map<String, Object> filterMap(Map<String, Object> map) {
        if (CollectionUtils.isEmpty(map)) {
            return map;
        } else {
            Set<String> fieldNames = Arrays.stream(getTClass().getDeclaredFields()).map(Field::getName).collect(Collectors.toSet());
            return map.entrySet().stream().filter(stringObjectEntry -> fieldNames.contains(stringObjectEntry.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }
    }
}
