package com.google.sample.cast.refplayer.di.module;

import com.codesyntax.jarrion.di.scope.FragmentScope;
import com.google.sample.cast.refplayer.domain.interactor.GetChannelsInteractor;
import com.google.sample.cast.refplayer.domain.interactor.GetChannelsInteractorImpl;
import com.google.sample.cast.refplayer.domain.interactor.GetVideosByStationInteractor;
import com.google.sample.cast.refplayer.domain.interactor.GetVideosByStationInteractorImpl;
import com.google.sample.cast.refplayer.navigation.ChannelActivityNavigator;
import com.google.sample.cast.refplayer.navigation.ChannelActivityNavigatorImpl;
import com.google.sample.cast.refplayer.navigation.LocalPlayerActivityNavigator;
import com.google.sample.cast.refplayer.navigation.LocalPlayerActivityNavigatorImpl;
import com.google.sample.cast.refplayer.ui.channel.model.MediaInfoMapper;
import com.google.sample.cast.refplayer.ui.channel.model.MediaInfoMapperImpl;
import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModelMapper;
import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModelMapperImpl;
import com.google.sample.cast.refplayer.ui.channellist.model.ChannelListItemViewModelMapper;
import com.google.sample.cast.refplayer.ui.channellist.model.ChannelListItemViewModelMapperImpl;
import com.google.sample.cast.refplayer.ui.channellist.presenter.ChannelListPresenter;
import com.google.sample.cast.refplayer.ui.channellist.presenter.ChannelListPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ChannelListModule {

    @FragmentScope
    @Provides
    public ChannelListPresenter provideStationListPresenter(ChannelListPresenterImpl presenter) {
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
    public ChannelActivityNavigator provideVideoBrowserActivityNavigator(ChannelActivityNavigatorImpl navigator) {
        return navigator;
    }

    @FragmentScope
    @Provides
    public GetVideosByStationInteractor provideGetVideosByStationInteractor(GetVideosByStationInteractorImpl interactor) {
        return interactor;
    }

    @FragmentScope
    @Provides
    public VideoListItemViewModelMapper provideVideoListItemViewModelMapper(VideoListItemViewModelMapperImpl mapper) {
        return mapper;
    }

    @FragmentScope
    @Provides
    public LocalPlayerActivityNavigator provideLocalPlayerActivityNavigator(LocalPlayerActivityNavigatorImpl navigator) {
        return navigator;
    }

    @FragmentScope
    @Provides
    public MediaInfoMapper provideMediaInfoMapper(MediaInfoMapperImpl mapper) {
        return mapper;
    }
}
