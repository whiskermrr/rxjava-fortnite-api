package com.example.rxjava_fortnite_api.models.blogs;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Blog implements Serializable {

    private boolean trending;
    private boolean noTopImage;
    private String image;
    private String author;
    private String shareImage;
    private String title;
    private String content;
    private String trendingImage;
    private boolean featured;
    private String date;
    private String slug;
    private String locale;
    private String externalLink;

    @SerializedName("cat")
    private String category;

    @SerializedName("short")
    private String shortContent;

    @SerializedName("_id")
    private String id;

    public Blog() {

    }

    public boolean isTrending() {
        return trending;
    }

    public void setTrending(boolean trending) {
        this.trending = trending;
    }

    public boolean isNoTopImage() {
        return noTopImage;
    }

    public void setNoTopImage(boolean noTopImage) {
        this.noTopImage = noTopImage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShareImage() {
        return shareImage;
    }

    public void setShareImage(String shareImage) {
        this.shareImage = shareImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTrendingImage() {
        return trendingImage;
    }

    public void setTrendingImage(String trendingImage) {
        this.trendingImage = trendingImage;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }
}
