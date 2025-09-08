package com.restfulapi.web.restful_Web_services.helloWorldCtrl;

public class helloWorldBean {
    private String msg;

    helloWorldBean(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "helloWorldBean{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
