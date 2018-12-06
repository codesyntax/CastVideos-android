package com.google.sample.cast.refplayer.ui.channellist.view;

import android.widget.ImageView;
import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModel;
import com.google.sample.cast.refplayer.ui.channellist.model.ChannelListItemViewModel;

import java.util.List;

public interface ChannelListView {
    void showStations(List<ChannelListItemViewModel> stations);

    void hideRefresh();

    void navigateToVideo(VideoListItemViewModel videoListItemViewModel, String channelId, ImageView imageView);
}
