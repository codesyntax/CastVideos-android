package com.google.sample.cast.refplayer.ui.channellist.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.sample.cast.refplayer.R;
import com.google.sample.cast.refplayer.ui.channellist.model.ChannelListItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListItemViewHolder> {
    private final List<ChannelListItemViewModel> stations;
    private final List<ChannelListItemViewModel> filteredStations;
    private final ChannelListItemClickListener channelListItemClickListener;
    private int filter = 0;

    public ChannelListAdapter(ChannelListItemClickListener channelListItemClickListener) {
        this.stations = new ArrayList<>();
        this.filteredStations = new ArrayList<>();
        this.channelListItemClickListener = channelListItemClickListener;
    }

    public void setStations(List<ChannelListItemViewModel> stations) {
        this.stations.clear();
        this.stations.addAll(stations);
        updateFilter();
    }

    @Override
    public ChannelListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_channel_list, parent, false);
        return new ChannelListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChannelListItemViewHolder holder, int position) {
        ChannelListItemViewModel station = filteredStations.get(position);
        holder.bind(station, channelListItemClickListener);
    }

    @Override
    public int getItemCount() {
        return filteredStations.size();
    }

    public void setFilter(int filter) {
        this.filter = filter;
        updateFilter();
    }

    private void updateFilter() {
        this.filteredStations.clear();
        if (filter == 0) {
            this.filteredStations.addAll(stations);
        } else {
            for (int i = 0; i < stations.size(); i++) {
                if (stations.get(i).getChannelType() == filter) {
                    this.filteredStations.add(stations.get(i));
                }
            }
        }
        notifyDataSetChanged();
    }
}
