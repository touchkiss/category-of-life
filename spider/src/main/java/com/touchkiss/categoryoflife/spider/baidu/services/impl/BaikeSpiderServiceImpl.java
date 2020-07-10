package com.touchkiss.categoryoflife.spider.baidu.services.impl;
//
//import com.touchkiss.categoryoflife.spider.baidu.bean.BaikeItem;
//import com.touchkiss.categoryoflife.spider.baidu.bean.BaikeResponse;
//import com.touchkiss.categoryoflife.spider.baidu.bean.ESBaikeItem;
//import com.touchkiss.categoryoflife.spider.baidu.services.BaikeRestoreThread;
//import com.touchkiss.categoryoflife.spider.baidu.services.BaikeSpiderService;
//import com.touchkiss.categoryoflife.spider.baidu.services.BaikeSpiderThread;
//import com.touchkiss.categoryoflife.spider.baidu.services.ESBaikeItemServiceImpl;
//import com.touchkiss.categoryoflife.spider.baidu.util.CategoryUtils;
//import com.touchkiss.categoryoflife.spider.base.ThreadPoolExecutors;
//import com.touchkiss.categoryoflife.spider.constants.RedisConstants;
//import com.touchkiss.categoryoflife.utils.NumberUtil;
//import com.touchkiss.categoryoflife.utils.StringUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;
//
//import java.net.URL;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//
///**
// * Created on 2020/04/07 10:45
// *
// * @author Touchkiss
// */
////@Service
//@Slf4j
//public class BaikeSpiderServiceImpl implements BaikeSpiderService {
//    private final static Pattern NumberPattern = Pattern.compile("[0-9]+");
//    public final static String SPECIAL_CHARCODE = "[\"!@#$%^&*（）\\(\\)\\-_=+…·\\~`:'“”‘、\\[\\]|\\\\?/,？\\.，。：；;{}]";
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//    @Autowired
//    private ESBaikeItemServiceImpl esBaikeItemService;
//
//    @Override
//    public BaikeItem fetchBaike(String url) {
//        try {
//            Document document = Jsoup.parse(new URL(url), 20000);
//            String documentTitle = StringUtil.substringAtIndexOf(document.title(), " ", "（", "_");
//            Elements elementsByClass = document.getElementsByClass("main-content");
//            BaikeItem baikeItem = new BaikeItem(url);
//            baikeItem.setTitle(documentTitle);
//            log.info("========抓取到百度百科：" + documentTitle);
//            if (!CollectionUtils.isEmpty(elementsByClass)) {
//                Element mainContent = elementsByClass.get(0);
//                mainContent.getElementsByTag("a").forEach(a -> {
//                    String href = a.attr("href");
//                    if (StringUtils.isNotBlank(href) && href.startsWith("/item")) {
//                        baikeItem.addLink(href);
//                    }
//                });
//                mainContent.getElementsByTag("img").forEach(img -> {
//                    String imgSrc = img.attr("src");
//                    if (StringUtils.isNotBlank(imgSrc) && !imgSrc.startsWith("data:")) {
//                        baikeItem.addImage(imgSrc);
//                    }
//                });
//                Iterator<Element> iterator = mainContent.getAllElements().iterator();
//                final StringBuilder title = new StringBuilder();
//                final StringBuilder contentBuilder = new StringBuilder();
//                Stack<String> titleStack = new Stack<>();
//                Stack<Integer> levelStack = new Stack<>();
//                while (iterator.hasNext()) {
//                    Element next = iterator.next();
//                    String currentText = next.text();
//                    if (next.hasClass("lemma-summary")) {
//                        title.append("简介");
//                        contentBuilder.append(currentText);
//                        baikeItem.addProperty(removePreferences(title.toString()).replace(documentTitle, ""), removePreferences(contentBuilder.toString()));
//                        title.delete(0, title.length());
//                        contentBuilder.delete(0, contentBuilder.length());
//                    } else if (next.hasClass("basic-info")) {
//                        next.getAllElements().forEach(basicInfoBlock -> {
//                            basicInfoBlock.getAllElements().forEach(basicInfoItem -> {
//                                if (basicInfoItem.hasClass("name")) {
//                                    title.append(basicInfoItem.text());
//                                } else if (basicInfoItem.hasClass("value")) {
//                                    baikeItem.addProperty(removePreferences(title.toString()).replace(documentTitle, ""), removePreferences(basicInfoItem.text()));
//                                    title.delete(0, title.length());
//                                    contentBuilder.delete(0, contentBuilder.length());
//                                }
//                            });
//                        });
//                    } else if (next.hasClass("para-title")) {
//                        currentText = removePreferences(currentText).replace(documentTitle, "");
//                        if (StringUtils.isBlank(currentText)) {
//                            continue;
//                        }
//                        Optional<String> levelClass = next.classNames().stream().filter(name -> name.matches("level-[0-9]+")).findFirst();
//                        if (levelClass.isPresent()) {
//                            String currLevel = levelClass.get();
//                            Matcher matcher = NumberPattern.matcher(currLevel);
//                            if (matcher.find()) {
//                                int levelNumber = NumberUtil.stringToInt(matcher.group(0));
//                                if (!titleStack.empty()) {
//                                    baikeItem.addProperty(String.join("-", new ArrayList<>(titleStack)), removePreferences(contentBuilder.toString()));
//                                    contentBuilder.delete(0, contentBuilder.length());
//                                }
////                            当前栈为空,第一次碰到para-title
//                                int search = levelStack.search(levelNumber);
//                                if (search > -1) {
//                                    for (int i = 0; i < search; i++) {
//                                        titleStack.pop();
//                                        levelStack.pop();
//                                    }
//                                }
//                                titleStack.push(currentText);
//                                levelStack.push(levelNumber);
//                            }
//                        }
//                    } else if (next.hasClass("para")) {
//                        contentBuilder.append(currentText);
//                    }
//                }
//                return baikeItem;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public void fetchBaike() {
//        List<String> pop = stringRedisTemplate.opsForSet().pop(RedisConstants.BAIKE_NOT_FETCHED_URLS, 25);
//        if (CollectionUtils.isEmpty(pop)) {
//            return;
//        }
//        pop.stream()
//                .map(url -> new BaikeSpiderThread(stringRedisTemplate, this, url))
//                .forEach(ThreadPoolExecutors.pool::execute);
//    }
//
//    @Override
//    public BaikeResponse queryBaike(String word) {
//        log.info("正在查询" + word);
//        BaikeResponse baikeResponse = new BaikeResponse();
//        String key = word, property = "";
//        if (word.contains(" ")) {
//            int endIndex = key.indexOf(" ");
//            key = word.substring(0, endIndex);
//            property = word.substring(endIndex + 1);
//        }
//        if (word.contains("的")) {
//            int endIndex = word.indexOf("的");
//            key = word.substring(0, endIndex);
//            property = word.substring(endIndex + 1);
//        }
//        //返回完全匹配答案
//        boolean propertyNotBlank = StringUtils.isNotBlank(property);
//        Set<String> keySet = CategoryUtils.matchCase(property);
//        if (propertyNotBlank) {
//            if (stringRedisTemplate.opsForHash().hasKey(key, property)) {
//                String value = (String) stringRedisTemplate.opsForHash().get(key, property);
//                if (StringUtils.isNotBlank(value)) {
//                    baikeResponse.setCode(200);
//                    baikeResponse.setMsg("success");
//                    baikeResponse.addProperty(property, removePreferences(value));
//                    return baikeResponse;
//                }
//            }
//            for (String p : keySet) {
//                String value = (String) stringRedisTemplate.opsForHash().get(key, p);
//                if (StringUtils.isNotBlank(value)) {
//                    baikeResponse.setCode(200);
//                    baikeResponse.setMsg("success");
//                    baikeResponse.addProperty(property, removePreferences(value));
//                    return baikeResponse;
//                }
//            }
//        }
//
//
//        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(key);
//        if (CollectionUtils.isEmpty(entries)) {
//            BaikeItem baikeItem = fetchBaike("https://baike.baidu.com/item/" + key);
//            if (baikeItem != null) {
//                stringRedisTemplate.opsForSet().add(RedisConstants.BAIKE_HAS_FETCHED_URLS, "/item/" + key);
//                Map<String, String> map = baikeItem.toMap();
//                storeToES(map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
//                map.put("transfered", "1");
//                String title = baikeItem.getTitle();
//                stringRedisTemplate.opsForSet().add(RedisConstants.BAIKE_HAS_STORED_TO_ES, title);
//                stringRedisTemplate.opsForHash().putAll(title, map);
//                baikeItem.getLinks().forEach(link -> {
//                    if (!stringRedisTemplate.opsForSet().isMember(RedisConstants.BAIKE_HAS_FETCHED_URLS, link)) {
//                        stringRedisTemplate.opsForSet().add(RedisConstants.BAIKE_NOT_FETCHED_URLS, link);
//                    }
//                });
//                return queryBaike(title + " " + property);
//            }
//        } else {
//            for (Map.Entry<Object, Object> objectObjectEntry : entries.entrySet()) {
//                String key1 = (String) objectObjectEntry.getKey();
//                String value = (String) objectObjectEntry.getValue();
//                if (StringUtils.isNotBlank(value)) {
//                    if (key1.contains(key)) {
//                        baikeResponse.setCode(200);
//                        baikeResponse.setMsg("success");
//                        baikeResponse.addProperty(key1, removePreferences(value));
//                        return baikeResponse;
//                    }
//                    if (propertyNotBlank) {
//                        for (String k : keySet) {
//                            if (key1.contains(k)) {
//                                baikeResponse.setCode(200);
//                                baikeResponse.setMsg("success");
//                                baikeResponse.addProperty(key1, removePreferences(value));
//                                return baikeResponse;
//                            }
//                        }
//                    }
//                }
//            }
//            baikeResponse.setCode(200);
//            baikeResponse.setMsg("success");
//            baikeResponse.addAllProperties(entries.entrySet().stream()
//                    .filter(objectObjectEntry -> !StringUtils.equalsAny(objectObjectEntry.getKey().toString(), "title", "fetchTime", "sourceUrl", "transfered"))
//                    .collect(Collectors.toMap(objectObjectEntry -> objectObjectEntry.getKey().toString(), objectObjectEntry -> objectObjectEntry.getValue().toString())));
//            return baikeResponse;
//        }
//        baikeResponse.setCode(404);
//        baikeResponse.setMsg("not found");
//        return baikeResponse;
//    }
//
//    @Override
//    public void storeToESFromRedis() {
//        List<String> pop = stringRedisTemplate.opsForSet().pop(RedisConstants.BAIKE_NOT_STORED_TO_ES, 10);
//        if (!CollectionUtils.isEmpty(pop)) {
//            pop.forEach(key -> ThreadPoolExecutors.pool.execute(new BaikeRestoreThread(key, this, stringRedisTemplate)));
//        }
//    }
//
//    @Override
//    public void storeToES(Map<Object, Object> entries) {
//        String title = entries.get("title").toString();
//        log.info("========将“" + title + "存入ES”=====");
//        String titleStrict = title.replaceAll(SPECIAL_CHARCODE, "");
//        String sourceUrl = entries.get("sourceUrl").toString();
//        entries.entrySet().stream()
//                .filter(objectObjectEntry -> !StringUtils.equalsAny(objectObjectEntry.getKey().toString(), "title", "fetchTime", "sourceUrl"))
//                .filter(objectObjectEntry ->
//                        CollectionUtils.isEmpty(esBaikeItemService.search(null, new HashMap() {{
//                            put("title_strict", titleStrict);
//                            put("property_strict", objectObjectEntry.getKey().toString().replaceAll(SPECIAL_CHARCODE, ""));
//                        }}, null, null, 1, 10).getData())
//                )
//                .map(objectObjectEntry -> ESBaikeItem.newESBaikeItem()
//                        .title(title)
//                        .title_strict(titleStrict)
//                        .property(objectObjectEntry.getKey().toString())
//                        .property_strict(objectObjectEntry.getKey().toString().replaceAll(SPECIAL_CHARCODE, ""))
//                        .value(objectObjectEntry.getValue().toString())
//                        .source(sourceUrl)
//                        .build()).forEach(esBaikeItemService::saveOrUpdate);
//        stringRedisTemplate.opsForSet().add(RedisConstants.BAIKE_HAS_STORED_TO_ES, title);
//    }
//
//    String removePreferences(String source) {
//        return source.replace(" 编辑", "").replace(" ", "").replaceAll("[ \\[]*[\\u2460-\\u277f-]+[\\] ]*", "").replaceAll("[ ]*\\[[ ]*[0-9-]+[ ]*\\][ ]*", "").replaceAll("（[见如]*图[0-9-]+）", "");
//    }
//}
