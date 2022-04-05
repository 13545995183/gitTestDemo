package com.example.springbootdemo.ResultData;

import java.io.Serializable;


public class ResultData<T> implements Serializable {
    //成功标识
    private  Boolean    success;
    //状态码，其中200代表成功
    private String   code;
    //提示信息
    private String message;
    //数据JsonObject
    private  T  data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
