package com.google.sample.cast.refplayer.di.module;

import com.google.sample.cast.refplayer.di.scope.FragmentScope;
import com.google.sample.cast.refplayer.domain.interactor.GetVideosByStationInteractor;
import com.google.sample.cast.refplayer.domain.interactor.GetVideosByStationInteractorImpl;
import com.google.sample.cast.refplayer.ui.station.presenter.StationPresenter;
import com.google.sample.cast.refplayer.ui.station.presenter.StationPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class StationModule {

    @FragmentScope
    @Provides
    public StationPresenter provideStationPresenter(StationPresenterImpl presenter) {
        return presenter;
    }

    @FragmentScope
    @Provides
    public GetVideosByStationInteractor provideGetVideosByStationInteractor(GetVideosByStationInteractorImpl interactor) {
        return interactor;
    }
}
