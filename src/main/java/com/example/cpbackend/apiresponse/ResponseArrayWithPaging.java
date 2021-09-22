package com.example.cpbackend.apiresponse;


import java.util.Date;
import java.util.List;

public class ResponseArrayWithPaging {
    private boolean success;
    private String message;
    private List<?> list;
    private int pageIndex;
    private int pageSize;
    private int total;
    private long ts;

    public ResponseArrayWithPaging(boolean success, String message, List<?> list, int pageIndex, int pageSize, int total) {
        this.success = success;
        this.message = message;
        this.list = list;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.total = total;
        this.ts = new Date().getTime();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }
}
