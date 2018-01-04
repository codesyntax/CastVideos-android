package com.google.sample.cast.refplayer.navigation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatTextView;

import com.codesyntax.jarrion.service.messaging.JarrionMessagingService;
import com.google.sample.cast.refplayer.ui.channel.view.ChannelActivity;

import javax.inject.Inject;

public class ChannelActivityNavigatorImpl implements ChannelActivityNavigator {
    @Inject
    public ChannelActivityNavigatorImpl() {}

    @Override
    public void navigate(Context context, String channelId, String jsonURL, String title, String coverURL) {
        Intent intent = getNavigationIntent(context, channelId, jsonURL, title, coverURL);
        context.startActivity(intent);
    }

    private Intent getNavigationIntent(Context context,
                                       String channelId,
                                       String jsonURL,
                                       String title,
                                       String coverURL) {
        Intent result = new Intent(context, ChannelActivity.class);
        result.putExtra(JarrionMessagingService.KEY_CHANNEL_ID, channelId);
        result.putExtra(JarrionMessagingService.KEY_CHANNEL_URL, jsonURL);
        result.putExtra(JarrionMessagingService.KEY_TITLE, title);
        result.putExtra(JarrionMessagingService.KEY_CHANNEL_IMAGE_URL, coverURL);
        return result;
    }
}
