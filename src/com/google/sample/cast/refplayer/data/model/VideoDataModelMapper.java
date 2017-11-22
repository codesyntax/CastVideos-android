package com.google.sample.cast.refplayer.data.model;

import com.google.sample.cast.refplayer.domain.model.Video;

import java.util.List;

public interface VideoDataModelMapper {

    Video map(VideoDataModel source, CategoryDataModel categoryDataModel);

    List<Video> map(CategoryDataModel categoryDataModel);
}
