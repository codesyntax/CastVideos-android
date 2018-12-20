package com.google.sample.cast.refplayer.navigation;

import android.app.Activity;
import android.widget.ImageView;

import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModel;

public interface LocalPlayerActivityNavigator {
    String EXTRA_MEDIA_INFO = "extra_media_info";
    String EXTRA_SHOULD_START = "extra_should_start";
    String EXTRA_PLAYABLE = "extra_playable";
    String EXTRA_LIVE = "extra_is_live";
    String TRANSITION_IMAGE = "transition_image";
    void navigate(Activity context,
                  String channelId,
                  VideoListItemViewModel item,
                  boolean shouldStart,
                  ImageView imageView);
}
