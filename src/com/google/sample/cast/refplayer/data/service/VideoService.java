package com.google.sample.cast.refplayer.data.service;

import com.google.sample.cast.refplayer.data.model.CategoryDataModel;

public interface VideoService {

    CategoryDataModel getVideos(String url);
}
