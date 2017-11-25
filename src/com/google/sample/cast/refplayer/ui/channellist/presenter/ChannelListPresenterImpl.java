package com.google.sample.cast.refplayer.ui.channellist.presenter;

import com.google.sample.cast.refplayer.domain.interactor.GetChannelsInteractor;
import com.google.sample.cast.refplayer.domain.model.Channel;
import com.google.sample.cast.refplayer.ui.channellist.model.ChannelListItemViewModel;
import com.google.sample.cast.refplayer.ui.channellist.model.ChannelListItemViewModelMapper;
import com.google.sample.cast.refplayer.ui.channellist.view.ChannelListView;

import java.util.List;

import javax.inject.Inject;

public class ChannelListPresenterImpl implements ChannelListPresenter, GetChannelsInteractor.Callback {
    private final GetChannelsInteractor getChannelsInteractor;
    private final ChannelListItemViewModelMapper channelListItemViewModelMapper;
    private ChannelListView view;

    @Inject
    public ChannelListPresenterImpl(GetChannelsInteractor getChannelsInteractor,
                                    ChannelListItemViewModelMapper channelListItemViewModelMapper) {
        this.getChannelsInteractor = getChannelsInteractor;
        this.channelListItemViewModelMapper = channelListItemViewModelMapper;
    }

    @Override
    public void setView(ChannelListView view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        view = null;
    }

    @Override
    public void getStations() {
        getChannelsInteractor.execute(this);
    }

    @Override
    public void onSuccess(List<Channel> channels) {
        List<ChannelListItemViewModel> channelListItemViewModels
                = channelListItemViewModelMapper.map(channels);
        view.hideRefresh();
        view.showStations(channelListItemViewModels);
    }
}
