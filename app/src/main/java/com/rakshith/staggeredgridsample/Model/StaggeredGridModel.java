package com.rakshith.staggeredgridsample.Model;

/**
 * Created by rakshith on 12/29/16.
 */
public class StaggeredGridModel {
    private String title;
    private int image;

    public StaggeredGridModel(String title, int imageDrawable) {
        this.title = title;
        this.image = imageDrawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
