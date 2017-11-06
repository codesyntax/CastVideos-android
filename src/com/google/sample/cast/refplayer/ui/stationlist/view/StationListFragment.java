package com.google.sample.cast.refplayer.ui.stationlist.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.sample.cast.refplayer.R;
import com.google.sample.cast.refplayer.di.component.DaggerStationListComponent;
import com.google.sample.cast.refplayer.ui.stationlist.model.StationListItemViewModel;
import com.google.sample.cast.refplayer.ui.stationlist.presenter.StationListPresenter;

import java.util.List;

import javax.inject.Inject;

public class StationListFragment extends Fragment implements StationListView {
    private RecyclerView stationsRecyclerView;
    private StationListAdapter stationListAdapter;
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        stationsRecyclerView = view.findViewById(R.id.stations_recycler_view);
        setupRecyclerView();
        presenter.setView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getStations();
    }

    @Override
    public void onDestroyView() {
        if (presenter != null) {
            presenter.removeView();
        }
        super.onDestroyView();
    }

    private void setupRecyclerView() {
        stationListAdapter = new StationListAdapter();
        stationsRecyclerView.setAdapter(stationListAdapter);
    }

    @Override
    public void showStations(List<StationListItemViewModel> stations) {
        stationListAdapter.setStations(stations);
    }
}
