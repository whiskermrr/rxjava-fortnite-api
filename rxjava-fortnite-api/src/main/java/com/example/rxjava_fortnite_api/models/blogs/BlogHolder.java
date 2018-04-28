package com.example.rxjava_fortnite_api.models.blogs;

import java.util.List;

public class BlogHolder {

    private List<Blog> blogList;
    private int blogTotal;
    private int incrementCount;
    private int articlesToLoad;


    public BlogHolder() {

    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public int getBlogTotal() {
        return blogTotal;
    }

    public void setBlogTotal(int blogTotal) {
        this.blogTotal = blogTotal;
    }

    public int getIncrementCount() {
        return incrementCount;
    }

    public void setIncrementCount(int incrementCount) {
        this.incrementCount = incrementCount;
    }

    public int getArticlesToLoad() {
        return articlesToLoad;
    }

    public void setArticlesToLoad(int articlesToLoad) {
        this.articlesToLoad = articlesToLoad;
    }
}
