package com.google.sample.cast.refplayer.ui.stationlist.view;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.sample.cast.refplayer.R;
import com.google.sample.cast.refplayer.ui.stationlist.model.StationListItemViewModel;
import com.squareup.picasso.Picasso;

public class StationListItemViewHolder extends RecyclerView.ViewHolder {
    private AppCompatImageView cover;
    private AppCompatTextView name;

    public StationListItemViewHolder(View itemView) {
        super(itemView);
        cover = itemView.findViewById(R.id.station_cover);
        name = itemView.findViewById(R.id.station_name);
    }

    public void bind(StationListItemViewModel stationListItemViewModel) {
        Picasso.with(cover.getContext()).load(stationListItemViewModel.getCoverURL()).into(cover);
        name.setText(stationListItemViewModel.getName());
    }
}
