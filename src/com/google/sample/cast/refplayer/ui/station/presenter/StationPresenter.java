package com.google.sample.cast.refplayer.ui.stationlist.presenter;

import com.google.sample.cast.refplayer.ui.stationlist.view.StationListView;

public interface StationListPresenter {
    void setView(StationListView view);
    void removeView();
    void getStations();
}
