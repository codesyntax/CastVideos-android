package com.google.sample.cast.refplayer.di.module;

import com.google.sample.cast.refplayer.di.scope.FragmentScope;
import com.google.sample.cast.refplayer.ui.stationlist.presenter.StationListPresenter;
import com.google.sample.cast.refplayer.ui.stationlist.presenter.StationListPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class StationListModule {

    @FragmentScope
    @Provides
    public StationListPresenter provideStationListPresenter(StationListPresenterImpl presenter) {
        return presenter;
    }
}
