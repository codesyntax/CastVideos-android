package com.google.sample.cast.refplayer.ui.channellist.presenter;

import com.google.sample.cast.refplayer.ui.channellist.view.ChannelListView;

public interface ChannelListPresenter {
    void setView(ChannelListView view);
    void removeView();
    void getStations();
}
