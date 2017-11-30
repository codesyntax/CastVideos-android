package com.google.sample.cast.refplayer.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.sample.cast.refplayer.R;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {
    private CastContext castContext;
    private SessionManager sessionManager;
    private final SessionManagerListener sessionManagerListener
            = new MainSessionManagerListener();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        castContext = CastContext.getSharedInstance(this);
        sessionManager = castContext.getSessionManager();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fabric.with(this, new Crashlytics());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sessionManager.addSessionManagerListener(sessionManagerListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
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

    private class MainSessionManagerListener implements SessionManagerListener {
        @Override
        public void onSessionStarting(Session session) {

        }

        @Override
        public void onSessionStarted(Session session, String s) {
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
            invalidateOptionsMenu();
        }

        @Override
        public void onSessionResuming(Session session, String s) {

        }

        @Override
        public void onSessionResumed(Session session, boolean b) {
            invalidateOptionsMenu();
        }

        @Override
        public void onSessionResumeFailed(Session session, int i) {

        }

        @Override
        public void onSessionSuspended(Session session, int i) {

        }
    }
}
