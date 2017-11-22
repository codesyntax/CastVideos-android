package com.google.sample.cast.refplayer.data.service;

import com.google.sample.cast.refplayer.data.api.CategoryApi;
import com.google.sample.cast.refplayer.data.model.CategoriesResponseDataModel;
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
    public CategoryDataModel getVideos(String url) {
        CategoryDataModel result = null;
        try {
            CategoriesResponseDataModel categoriesResponseDataModel = categoryApi
                    .getCategories(url)
                    .execute()
                    .body();
            result = categoriesResponseDataModel.getCategories().get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
