package com.google.sample.cast.refplayer.ui.channellist.view;

import com.google.sample.cast.refplayer.ui.channellist.model.ChannelListItemViewModel;

import java.util.List;

public interface StationListView {
    void showStations(List<ChannelListItemViewModel> stations);

    void hideRefresh();
}
