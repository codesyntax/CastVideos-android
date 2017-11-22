package com.google.sample.cast.refplayer.ui.channellist.presenter;

import com.google.sample.cast.refplayer.ui.channellist.view.StationListView;

public interface ChannelListPresenter {
    void setView(StationListView view);
    void removeView();
    void getStations();
}
