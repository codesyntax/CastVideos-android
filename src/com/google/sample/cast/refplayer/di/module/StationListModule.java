package com.google.sample.cast.refplayer.di.module;

import com.google.sample.cast.refplayer.di.scope.FragmentScope;
import com.google.sample.cast.refplayer.domain.interactor.GetStationsInteractor;
import com.google.sample.cast.refplayer.domain.interactor.GetStationsInteractorImpl;
import com.google.sample.cast.refplayer.navigation.VideoBrowserActivityNavigator;
import com.google.sample.cast.refplayer.navigation.VideoBrowserActivityNavigatorImpl;
import com.google.sample.cast.refplayer.ui.stationlist.model.StationListItemViewModelMapper;
import com.google.sample.cast.refplayer.ui.stationlist.model.StationListItemViewModelMapperImpl;
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

    @FragmentScope
    @Provides
    public StationListItemViewModelMapper provideStationListItemViewModelMapper(StationListItemViewModelMapperImpl mapper) {
        return mapper;
    }

    @FragmentScope
    @Provides
    public GetStationsInteractor provideGetStationsInteractor(GetStationsInteractorImpl interactor) {
        return interactor;
    }

    @FragmentScope
    @Provides
    public VideoBrowserActivityNavigator provideVideoBrowserActivityNavigator(VideoBrowserActivityNavigatorImpl navigator) {
        return navigator;
    }
}
