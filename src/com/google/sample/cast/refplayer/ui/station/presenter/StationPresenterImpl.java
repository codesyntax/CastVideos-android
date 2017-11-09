package com.google.sample.cast.refplayer.ui.station.presenter;

import com.google.sample.cast.refplayer.ui.station.view.StationView;

import javax.inject.Inject;

public class StationPresenterImpl implements StationPresenter {
    private StationView view;

    @Inject
    public StationPresenterImpl() {
    }

    @Override
    public void setView(StationView view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void getVideos() {
        //TODO ask interactor
    }
}
