package com.brent.demo.common.basecontroller;

public abstract class BaseC {
    public static final Integer SUCCESS_STATE = 0;
    public static final Integer FAIL_STATE = 1;

    public static ResBody createSuccessBody(){
        ResBody resBody = new ResBody();
        resBody.setState(SUCCESS_STATE);
        return resBody;
    }

    public static <T> ResBody<T> createSuccessBody(T data){
        ResBody resBody = new ResBody();
        resBody.setState(SUCCESS_STATE);
        resBody.setData(data);
        return resBody;
    }

    public static <T> ResBody<T> createSuccessBody(T data,String msg){
        ResBody resBody = new ResBody();
        resBody.setState(SUCCESS_STATE);
        resBody.setData(data);
        resBody.setMsg(msg);
        return resBody;
    }

    public static <T> ResBody<T> createFailBody(String msg){
        ResBody resBody = new ResBody();
        resBody.setState(FAIL_STATE);
        resBody.setMsg(msg);
        return resBody;
    }

    public static <T> ResBody<T> createFailBody(Integer state,String msg){
        ResBody resBody = new ResBody();
        resBody.setState(state);
        resBody.setMsg(msg);
        return resBody;
    }


}
