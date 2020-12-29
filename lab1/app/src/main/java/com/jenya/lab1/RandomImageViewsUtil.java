package com.jenya.lab1;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class RandomImageViewsUtil {

    private List<ImageView> listOfViews = new ArrayList<>();
    private List<Drawable> listOfImages = new ArrayList<>();


    public List<ImageView> getListOfViews() {
        return listOfViews;
    }

    public void setListOfViews(List<ImageView> listOfViews) {
        this.listOfViews = listOfViews;
    }

    public List<Drawable> getListOfImages() {
        return listOfImages;
    }

    public void setListOfImages(List<Drawable> listOfImages) {
        this.listOfImages = listOfImages;
        Collections.shuffle(this.listOfImages);
    }
}
