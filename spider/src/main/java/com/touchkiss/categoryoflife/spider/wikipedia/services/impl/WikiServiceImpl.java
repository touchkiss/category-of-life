package com.touchkiss.categoryoflife.spider.wikipedia.services.impl;

import com.touchkiss.categoryoflife.aop.Timer;
import com.touchkiss.categoryoflife.spider.base.ThreadPoolExecutors;
import com.touchkiss.categoryoflife.spider.constants.RedisConstants;
import com.touchkiss.categoryoflife.spider.constants.UrlConstants;
import com.touchkiss.categoryoflife.spider.wikipedia.bean.WikiQueryResponse;
import com.touchkiss.categoryoflife.spider.wikipedia.services.WikiService;
import com.touchkiss.categoryoflife.spider.wikipedia.services.WikiSpiderThread;
import com.touchkiss.categoryoflife.utils.GsonUtil;
import com.touchkiss.categoryoflife.utils.HttpUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 2020/04/02 17:12
 *
 * @author Touchkiss
 */
@Service
public class WikiServiceImpl implements WikiService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    final static Pattern INNER_LINK_PATTERN = Pattern.compile("(?<=[\\[]{2})[^\\]]+(?=[\\]]{2})");

    @Override
    @Timer
    public void fetchContent(String title) {
        WikiQueryResponse wikiQueryResponse = null;
        if (stringRedisTemplate.opsForSet().isMember(RedisConstants.WIKI_QUERY_HAS_FETCHED, title)) {
            return;
        }
        try {
            wikiQueryResponse = GsonUtil.fromJson(HttpUtil.get(UrlConstants.WIKI_QUERY_URL + title), WikiQueryResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (wikiQueryResponse != null) {
            try {
                stringRedisTemplate.opsForSet().add(RedisConstants.WIKI_QUERY_HAS_FETCHED, title);
                String content = wikiQueryResponse.getQuery().getPages().get(0).getRevisions().get(0).getContent();
                File file = new File("D:\\documents\\java\\category-of-life\\spider\\wiki-contents\\" + title + ".txt");
                if (!file.exists()) {
                    file.createNewFile();
                } else {
                    return;
                }
                FileUtils.writeStringToFile(file, content, "utf-8");
                Matcher matcher = INNER_LINK_PATTERN.matcher(content);
                while (matcher.find()) {
                    String nextTitle = matcher.group(0);
                    if (nextTitle.contains("|")) {
                        nextTitle = nextTitle.substring(0, nextTitle.indexOf("|"));
                    }
                    nextTitle = nextTitle.replace(" ", "_");
                    if (!stringRedisTemplate.opsForSet().isMember(RedisConstants.WIKI_QUERY_NOT_FETCHED, nextTitle) && !stringRedisTemplate.opsForSet().isMember(RedisConstants.WIKI_QUERY_HAS_FETCHED, nextTitle)) {
                        stringRedisTemplate.opsForSet().add(RedisConstants.WIKI_QUERY_NOT_FETCHED, nextTitle);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void autoFetch() {
        List<String> titles = stringRedisTemplate.opsForSet().pop(RedisConstants.WIKI_QUERY_NOT_FETCHED, 10);
        titles.stream().map(title -> new WikiSpiderThread(this, title))
                .forEach(ThreadPoolExecutors.pool::execute);
    }

    public static void main(String[] args) throws IOException {
//        String s = HttpUtil.get("https://species.wikipedia.org/w/api.php?action=query&prop=revisions&rvprop=content&format=json&formatversion=2&titles=Cephalorhynchus_commersonii");
//        Matcher matcher = INNER_LINK_PATTERN.matcher(s);
//        while (matcher.find()){
//            System.out.println(matcher.group(0));
//        }
    }
}
