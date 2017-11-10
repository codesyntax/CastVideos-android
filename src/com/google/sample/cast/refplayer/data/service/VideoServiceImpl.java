package com.google.sample.cast.refplayer.data.service;

import com.google.sample.cast.refplayer.data.api.CategoryApi;
import com.google.sample.cast.refplayer.data.model.CategoryDataModel;
import com.google.sample.cast.refplayer.data.model.VideoDataModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class VideoServiceImpl implements VideoService {

    private final CategoryApi categoryApi;

    @Inject
    public VideoServiceImpl(CategoryApi categoryApi) {
        this.categoryApi = categoryApi;
    }

    @Override
    public List<VideoDataModel> getVideos() {
        List<VideoDataModel> result = new ArrayList<>();
        //TODO replace hardcoded url
        try {
            List<CategoryDataModel> categories = categoryApi
                    .getCategories("https://bertsoa.eus/api/1.0/chromecast.json")
                    .execute()
                    .body();
            result = categories.get(0).getVideos();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
