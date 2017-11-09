package com.google.sample.cast.refplayer.ui.station.presenter;

import com.google.sample.cast.refplayer.domain.interactor.GetVideosByStationInteractor;
import com.google.sample.cast.refplayer.domain.model.Video;
import com.google.sample.cast.refplayer.ui.station.view.StationView;

import java.util.List;

import javax.inject.Inject;

public class StationPresenterImpl implements StationPresenter {
    private final GetVideosByStationInteractor getVideosByStationInteractor;
    private StationView view;

    @Inject
    public StationPresenterImpl(GetVideosByStationInteractor getVideosByStationInteractor) {
        this.getVideosByStationInteractor = getVideosByStationInteractor;
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
        getVideosByStationInteractor.execute(stations -> {
            if (view != null) {
                //TODO make mapper
                //view.showVideos();
            }
        });
    }
}
