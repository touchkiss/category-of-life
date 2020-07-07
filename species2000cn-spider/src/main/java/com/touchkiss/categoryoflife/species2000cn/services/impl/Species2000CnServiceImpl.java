package com.touchkiss.categoryoflife.species2000cn.services.impl;

import com.google.gson.reflect.TypeToken;
import com.touchkiss.categoryoflife.species2000cn.bean.TreeChildrenItemResponse;
import com.touchkiss.categoryoflife.species2000cn.bean.TreeItemResponse;
import com.touchkiss.categoryoflife.species2000cn.services.Species2000CnService;
import com.touchkiss.categoryoflife.utils.GsonUtil;
import com.touchkiss.categoryoflife.utils.HttpUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHeader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created on 2020/07/07 16:27
 *
 * @author Touchkiss
 */
@Service
public class Species2000CnServiceImpl implements Species2000CnService {
    public static final String BRANKETS_REGEX = "<['a-z =\\-\\\\\"/_0-9]+>";
    public static final Pattern MATCH_CN = Pattern.compile("[\\u4e00-\\u9fa5]+");
    private final static Pattern MATCH_BRANKETS = Pattern.compile(BRANKETS_REGEX);
    private static String TOKEN = "62b11a75-93af-4961-aa0d-696479dc5ab1";
    private static String COOKIE = "BDF64CD5C3C78E3DABD5D739A1AA6A6D";

    @Override
    public List<TreeItemResponse> browse(String id) {
        Map<String, String> formData = new HashMap<>();
        formData.put("otherParam", "zTreeAsyncTest");
        if (StringUtils.isNotBlank(id)) {
            formData.put("id", id);
        }
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("X-CSRF-TOKEN", TOKEN));
        headers.add(new BasicHeader("Cookie", "JSESSIONID=" + COOKIE));
        try {
            String response = HttpUtil.post("http://www.sp2000.org.cn/browse/taxa_tree_children", formData, headers);
            ArrayList<TreeChildrenItemResponse> responseArrayList = GsonUtil.fromJson(response, new TypeToken<ArrayList<TreeChildrenItemResponse>>() {
            }.getType());
            if (CollectionUtils.isEmpty(responseArrayList)) {
                if (response.contains("Forbidden")) {
                    HttpGet get = new HttpGet("http://www.sp2000.org.cn/browse/browse_taxa");
                    CloseableHttpResponse execute = HttpUtil.getHttpClient().execute(get);
                    Header[] cookies = execute.getHeaders("Set-Cookie");
                    if (ArrayUtils.isNotEmpty(cookies)) {
                        String value = cookies[0].getValue();
                        COOKIE = value.substring(value.indexOf("=") + 1, value.indexOf(";"));
                    }
                    Document document = Jsoup.parse(HttpUtil.response(HttpUtil.DEFAULT_CHARSET, execute));
                    Elements elementsByAttributeValue = document.getElementsByAttributeValue("name", "_csrf");
                    if (!CollectionUtils.isEmpty(elementsByAttributeValue)) {
                        TOKEN = elementsByAttributeValue.get(0).attr("value").trim();
                        return browse(id);
                    }
                }
                return Collections.EMPTY_LIST;
            }
            return responseArrayList.stream().map(treeChildrenItemResponse -> {
                String pureName = treeChildrenItemResponse.getName().replaceAll(BRANKETS_REGEX, "").replaceAll("[ \t]+", " ");
                TreeItemResponse treeItemResponse = new TreeItemResponse();
                treeItemResponse.setId(treeChildrenItemResponse.getId());
                Matcher matcher = MATCH_CN.matcher(pureName);
                if (matcher.find()) {
                    treeItemResponse.setCnName(matcher.group(0));
                    pureName = pureName.substring(0, pureName.indexOf(treeItemResponse.getCnName()));
                } else {
                    treeItemResponse.setCnName(pureName);
                }
                if (StringUtils.startsWithAny(pureName,
                        "Animalia",
                        "Bacteria",
                        "Chromista",
                        "Fungi",
                        "Plantae",
                        "Protozoa",
                        "Viruses"
                )) {
                    treeItemResponse.setEnName(pureName.substring(0, pureName.indexOf(" ")));
                } else if (StringUtils.startsWithAny(pureName,
                        "Phylum", "Class", "Order", "Family", "Genus"
                )) {
                    treeItemResponse.setEnName(pureName.split(" ")[1]);
                } else {
                    treeItemResponse.setEnName(pureName.trim());
                }
                treeItemResponse.setClassName(judgeClassName(pureName));
                treeItemResponse.setParent(treeChildrenItemResponse.isParent());
                treeItemResponse.setPinyin(treeChildrenItemResponse.getPinyin());
                treeItemResponse.setUrl(treeChildrenItemResponse.getUrl());
                return treeItemResponse;
            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    String judgeClassName(String pureName) {
        String firstName = pureName.split("[ \t]")[0];
        switch (firstName) {
            case "Animalia":
            case "Bacteria":
            case "Chromista":
            case "Fungi":
            case "Plantae":
            case "Protozoa":
            case "Viruses":
                return "界";
            case "Phylum":
                return "门";
            case "Class":
                return "纲";
            case "Order":
                return "目";
            case "Family":
                return "科";
            case "Genus":
                return "属";
            default:
                return "种";
        }
    }

    public static void main(String[] args) {
        String str = "Order	ARTIODACTYLA	偶蹄目(acc.48, 	syn.95	<a class=\"text-specialists\" href=\"specialist/specialist_details/1457043364\" title=\"\" target=\"_blank\">Yang Qi-Sen</a>)";
        System.out.println(str.replaceAll(BRANKETS_REGEX, ""));
    }
}
