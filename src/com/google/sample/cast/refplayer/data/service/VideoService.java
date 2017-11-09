package com.google.sample.cast.refplayer.data.service;

import com.google.sample.cast.refplayer.data.model.VideoDataModel;

import java.util.List;

public interface VideoService {
    List<VideoDataModel> getVideos();
}
