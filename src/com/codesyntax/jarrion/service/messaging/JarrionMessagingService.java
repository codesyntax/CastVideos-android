package com.codesyntax.jarrion.service.messaging;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.sample.cast.refplayer.R;
import com.google.sample.cast.refplayer.ui.channel.view.ChannelActivity;
import com.google.sample.cast.refplayer.ui.channel.view.LivestreamActivity;

public class JarrionMessagingService extends FirebaseMessagingService {
    private static final String CHANNEL_ID = "channel_id";
    private static final String CHANNEL_NAME = "Notifikazioak";
    private static final int NOTIFICATION_ID = 101;
    private static final int LIVE_STREAM_NOTIFICATION_ID = 102;
    public static final String KEY_TITLE = "title";
    private static final String KEY_MESSAGE = "message";
    public static final String KEY_CHANNEL_ID = "id";
    public static final String KEY_CHANNEL_URL = "source_json_url";
    public static final String KEY_CHANNEL_IMAGE_URL = "image";
    public static final String KEY_CHANNEL_TYPE = "type";
    public static final String LIVESTREAM_CHANNEL_ID = "-1";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        final NotificationManager notificationManager=
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        String channelId = remoteMessage.getData().get(KEY_CHANNEL_ID);
        Intent resultIntent;
        int notificationId = NOTIFICATION_ID;
        if (LIVESTREAM_CHANNEL_ID.equals(channelId)) {
            resultIntent = new Intent(this, LivestreamActivity.class);
            notificationId = LIVE_STREAM_NOTIFICATION_ID;
        } else {
            resultIntent = new Intent(this, ChannelActivity.class);
            resultIntent.putExtra(KEY_CHANNEL_URL, remoteMessage.getData().get(KEY_CHANNEL_URL));
            resultIntent.putExtra(KEY_CHANNEL_IMAGE_URL, remoteMessage.getData().get(KEY_CHANNEL_IMAGE_URL));
            resultIntent.putExtra(KEY_CHANNEL_ID, channelId);
            resultIntent.putExtra(KEY_TITLE, remoteMessage.getData().get(KEY_TITLE));
        }
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
                        .setColor(ContextCompat.getColor(getBaseContext(), R.color.accent))
                        .setContentIntent(resultPendingIntent);
        notificationManager.notify(notificationId, builder.build());
    }
}
