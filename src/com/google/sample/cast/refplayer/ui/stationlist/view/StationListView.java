package com.google.sample.cast.refplayer.ui.stationlist.view;

import com.google.sample.cast.refplayer.ui.stationlist.model.StationListItemViewModel;

import java.util.List;

public interface StationListView {
    void showStations(List<StationListItemViewModel> stations);
}
