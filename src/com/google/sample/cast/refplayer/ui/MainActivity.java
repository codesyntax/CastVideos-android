package com.google.sample.cast.refplayer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.sample.cast.refplayer.R;
import com.google.sample.cast.refplayer.queue.ui.QueueListViewActivity;
import com.google.sample.cast.refplayer.ui.channellist.ChannelListListener;
import com.google.sample.cast.refplayer.ui.channellist.view.ChannelListFragment;

import java.util.List;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements ChannelListListener {
    private CastContext castContext;
    private SessionManager sessionManager;
    private final SessionManagerListener sessionManagerListener
            = new MainSessionManagerListener();
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private LinearLayout drawerMenu;
    private LinearLayout channelsDrawerItem;
    private AppCompatTextView channelsDrawerItemValue;
    private LinearLayout queueDrawerItem;
    private AppCompatTextView queueDrawerItemValue;
    private LinearLayout notificationsDrawerItem;
    private LinearLayout aboutDrawerItem;
    private RemoteMediaClient remoteMediaClient;
    private RemoteMediaClient.Listener remoteMediaClientListener = new MyRemoteMediaClientListener();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        castContext = CastContext.getSharedInstance(this);
        sessionManager = castContext.getSessionManager();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fabric.with(this, new Crashlytics());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupDrawerLayout();
        setupDrawerItems();
        setupFragment();
    }

    private void setupFragment() {
        FragmentManager f = getSupportFragmentManager();
        ChannelListFragment channelListFragment = (ChannelListFragment) f.findFragmentById(R.id.fragment_station_list);
        if (channelListFragment != null) {
            channelListFragment.setChannelListListener(this);
        }
    }

    private void setupDrawerItems() {
        channelsDrawerItem = (LinearLayout) findViewById(R.id.drawer_item_channels);
        channelsDrawerItemValue = (AppCompatTextView) findViewById(R.id.drawer_item_channels_value);
        channelsDrawerItem.setOnClickListener(v -> drawerLayout.closeDrawer(drawerMenu));
        queueDrawerItem = (LinearLayout) findViewById(R.id.drawer_item_queue);
        queueDrawerItemValue = (AppCompatTextView) findViewById(R.id.drawer_item_queue_value);
        queueDrawerItemValue.setText(String.valueOf(0));
        queueDrawerItem.setOnClickListener(v -> goToQueue());
    }

    private void goToQueue() {
        drawerLayout.closeDrawer(drawerMenu);
        startActivity(new Intent(this, QueueListViewActivity.class));
    }

    private void setupDrawerLayout() {
        drawerMenu = (LinearLayout) findViewById(R.id.drawer);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private RemoteMediaClient getRemoteMediaClient() {
        CastSession castSession = castContext.getSessionManager().getCurrentCastSession();
        return (castSession != null && castSession.isConnected())
                ? castSession.getRemoteMediaClient() : null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (remoteMediaClient == null) {
            remoteMediaClient = getRemoteMediaClient();
        }
        if (remoteMediaClient != null) {
            remoteMediaClient.addListener(remoteMediaClientListener);
            MediaStatus mediaStatus = remoteMediaClient.getMediaStatus();
            List<MediaQueueItem> queueItems =
                    (mediaStatus == null) ? null : mediaStatus.getQueueItems();
            if (queueItems == null || queueItems.isEmpty()) {
                updateDrawerQueue(0);
            } else {
                updateDrawerQueue(queueItems.size());
            }
        }
        sessionManager.addSessionManagerListener(sessionManagerListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (remoteMediaClient != null) {
            remoteMediaClient.removeListener(remoteMediaClientListener);
        }
        sessionManager.removeSessionManagerListener(sessionManagerListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        CastButtonFactory.setUpMediaRouteButton(getApplicationContext(),
                menu,
                R.id.media_route_menu_item);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(drawerMenu)) {
            drawerLayout.closeDrawer(drawerMenu);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onNumChannelsChanged(int numChannels) {
        channelsDrawerItemValue.setText(String.valueOf(numChannels));
    }

    private class MainSessionManagerListener implements SessionManagerListener {
        @Override
        public void onSessionStarting(Session session) {

        }

        @Override
        public void onSessionStarted(Session session, String s) {
            remoteMediaClient = getRemoteMediaClient();
            if (remoteMediaClient != null) {
                remoteMediaClient.addListener(remoteMediaClientListener);
            }
            invalidateOptionsMenu();
        }

        @Override
        public void onSessionStartFailed(Session session, int i) {

        }

        @Override
        public void onSessionEnding(Session session) {

        }

        @Override
        public void onSessionEnded(Session session, int i) {
            if (remoteMediaClient != null) {
                remoteMediaClient.removeListener(remoteMediaClientListener);
            }
            remoteMediaClient = null;
            invalidateOptionsMenu();
        }

        @Override
        public void onSessionResuming(Session session, String s) {

        }

        @Override
        public void onSessionResumed(Session session, boolean b) {
            remoteMediaClient = getRemoteMediaClient();
            if (remoteMediaClient != null) {
                remoteMediaClient.addListener(remoteMediaClientListener);
            }
            invalidateOptionsMenu();
        }

        @Override
        public void onSessionResumeFailed(Session session, int i) {

        }

        @Override
        public void onSessionSuspended(Session session, int i) {
            if (remoteMediaClient != null) {
                remoteMediaClient.removeListener(remoteMediaClientListener);
            }
            remoteMediaClient = null;
        }
    }

    private class MyRemoteMediaClientListener implements RemoteMediaClient.Listener {

        @Override
        public void onStatusUpdated() {
            updateMediaQueue();
        }

        @Override
        public void onQueueStatusUpdated() {
            updateMediaQueue();
        }

        @Override
        public void onMetadataUpdated() {
        }

        @Override
        public void onPreloadStatusUpdated() {
        }

        @Override
        public void onSendingRemoteMediaRequest() {
        }

        @Override
        public void onAdBreakStatusUpdated() {
        }

        private void updateMediaQueue() {
            MediaStatus mediaStatus = remoteMediaClient.getMediaStatus();
            List<MediaQueueItem> queueItems =
                    (mediaStatus == null) ? null : mediaStatus.getQueueItems();
            if (queueItems == null || queueItems.isEmpty()) {
                updateDrawerQueue(0);
            } else {
                updateDrawerQueue(queueItems.size());
            }
        }
    }

    private void updateDrawerQueue(int size) {
        queueDrawerItemValue.setText(String.valueOf(size));
    }
}
