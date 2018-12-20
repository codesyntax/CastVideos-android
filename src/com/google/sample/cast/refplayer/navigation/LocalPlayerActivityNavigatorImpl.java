package com.google.sample.cast.refplayer.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.cast.MediaInfo;
import com.google.sample.cast.refplayer.mediaplayer.LocalPlayerActivity;
import com.google.sample.cast.refplayer.ui.channel.model.MediaInfoMapper;
import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModel;

import javax.inject.Inject;

public class LocalPlayerActivityNavigatorImpl implements LocalPlayerActivityNavigator {
    private final MediaInfoMapper mediaInfoMapper;

    @Inject
    public LocalPlayerActivityNavigatorImpl(MediaInfoMapper mediaInfoMapper) {
        this.mediaInfoMapper = mediaInfoMapper;
    }

    @Override
    public void navigate(Activity context, String channelId, VideoListItemViewModel item,
                         boolean shouldStart, ImageView imageView) {
        MediaInfo mediaInfo = mediaInfoMapper.map(channelId, item);
        Intent intent = getNavigationIntent(context, mediaInfo, shouldStart, item.isPlayable(), item.isLive());
        if (imageView != null) {
            ActivityOptionsCompat options = getOptions(context, imageView);
            ActivityCompat.startActivity(context, intent, options.toBundle());
        } else {
            context.startActivity(intent);
        }
    }

    private ActivityOptionsCompat getOptions(Activity context, ImageView imageView) {
        Pair<View, String> imagePair = Pair
                .create(imageView, TRANSITION_IMAGE);
        return ActivityOptionsCompat
                .makeSceneTransitionAnimation(context, imagePair);
    }

    private Intent getNavigationIntent(Context context, MediaInfo mediaInfo, boolean shouldStart, boolean playable, boolean live) {
        Intent intent = new Intent(context, LocalPlayerActivity.class);
        intent.putExtra(EXTRA_MEDIA_INFO, mediaInfo);
        intent.putExtra(EXTRA_SHOULD_START, shouldStart);
        intent.putExtra(EXTRA_PLAYABLE, playable);
        intent.putExtra(EXTRA_LIVE, live);
        return intent;
    }
}
