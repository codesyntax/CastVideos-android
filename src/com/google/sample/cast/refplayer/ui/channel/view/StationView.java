package com.google.sample.cast.refplayer.ui.channel.view;

import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModel;

import java.util.List;

public interface StationView {
    void showVideos(List<VideoListItemViewModel> videos);
    void hideRefresh();
    void showCover(String coverURL);
}
