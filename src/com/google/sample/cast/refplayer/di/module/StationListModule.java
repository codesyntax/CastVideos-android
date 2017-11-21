package com.google.sample.cast.refplayer.di.module;

import com.google.sample.cast.refplayer.di.scope.FragmentScope;
import com.google.sample.cast.refplayer.domain.interactor.GetChannelsInteractor;
import com.google.sample.cast.refplayer.domain.interactor.GetChannelsInteractorImpl;
import com.google.sample.cast.refplayer.navigation.VideoBrowserActivityNavigator;
import com.google.sample.cast.refplayer.navigation.VideoBrowserActivityNavigatorImpl;
import com.google.sample.cast.refplayer.ui.stationlist.model.ChannelListItemViewModelMapper;
import com.google.sample.cast.refplayer.ui.stationlist.model.ChannelListItemViewModelMapperImpl;
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
    public ChannelListItemViewModelMapper provideStationListItemViewModelMapper(ChannelListItemViewModelMapperImpl mapper) {
        return mapper;
    }

    @FragmentScope
    @Provides
    public GetChannelsInteractor provideGetStationsInteractor(GetChannelsInteractorImpl interactor) {
        return interactor;
    }

    @FragmentScope
    @Provides
    public VideoBrowserActivityNavigator provideVideoBrowserActivityNavigator(VideoBrowserActivityNavigatorImpl navigator) {
        return navigator;
    }
}
