package com.fillfore.speakClub.models;

public class callModel {
    public int getImage() {
        return image;
    }

    public callModel(int image, String userName, String interest1, String interest2, String interest3, String rating) {
        this.image = image;
        this.userName = userName;
        this.interest1 = interest1;
        this.interest2 = interest2;
        this.interest3 = interest3;
        this.rating = rating;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInterest1() {
        return interest1;
    }

    public void setInterest1(String interest1) {
        this.interest1 = interest1;
    }

    public String getInterest2() {
        return interest2;
    }

    public void setInterest2(String interest2) {
        this.interest2 = interest2;
    }

    public String getInterest3() {
        return interest3;
    }

    public void setInterest3(String interest3) {
        this.interest3 = interest3;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    int image;
    String userName, interest1 ,interest2 , interest3 ,rating;
        

}
