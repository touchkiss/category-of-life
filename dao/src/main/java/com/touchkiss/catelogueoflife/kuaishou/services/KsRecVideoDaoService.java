package com.touchkiss.catelogueoflife.kuaishou.services;

import com.github.pagehelper.Page;
import com.touchkiss.catelogueoflife.kuaishou.bean.KsRecVideo;
import java.util.Map;
import java.util.List;

/**
 * Created on 2020-08-26 21:20:44
 *
 * @author Touchkiss
 */
public interface KsRecVideoDaoService {
	boolean insert(KsRecVideo ksRecVideo);

	boolean deleteByPhotoId(String photoId);

    int deleteByMap(Map<String, String> wheres);

    boolean updateByPhotoId(KsRecVideo ksRecVideo, String photoId);

    boolean updateSelectiveByPhotoId(KsRecVideo ksRecVideo, String photoId);

    int updateSelectiveByMap(KsRecVideo ksRecVideo, Map<String, String> wheres);

	KsRecVideo selectByPhotoId(String photoId);

	List<KsRecVideo> queryKsRecVideoList(Map<String, String> map);

	Page<KsRecVideo> findByPage(int pageNo, int pageSize, Map<String, String> map);
}
