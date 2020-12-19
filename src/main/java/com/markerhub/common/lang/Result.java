package com.markerhub.common.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回的结果集格式
 *
 */

@Data
public class Result implements Serializable {
    private int code;
    private String msg;
    private Object data;

    //静态方法，后台返回一个data数据即可
    public static Result succ(Object data) {
       return succ(200,"操作正常",data);
    }

    public static Result succ(int code,String msg,Object data) {
        Result result = new Result();
        result.setCode(code);//200是正常，非200表示异常
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public static Result fail(String msg) {
        return fail(400,msg,null);
    }

    public static Result fail(String msg,Object data) {
       return fail(400,msg,data);
    }

    public static Result fail(int code,String msg,Object data) {
        Result result = new Result();
        result.setCode(code);//200是正常，非200表示异常
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

}
