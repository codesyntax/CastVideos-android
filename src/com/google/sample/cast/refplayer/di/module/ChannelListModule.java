package com.google.sample.cast.refplayer.di.module;

import com.codesyntax.jarrion.di.scope.ServiceScope;
import com.codesyntax.jarrion.domain.interactor.RegisterTokenInteractor;
import com.codesyntax.jarrion.domain.interactor.RegisterTokenInteractorImpl;
import com.codesyntax.jarrion.domain.interactor.UpdateTokenInteractor;
import com.codesyntax.jarrion.domain.interactor.UpdateTokenInteractorImpl;
import com.google.sample.cast.refplayer.di.scope.FragmentScope;
import com.google.sample.cast.refplayer.domain.interactor.GetChannelsInteractor;
import com.google.sample.cast.refplayer.domain.interactor.GetChannelsInteractorImpl;
import com.google.sample.cast.refplayer.navigation.ChannelActivityNavigator;
import com.google.sample.cast.refplayer.navigation.ChannelActivityNavigatorImpl;
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
}
