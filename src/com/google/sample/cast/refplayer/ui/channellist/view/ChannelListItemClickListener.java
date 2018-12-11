package com.google.sample.cast.refplayer.ui.channellist.view;

import android.widget.ImageView;
import com.google.sample.cast.refplayer.ui.channellist.model.ChannelListItemViewModel;

public interface ChannelListItemClickListener {
    void onItemClick(ChannelListItemViewModel channelListItemViewModel, ImageView imageView);
}
