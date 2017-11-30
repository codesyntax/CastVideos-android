package com.google.sample.cast.refplayer.navigation;

import android.app.Activity;
import android.widget.ImageView;

import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModel;

public interface LocalPlayerActivityNavigator {
    String EXTRA_MEDIA_INFO = "extra_media_info";
    String EXTRA_SHOULD_START = "extra_should_start";
    String TRANSITION_IMAGE = "transition_image";
    void navigate(Activity context,
                  VideoListItemViewModel item,
                  boolean shouldStart,
                  ImageView imageView);
}
