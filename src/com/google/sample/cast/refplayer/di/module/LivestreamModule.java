package com.google.sample.cast.refplayer.di.module;

import com.codesyntax.jarrion.di.scope.FragmentScope;
import com.google.sample.cast.refplayer.data.model.LivestreamDataModelMapper;
import com.google.sample.cast.refplayer.data.model.LivestreamDataModelMapperImpl;
import com.google.sample.cast.refplayer.domain.interactor.GetLivestreamInteractor;
import com.google.sample.cast.refplayer.domain.interactor.GetLivestreamInteractorImpl;
import com.google.sample.cast.refplayer.navigation.LocalPlayerActivityNavigator;
import com.google.sample.cast.refplayer.navigation.LocalPlayerActivityNavigatorImpl;
import com.google.sample.cast.refplayer.ui.channel.model.MediaInfoMapper;
import com.google.sample.cast.refplayer.ui.channel.model.MediaInfoMapperImpl;
import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModelMapper;
import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModelMapperImpl;
import com.google.sample.cast.refplayer.ui.channel.presenter.LivestreamPresenter;
import com.google.sample.cast.refplayer.ui.channel.presenter.LivestreamPresenterImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class LivestreamModule {

    @FragmentScope
    @Provides
    public LivestreamPresenter provideStationPresenter(LivestreamPresenterImpl presenter) {
        return presenter;
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

    @FragmentScope
    @Provides
    public GetLivestreamInteractor provideGetLivestreamInteractor(GetLivestreamInteractorImpl interactor) {
        return interactor;
    }

    @FragmentScope
    @Provides
    public VideoListItemViewModelMapper provideVideoListItemViewModelMapper(VideoListItemViewModelMapperImpl mapper) {
        return mapper;
    }

    @FragmentScope
    @Provides
    public LivestreamDataModelMapper provideLivestreamDataModelMapper(LivestreamDataModelMapperImpl mapper) {
        return mapper;
    }
}
