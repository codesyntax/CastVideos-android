package com.google.sample.cast.refplayer.ui.channellist.view;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.sample.cast.refplayer.R;
import com.google.sample.cast.refplayer.ui.channellist.model.ChannelListItemViewModel;
import com.squareup.picasso.Picasso;

public class StationListItemViewHolder extends RecyclerView.ViewHolder {
    private View itemView;
    private AppCompatImageView cover;
    private AppCompatTextView name;

    public StationListItemViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        cover = itemView.findViewById(R.id.station_cover);
        name = itemView.findViewById(R.id.station_name);
    }

    public void bind(final ChannelListItemViewModel channelListItemViewModel,
                     final StationListItemClickListener stationListItemClickListener) {
        Picasso.with(cover.getContext()).load(channelListItemViewModel.getCoverURL()).into(cover);
        name.setText(channelListItemViewModel.getName());
        itemView.setOnClickListener(v ->
                stationListItemClickListener.onItemClick(channelListItemViewModel)
        );
    }
}
