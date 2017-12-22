package com.codesyntax.jarrion.service.messaging;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.sample.cast.refplayer.R;
import com.google.sample.cast.refplayer.navigation.ChannelActivityNavigator;
import com.google.sample.cast.refplayer.ui.channel.view.ChannelActivity;

public class JarrionMessagingService extends FirebaseMessagingService {
    private static final String CHANNEL_ID = "channel_id";
    private static final String CHANNEL_NAME = "Notifikazioak";
    private static final int NOTIFICATION_ID = 101;
    private static final String KEY_TITLE = "title";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_CHANNEL_ID = "id";
    private static final String KEY_CHANNEL_URL = "website";
    private static final String KEY_CHANNEL_IMAGE_URL = "image";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        final NotificationManager notificationManager=
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }
        Intent resultIntent = new Intent(this, ChannelActivity.class);
        resultIntent.putExtra(ChannelActivityNavigator.EXTRA_JSON_URL, remoteMessage.getData().get(KEY_CHANNEL_URL));
        resultIntent.putExtra(ChannelActivityNavigator.EXTRA_COVER_URL, remoteMessage.getData().get(KEY_CHANNEL_IMAGE_URL));
        resultIntent.putExtra(ChannelActivityNavigator.EXTRA_CHANNEL_ID, remoteMessage.getData().get(KEY_CHANNEL_ID));
        resultIntent.putExtra(ChannelActivityNavigator.EXTRA_TITLE, remoteMessage.getData().get(KEY_TITLE));
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_notification)
                        .setContentTitle(remoteMessage.getData().get(KEY_TITLE))
                        .setContentText(remoteMessage.getData().get(KEY_MESSAGE))
                        .setAutoCancel(true)
                        .setContentIntent(resultPendingIntent);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
