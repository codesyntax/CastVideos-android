package com.google.sample.cast.refplayer.ui.channellist.presenter;

import android.widget.ImageView;
import com.google.sample.cast.refplayer.ui.channellist.model.ChannelListItemViewModel;
import com.google.sample.cast.refplayer.ui.channellist.view.ChannelListView;

public interface ChannelListPresenter {
    void setView(ChannelListView view);
    void removeView();
    void getStations();
    void onChannelClicked(ChannelListItemViewModel channelListItemViewModel, ImageView imageView);
}
