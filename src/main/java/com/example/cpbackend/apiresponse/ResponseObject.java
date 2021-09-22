package com.example.cpbackend.apiresponse;


import com.example.cpbackend.entity.LoginResponse;

import java.util.Date;

public class ResponseObject {
    private boolean success;
    private Object obj;
    private String message;
    private long ts;

    public ResponseObject(Object obj, String message, boolean success) {
        this.success = success;
        this.obj = obj;
        this.message = message;
        this.ts = new Date().getTime();
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = new Date().getTime();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
