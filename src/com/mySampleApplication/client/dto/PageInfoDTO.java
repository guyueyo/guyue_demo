package com.mySampleApplication.client.dto;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.mySampleApplication.server.model.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * message 翻页工具返回封装类
 * creatBy guyue
 * creatTime 2020/6
 */

public class PageInfoDTO<T> implements Serializable {


    private int totalNum = 0;
    private int currentPage = 1 ;
    private int pageSize = 3 ;
    private int totalPage = 1;
    private List<T> list ;

    public PageInfoDTO() {
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
        this.totalPage = (this.totalNum+this.pageSize-1) / this.pageSize;
        if(this.totalPage<this.currentPage)this.currentPage=this.totalPage;
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
        this.totalPage = (this.totalNum+this.pageSize-1) / this.pageSize;
        if(this.totalPage<this.currentPage)this.currentPage=this.totalPage;
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
