package com.google.sample.cast.refplayer.ui.stationlist.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.sample.cast.refplayer.R;
import com.google.sample.cast.refplayer.di.component.DaggerStationListComponent;
import com.google.sample.cast.refplayer.ui.stationlist.model.StationListViewModel;
import com.google.sample.cast.refplayer.ui.stationlist.presenter.StationListPresenter;

import java.util.List;

import javax.inject.Inject;

public class StationListFragment extends Fragment implements StationListView {
    @Inject
    StationListPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerStationListComponent.builder().build().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_station_list, container, false);
    }

    @Override
    public void showStations(List<StationListViewModel> stations) {

    }
}
