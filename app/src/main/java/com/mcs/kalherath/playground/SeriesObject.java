package com.mcs.kalherath.playground;

import com.google.gson.annotations.SerializedName;

public class SeriesObject {

    @SerializedName("title")
    private String title;
    @SerializedName("image")
    private String image;
    @SerializedName("desc")
    private String desc;



    SeriesObject(String title, String poster, String plot){
        this.title = title;
        this.image = poster;
        this.desc = plot;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
