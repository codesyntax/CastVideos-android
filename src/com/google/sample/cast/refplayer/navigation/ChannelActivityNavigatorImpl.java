package com.google.sample.cast.refplayer.navigation;

import android.content.Context;
import android.content.Intent;

import com.google.sample.cast.refplayer.ui.channel.view.ChannelActivity;

import javax.inject.Inject;

public class ChannelActivityNavigatorImpl implements ChannelActivityNavigator {
    @Inject
    public ChannelActivityNavigatorImpl() {}

    @Override
    public void navigate(Context context, String jsonURL) {
        Intent intent = getNavigationIntent(context, jsonURL);
        context.startActivity(intent);
    }

    private Intent getNavigationIntent(Context context, String jsonURL) {
        Intent result = new Intent(context, ChannelActivity.class);
        result.putExtra(EXTRA_JSON_URL, jsonURL);
        return result;
    }
}
