package com.google.sample.cast.refplayer.ui.stationlist.presenter;

import com.google.sample.cast.refplayer.domain.interactor.GetChannelsInteractor;
import com.google.sample.cast.refplayer.domain.model.Channel;
import com.google.sample.cast.refplayer.ui.stationlist.model.ChannelListItemViewModel;
import com.google.sample.cast.refplayer.ui.stationlist.model.ChannelListItemViewModelMapper;
import com.google.sample.cast.refplayer.ui.stationlist.view.StationListView;

import java.util.List;

import javax.inject.Inject;

public class StationListPresenterImpl implements StationListPresenter, GetChannelsInteractor.Callback {
    private final GetChannelsInteractor getChannelsInteractor;
    private final ChannelListItemViewModelMapper channelListItemViewModelMapper;
    private StationListView view;

    @Inject
    public StationListPresenterImpl(GetChannelsInteractor getChannelsInteractor,
                                    ChannelListItemViewModelMapper channelListItemViewModelMapper) {
        this.getChannelsInteractor = getChannelsInteractor;
        this.channelListItemViewModelMapper = channelListItemViewModelMapper;
    }

    @Override
    public void setView(StationListView view) {
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
