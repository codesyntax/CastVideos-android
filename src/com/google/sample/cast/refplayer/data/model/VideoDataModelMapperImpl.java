package com.google.sample.cast.refplayer.data.model;

import com.google.sample.cast.refplayer.domain.model.Video;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class VideoDataModelMapperImpl implements VideoDataModelMapper {

    @Inject
    public VideoDataModelMapperImpl() {}

    @Override
    public Video map(VideoDataModel source) {
        return new Video.Builder().build();
    }

    @Override
    public List<Video> map(List<VideoDataModel> source) {
        List<Video> result = new ArrayList<>();
        for (VideoDataModel videoDataModel : source) {
            result.add(map(videoDataModel));
        }
        return result;
    }
}
