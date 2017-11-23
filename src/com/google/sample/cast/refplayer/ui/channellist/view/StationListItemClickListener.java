package com.google.sample.cast.refplayer.ui.channellist.view;

import android.support.v7.widget.AppCompatTextView;

import com.google.sample.cast.refplayer.ui.channellist.model.ChannelListItemViewModel;

public interface StationListItemClickListener {
    void onItemClick(ChannelListItemViewModel channelListItemViewModel, AppCompatTextView name);
}
