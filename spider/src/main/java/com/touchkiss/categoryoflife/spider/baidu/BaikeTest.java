package com.touchkiss.categoryoflife.spider.baidu;

import com.touchkiss.categoryoflife.spider.baidu.bean.BaikeItem;
import com.touchkiss.categoryoflife.spider.baidu.services.impl.BaikeSpiderServiceImpl;
import com.touchkiss.categoryoflife.utils.NumberUtil;
import com.touchkiss.categoryoflife.utils.StringUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created on 2020/04/03 17:16
 *
 * @author Touchkiss
 */
public class BaikeTest {
    private final static Pattern NumberPattern = Pattern.compile("[0-9]+");

//    public static void main(String[] args) throws MalformedURLException {
////        InnerBaike innerBaike = fetchBaike("https://baike.baidu.com/item/%E5%8A%A8%E7%89%A9/216062?fromtitle=%E5%8A%A8%E7%89%A9%E7%95%8C&fromid=1622470");
////        innerBaike.getProperties().forEach((k, v) -> {
////            System.out.println(k + ":" + v);
////        });
////        System.out.println(removePreferences("运动习性：大多数无脊椎动物有着明显的前端和后端，感觉器官靠近口部簇生，这种构造能帮助它们在向前运动时及时发觉新情况，并迅速采取应对措施，使运动更快、更敏捷。[4]\n" +
////                "环节躯体：许多无脊椎动物都有着可以分成一些分离环节的躯体，这种躯体构造有利于它们随意改变形状，以复杂的方式进行运动。例如，蜈蚣的大多数环节上都长有一双腿，运动时异常灵活。"));
////        BaikeSpiderServiceImpl baikeSpiderService = new BaikeSpiderServiceImpl();
////        BaikeItem baikeItem = baikeSpiderService.fetchBaike("https://baike.baidu.com/item/%E6%B5%81%E6%B0%93/32923");
////        System.out.println(baikeItem.getTitle());
//        String str="帝企鹅（学名：Aptenodytesforsteri）：也称皇帝企鹅，是企鹅家族中个体最大的物种，一般身高在90厘米以上，最大可达到120厘米，体重可达50千克。其形态特征是脖子底下有一片橙黄色羽毛，向下逐渐变淡，耳朵后部最深。全身色泽协调。颈部为淡黄色，耳朵的羽毛鲜黄橘色，腹部乳白色，背部及鳍状肢则是黑色，鸟喙的下方是鲜桔色。帝企鹅在南极严寒的冬季冰上繁殖后代，雌企鹅每次产1枚蛋，雄企鹅孵蛋。雄帝企鹅双腿和腹部下方之间有一块布满血管的紫色皮肤的育儿袋，能让蛋在环境温度低达零下40摄氏度的低温中保持在舒适的36摄氏度。群居性动物。每当恶劣的气候来临，它们会挤在一起防风御寒。可以潜入水底150至500米，最深的潜水记录甚至可达565米。主要以甲壳类动物为食，偶尔也捕食小鱼和乌贼。唯一一种在南极洲的冬季进行繁殖的企鹅。在南极以及周围岛屿都有分布。";
//        String[] split = str.split("(?<=[。？！])");
//        for (String s : split) {
//            System.out.println(s);
//        }
//    }

    static String removePreferences(String source) {
        return source.replace(" 编辑", "").replace(" ", "").replaceAll("[ \\[]*[\\u2460-\\u277f-]+[\\] ]*", "").replaceAll("[ ]*\\[[ ]*[0-9-]+[ ]*\\][ ]*", "").replaceAll("（[见如]*图[0-9-]+）", "");
    }

    static InnerBaike fetchBaike(String startUrl) {
        try {
            Document document = Jsoup.parse(new URL(startUrl), 5000);
            String documentTitle = StringUtil.substringAtIndexOf(document.title(), " ", "（", "_");
            Elements elementsByClass = document.getElementsByClass("main-content");
            Map<String, String> properties = new HashMap<>();
            if (!CollectionUtils.isEmpty(elementsByClass)) {
                Iterator<Element> iterator = elementsByClass.get(0).getAllElements().iterator();
                final StringBuilder title = new StringBuilder();
                final StringBuilder contentBuilder = new StringBuilder();
                Stack<String> titleStack = new Stack<>();
                Stack<Integer> levelStack = new Stack<>();
                while (iterator.hasNext()) {
                    Element next = iterator.next();
                    String currentText = next.text();
                    if (next.hasClass("lemma-summary")) {
                        title.append("简介");
                        contentBuilder.append(currentText);
                        properties.put(removePreferences(title.toString()).replace(documentTitle, ""), removePreferences(contentBuilder.toString()));
                        title.delete(0, title.length());
                        contentBuilder.delete(0, contentBuilder.length());
                    } else if (next.hasClass("basic-info")) {
                        next.getAllElements().forEach(basicInfoBlock -> {
                            basicInfoBlock.getAllElements().forEach(basicInfoItem -> {
                                if (basicInfoItem.hasClass("name")) {
                                    title.append(basicInfoItem.text());
                                } else if (basicInfoItem.hasClass("value")) {
                                    contentBuilder.append(basicInfoItem.text());
                                    properties.put(removePreferences(title.toString()).replace(documentTitle, ""), removePreferences(contentBuilder.toString()));
                                    title.delete(0, title.length());
                                    contentBuilder.delete(0, contentBuilder.length());
                                }
                            });
                        });
                    } else if (next.hasClass("para-title")) {
                            properties.put(removePreferences(title.toString()).replace(documentTitle, ""), removePreferences(contentBuilder.toString()));
                            title.delete(0, title.length());
                            contentBuilder.delete(0, contentBuilder.length());
                            title.append(currentText);
                    } else if (next.hasClass("para")) {
                        contentBuilder.append(currentText);
                    }
                }
                if (title.length() > 0) {
                    properties.put(removePreferences(title.toString()).replace(documentTitle, ""), removePreferences(contentBuilder.toString()));
                    title.delete(0, title.length());
                    contentBuilder.delete(0, contentBuilder.length());
                }
            }
            InnerBaike innerBaike = new InnerBaike();
            innerBaike.setTitle(documentTitle);
            innerBaike.setProperties(properties);
            return innerBaike;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class InnerBaike {
        private String title;
        private Map<String, String> properties;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Map<String, String> getProperties() {
            return properties;
        }

        public void setProperties(Map<String, String> properties) {
            this.properties = properties;
        }
    }
}
