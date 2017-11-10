package com.google.sample.cast.refplayer.data.model;

import java.util.List;

public class CategoryDataModel {
    private String name;
    private String images;
    private String mp4;
    private List<VideoDataModel> videos;

    public String getName() {
        return name;
    }

    public String getImages() {
        return images;
    }

    public String getMp4() {
        return mp4;
    }

    public List<VideoDataModel> getVideos() {
        return videos;
    }
}
