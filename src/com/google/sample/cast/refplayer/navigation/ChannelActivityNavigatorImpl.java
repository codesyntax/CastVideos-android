package com.google.sample.cast.refplayer.navigation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatTextView;

import com.google.sample.cast.refplayer.ui.channel.view.ChannelActivity;

import javax.inject.Inject;

public class ChannelActivityNavigatorImpl implements ChannelActivityNavigator {
    @Inject
    public ChannelActivityNavigatorImpl() {}

    @Override
    public void navigate(Context context, String jsonURL, String title, String coverURL) {
        Intent intent = getNavigationIntent(context, jsonURL, title, coverURL);
        context.startActivity(intent);
    }

    private Intent getNavigationIntent(Context context,
                                       String jsonURL,
                                       String title,
                                       String coverURL) {
        Intent result = new Intent(context, ChannelActivity.class);
        result.putExtra(EXTRA_JSON_URL, jsonURL);
        result.putExtra(EXTRA_TITLE, title);
        result.putExtra(EXTRA_COVER_URL, coverURL);
        return result;
    }
}
