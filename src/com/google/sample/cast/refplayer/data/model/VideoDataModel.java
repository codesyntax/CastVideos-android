package com.google.sample.cast.refplayer.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoDataModel {
    private String title;
    private String subtitle;
    private long duration;
    @SerializedName("image-480x270")
    private String bigImageURL;
    @SerializedName("image-780x1200")
    private String smallImageURL;
    private String thumb;
    private String studio;
    private List<SourceDataModel> sources;
    private String date;
    private String videoid;

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public long getDuration() {
        return duration;
    }

    public String getBigImageURL() {
        return bigImageURL;
    }

    public String getSmallImageURL() {
        return smallImageURL;
    }

    public String getThumb() {
        return thumb;
    }

    public String getStudio() {
        return studio;
    }

    public List<SourceDataModel> getSources() {
        return sources;
    }

    public String getDate() {
        return date;
    }

    public String getVideoid() {
        return videoid;
    }
}
