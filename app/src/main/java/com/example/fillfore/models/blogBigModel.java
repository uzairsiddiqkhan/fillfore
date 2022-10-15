package com.example.fillfore.models;

public class blogBigModel {

    public blogBigModel(int blogImage, int likes,  String blogIntro) {
        this.blogImage = blogImage;
        this.likes = likes;
        this.blogIntro = blogIntro;
    }

    int blogImage, likes,comments, shares;
    String blogIntro;

    public int getBlogImage() {
        return blogImage;
    }

    public void setBlogImage(int blogImage) {
        this.blogImage = blogImage;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
    public String getBlogIntro() {
        return blogIntro;
    }

    public void setBlogIntro(String blogIntro) {
        this.blogIntro = blogIntro;
    }
}
