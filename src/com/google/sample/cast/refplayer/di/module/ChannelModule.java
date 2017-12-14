package com.google.sample.cast.refplayer.di.module;

import com.codesyntax.jarrion.di.scope.FragmentScope;
import com.google.sample.cast.refplayer.domain.interactor.GetVideosByStationInteractor;
import com.google.sample.cast.refplayer.domain.interactor.GetVideosByStationInteractorImpl;
import com.google.sample.cast.refplayer.navigation.LocalPlayerActivityNavigator;
import com.google.sample.cast.refplayer.navigation.LocalPlayerActivityNavigatorImpl;
import com.google.sample.cast.refplayer.ui.channel.model.MediaInfoMapper;
import com.google.sample.cast.refplayer.ui.channel.model.MediaInfoMapperImpl;
import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModelMapper;
import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModelMapperImpl;
import com.google.sample.cast.refplayer.ui.channel.presenter.ChannelPresenter;
import com.google.sample.cast.refplayer.ui.channel.presenter.ChannelPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ChannelModule {

    @FragmentScope
    @Provides
    public ChannelPresenter provideStationPresenter(ChannelPresenterImpl presenter) {
        return presenter;
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
