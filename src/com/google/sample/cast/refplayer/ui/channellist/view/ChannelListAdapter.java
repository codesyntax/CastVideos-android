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
    private final ChannelListItemClickListener channelListItemClickListener;

    public ChannelListAdapter(ChannelListItemClickListener channelListItemClickListener) {
        this.stations = new ArrayList<>();
        this.channelListItemClickListener = channelListItemClickListener;
    }

    public void setStations(List<ChannelListItemViewModel> stations) {
        this.stations.clear();
        this.stations.addAll(stations);
        notifyDataSetChanged();
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
        ChannelListItemViewModel station = stations.get(position);
        holder.bind(station, channelListItemClickListener);
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }
}
