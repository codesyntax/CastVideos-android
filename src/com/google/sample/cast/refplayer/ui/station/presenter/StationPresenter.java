package com.google.sample.cast.refplayer.ui.station.presenter;

import com.google.sample.cast.refplayer.ui.station.view.StationView;

public interface StationPresenter {
    void setView(StationView view);
    void removeView();
    void getVideos();
}
