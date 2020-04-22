package com.touchkiss.categoryoflife.utils;

import com.touchkiss.categoryoflife.aop.Timer;
import org.apache.http.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created on 2020/03/24 18:32
 *
 * @author Touchkiss
 */
@Component
public class AHttpUtil {
    @Timer
    public String get(String url) throws IOException {
        return HttpUtil.get(url, HttpUtil.DEFAULT_CONNECT_TIMEOUT, HttpUtil.DEFAULT_SOCKET_TIMEOUT, HttpUtil.DEFAULT_CHARSET, null);
    }

    @Timer
    public String get(String url, int connectTimeout, int socketTimeout, String charset, List<Header> headers) throws IOException {
        return HttpUtil.get(url, connectTimeout, socketTimeout, charset, headers);
    }

    @Timer
    public String post(String url) throws IOException {
        return HttpUtil.post(url, "");
    }

    @Timer
    public String post(String url, String body) throws IOException {
        return HttpUtil.post(url, body, null);
    }

    @Timer
    public String post(String url, Map params) throws IOException {
        return post(url, params, null);
    }

    @Timer
    public String post(String url, String body, List<Header> headers) throws IOException {
        return post(url, HttpUtil.DEFAULT_CONNECT_TIMEOUT, HttpUtil.DEFAULT_SOCKET_TIMEOUT, HttpUtil.DEFAULT_CHARSET, body, headers);
    }

    @Timer
    public String post(String url, Map params, List<Header> headers) throws IOException {
        return HttpUtil.post(url, HttpUtil.DEFAULT_CONNECT_TIMEOUT, HttpUtil.DEFAULT_SOCKET_TIMEOUT, HttpUtil.DEFAULT_CHARSET, params, headers);
    }

    @Timer
    public static String post(String url, int connectTimeout, int socketTimeout, String charset, Map params, List<Header> headers) throws IOException {
        return HttpUtil.post(url, connectTimeout, socketTimeout, charset, params, headers);
    }

    @Timer
    public static String post(String url, int connectTimeout, int socketTimeout, String charset, String body, List<Header> headers) throws IOException {
        return HttpUtil.post(url, connectTimeout, socketTimeout, charset, body, headers);
    }
}
