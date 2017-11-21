package com.google.sample.cast.refplayer.ui.stationlist.presenter;

import com.google.sample.cast.refplayer.domain.interactor.GetStationsInteractor;
import com.google.sample.cast.refplayer.domain.model.Channel;
import com.google.sample.cast.refplayer.ui.stationlist.model.StationListItemViewModel;
import com.google.sample.cast.refplayer.ui.stationlist.model.StationListItemViewModelMapper;
import com.google.sample.cast.refplayer.ui.stationlist.view.StationListView;

import java.util.List;

import javax.inject.Inject;

public class StationListPresenterImpl implements StationListPresenter, GetStationsInteractor.Callback {
    private final GetStationsInteractor getStationsInteractor;
    private final StationListItemViewModelMapper stationListItemViewModelMapper;
    private StationListView view;

    @Inject
    public StationListPresenterImpl(GetStationsInteractor getStationsInteractor,
                                    StationListItemViewModelMapper stationListItemViewModelMapper) {
        this.getStationsInteractor = getStationsInteractor;
        this.stationListItemViewModelMapper = stationListItemViewModelMapper;
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
        getStationsInteractor.execute(this);
    }

    @Override
    public void onSuccess(List<Channel> channels) {
        List<StationListItemViewModel> stationListItemViewModels
                = stationListItemViewModelMapper.map(channels);
        view.hideRefresh();
        view.showStations(stationListItemViewModels);
    }
}
