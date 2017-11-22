package com.google.sample.cast.refplayer.ui.channel.model;

import com.google.sample.cast.refplayer.domain.model.Video;

import java.util.List;

public interface VideoListItemViewModelMapper {

    VideoListItemViewModel map(Video source);

    List<VideoListItemViewModel> map(List<Video> source);
}
