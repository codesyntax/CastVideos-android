package com.google.sample.cast.refplayer.ui.stationlist.presenter;

import com.google.sample.cast.refplayer.ui.stationlist.view.StationListView;

import javax.inject.Inject;

public class StationListPresenterImpl implements StationListPresenter {
    private StationListView view;

    @Inject
    public StationListPresenterImpl() {}

    @Override
    public void setView(StationListView view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        view = null;
    }

    @Override
    public void getStations() {
        //TODO inject interactor to get models
    }
}
