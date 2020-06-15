package com.mySampleApplication.server.model;

import java.io.Serializable;
import java.util.List;

public class PageInfo<T> implements Serializable {
    private int totalNum = 0;
    private int currentPage = 1 ;
    private int pageSize = 5 ;
    private int totalPage = 1;
    private List<T> list ;

    public PageInfo() {
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
        this.totalPage = totalNum / 5 + 1;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
