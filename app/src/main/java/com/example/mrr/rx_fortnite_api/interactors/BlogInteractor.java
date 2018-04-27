package com.example.mrr.rx_fortnite_api.interactors;

import com.example.mrr.rx_fortnite_api.models.blogs.BlogHolder;
import com.example.mrr.rx_fortnite_api.services.BlogService;

import io.reactivex.Single;

public class BlogInteractor {

    private BlogService blogService;

    public BlogInteractor(BlogService blogService) {
        this.blogService = blogService;
    }

    public Single<BlogHolder> getBlogs(String category, String postPerPages, String offset, String locale) {
        return blogService.getBlogs(category, postPerPages, offset, locale);
    }
}
