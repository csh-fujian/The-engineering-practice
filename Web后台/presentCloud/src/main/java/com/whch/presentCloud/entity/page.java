package com.whch.presentCloud.entity;

public class page {
    public int pageNum;

    public int pageSize;

    public int totalSize;

    public page() {
    }

    public page(int pageNum, int pageSize, int totalSize) {

        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }
}
