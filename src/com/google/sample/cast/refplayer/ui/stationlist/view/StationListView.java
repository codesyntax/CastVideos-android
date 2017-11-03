package com.google.sample.cast.refplayer.ui.stationlist.view;

import com.google.sample.cast.refplayer.ui.stationlist.model.StationListViewModel;

import java.util.List;

public interface StationListView {
    void showStations(List<StationListViewModel> stations);
}
