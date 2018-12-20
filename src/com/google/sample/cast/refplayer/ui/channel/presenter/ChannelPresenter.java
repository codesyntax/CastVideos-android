package com.google.sample.cast.refplayer.ui.channel.presenter;

import com.google.sample.cast.refplayer.ui.channel.view.StationView;

public interface ChannelPresenter {
    void setView(StationView view);
    void removeView();
    void getVideos(String url, int channelType);
}
