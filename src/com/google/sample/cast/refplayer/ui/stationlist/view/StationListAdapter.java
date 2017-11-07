package com.google.sample.cast.refplayer.ui.stationlist.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.sample.cast.refplayer.R;
import com.google.sample.cast.refplayer.ui.stationlist.model.StationListItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class StationListAdapter extends RecyclerView.Adapter<StationListItemViewHolder> {
    private final List<StationListItemViewModel> stations;
    private final StationListItemClickListener stationListItemClickListener;

    public StationListAdapter(StationListItemClickListener stationListItemClickListener) {
        this.stations = new ArrayList<>();
        this.stationListItemClickListener = stationListItemClickListener;
    }

    public void setStations(List<StationListItemViewModel> stations) {
        this.stations.clear();
        this.stations.addAll(stations);
        notifyDataSetChanged();
    }

    @Override
    public StationListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_station_list, parent, false);
        return new StationListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StationListItemViewHolder holder, int position) {
        StationListItemViewModel station = stations.get(position);
        holder.bind(station, stationListItemClickListener);
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }
}
