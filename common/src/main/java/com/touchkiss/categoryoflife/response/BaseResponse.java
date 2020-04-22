package com.touchkiss.categoryoflife.response;

/**
 * Created on 2020/04/07 16:56
 *
 * @author Touchkiss
 */
public class BaseResponse<T> {
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
