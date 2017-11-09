package com.google.sample.cast.refplayer.data.service;

import com.google.sample.cast.refplayer.data.model.VideoDataModel;

import java.util.List;

import javax.inject.Inject;

public class VideoServiceImpl implements VideoService {

    @Inject
    public VideoServiceImpl() {
    }

    @Override
    public List<VideoDataModel> getVideos() {
        return null;
    }
}
