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
import com.google.sample.cast.refplayer.browser.VideoProvider;
import com.google.sample.cast.refplayer.mediaplayer.LocalPlayerActivity;
import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModel;

import javax.inject.Inject;

public class LocalPlayerActivityNavigatorImpl implements LocalPlayerActivityNavigator {

    @Inject
    public LocalPlayerActivityNavigatorImpl() {}

    @Override
    public void navigate(Activity context, VideoListItemViewModel item,
                         boolean shouldStart, ImageView imageView) {
        MediaInfo mediaInfo = buildMediaInfo(item);
        Intent intent = getNavigationIntent(context, mediaInfo, shouldStart);
        ActivityOptionsCompat options = getOptions(context, imageView);
        ActivityCompat.startActivity(context, intent, options.toBundle());
    }

    private ActivityOptionsCompat getOptions(Activity context, ImageView imageView) {
        Pair<View, String> imagePair = Pair
                .create(imageView, TRANSITION_IMAGE);
        return ActivityOptionsCompat
                .makeSceneTransitionAnimation(context, imagePair);
    }

    private Intent getNavigationIntent(Context context, MediaInfo mediaInfo, boolean shouldStart) {
        Intent intent = new Intent(context, LocalPlayerActivity.class);
        intent.putExtra(EXTRA_MEDIA_INFO, mediaInfo);
        intent.putExtra(EXTRA_SHOULD_START, shouldStart);
        return intent;
    }

    private MediaInfo buildMediaInfo(VideoListItemViewModel item) {
        return VideoProvider
                .buildMediaInfo(item.getTitle(),
                        item.getStudio(),
                        item.getDescription(),
                        (int) item.getDuration(),
                        item.getVideoURL(),
                        //TODO set data from server
                        "video/mp4",
                        item.getThumbnailURL(),
                        item.getCoverURL(),
                        null,
                        item.getDate());
    }
}
