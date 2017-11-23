/*
 * Copyright (C) 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.sample.cast.refplayer.ui.channel.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.sample.cast.refplayer.JarriOnApplication;
import com.google.sample.cast.refplayer.R;
import com.google.sample.cast.refplayer.browser.VideoProvider;
import com.google.sample.cast.refplayer.di.component.ApplicationComponent;
import com.google.sample.cast.refplayer.di.component.DaggerChannelComponent;
import com.google.sample.cast.refplayer.mediaplayer.LocalPlayerActivity;
import com.google.sample.cast.refplayer.queue.ui.QueueListViewActivity;
import com.google.sample.cast.refplayer.settings.CastPreference;
import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModel;
import com.google.sample.cast.refplayer.ui.channel.presenter.ChannelPresenter;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

public class ChannelFragment extends Fragment implements VideoListAdapter.ItemClickListener,
        DispatchKeyEventListener,
        StationView {
    private static final String KEY_JSON_URL = "key_json_url";
    private static final String KEY_TITLE = "key_title";
    private static final String KEY_COVER_URL = "key_cover_url";
    private String jsonURL;
    private String title;
    private String coverURL;
    private CastSession castSession;
    private CastContext castContext;
    private RecyclerView recyclerView;
    private VideoListAdapter adapter;
    private View emptyView;
    private View loadingView;
    private final SessionManagerListener<CastSession> sessionManagerListener =
            new MySessionManagerListener();
    private MenuItem queueMenuItem;
    @Inject
    ChannelPresenter channelPresenter;

    public static ChannelFragment newInstance(String jsonURL, String title, String coverURL) {
        ChannelFragment fragment = new ChannelFragment();
        Bundle args = new Bundle();
        args.putString(KEY_JSON_URL, jsonURL);
        args.putString(KEY_TITLE, title);
        args.putString(KEY_COVER_URL, coverURL);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jsonURL = getArguments().getString(KEY_JSON_URL);
        title = getArguments().getString(KEY_TITLE);
        coverURL = getArguments().getString(KEY_COVER_URL);
        setHasOptionsMenu(true);
        ApplicationComponent component = JarriOnApplication.getInstance().getComponent();
        DaggerChannelComponent.builder()
                .applicationComponent(component)
                .build()
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_channel, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        channelPresenter.setView(this);
        setupToolbar();
        setupRecyclerView();
        emptyView = getView().findViewById(R.id.empty_view);
        loadingView = getView().findViewById(R.id.progress_indicator);
        castContext = CastContext.getSharedInstance(getContext());
        setupCoverImage();
        channelPresenter.getVideos(jsonURL);
    }

    private void setupCoverImage() {
        AppCompatImageView coverImage = getView().findViewById(R.id.cover_image);
        Picasso.with(getContext()).load(coverURL).fit().centerCrop().into(coverImage);
    }

    @Override
    public void onDestroyView() {
        if (channelPresenter != null) {
            channelPresenter.removeView();
        }
        super.onDestroyView();
    }

    private void setupRecyclerView() {
        recyclerView = getView().findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new VideoListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setupToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        getActivity().setTitle(title);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity instanceof DispatchKeyEventOwner) {
            ((DispatchKeyEventOwner) activity).setDispatchKeyEventListener(this);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.station, menu);
        CastButtonFactory.setUpMediaRouteButton(getContext().getApplicationContext(), menu,
                R.id.media_route_menu_item);
        queueMenuItem = menu.findItem(R.id.action_show_queue);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.action_show_queue).setVisible(
                (castSession != null) && castSession.isConnected());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        if (item.getItemId() == R.id.action_settings) {
            intent = new Intent(getContext(), CastPreference.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.action_show_queue) {
            intent = new Intent(getContext(), QueueListViewActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void itemClicked(ImageView imageView, VideoListItemViewModel item) {
        String transitionName = getString(R.string.transition_image);
        Pair<View, String> imagePair = Pair
                .create(imageView, transitionName);
        ActivityOptionsCompat options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(getActivity(), imagePair);
        Intent intent = new Intent(getActivity(), LocalPlayerActivity.class);
        intent.putExtra("media", VideoProvider
                .buildMediaInfo(item.getTitle()
                        ,item.getStudio()
                        ,item.getDescription()
                        ,(int) item.getDuration()
                        ,item.getVideoURL()
                        //TODO set data from server
                        ,"video/mp4"
                        ,item.getThumbnailURL()
                        ,item.getCoverURL()
                        ,null));
        intent.putExtra("shouldStart", false);
        ActivityCompat.startActivity(getActivity(), intent, options.toBundle());
    }

    @Override
    public void onStart() {
        CastContext.getSharedInstance(getContext()).getSessionManager()
                .addSessionManagerListener(sessionManagerListener, CastSession.class);
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        castContext.getSessionManager().addSessionManagerListener(
                sessionManagerListener, CastSession.class);
        if (castSession == null) {
            castSession = CastContext.getSharedInstance(getContext()).getSessionManager()
                    .getCurrentCastSession();
        }
        if (queueMenuItem != null) {
            queueMenuItem.setVisible(
                    (castSession != null) && castSession.isConnected());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        castContext.getSessionManager().removeSessionManagerListener(
                sessionManagerListener, CastSession.class);
    }

    @Override
    public void onStop() {
        CastContext.getSharedInstance(getContext()).getSessionManager()
                .removeSessionManagerListener(sessionManagerListener, CastSession.class);
        super.onStop();
    }

    @Override
    public boolean dispatchKeyEvent(@NonNull KeyEvent event) {
        return castContext.onDispatchVolumeKeyEventBeforeJellyBean(event);
    }

    @Override
    public void showVideos(List<VideoListItemViewModel> videos) {
        adapter.setData(videos);
        loadingView.setVisibility(View.GONE);
        emptyView.setVisibility(null == videos || videos.isEmpty() ? View.VISIBLE : View.GONE);
    }

    @Override
    public void hideRefresh() {
        loadingView.setVisibility(View.GONE);
    }

    private class MySessionManagerListener implements SessionManagerListener<CastSession> {

        @Override
        public void onSessionEnded(CastSession session, int error) {
            if (session == castSession) {
                castContext = null;
            }
            getActivity().invalidateOptionsMenu();
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onSessionResumed(CastSession session, boolean wasSuspended) {
            castSession = session;
            getActivity().invalidateOptionsMenu();
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onSessionStarted(CastSession session, String sessionId) {
            castSession = session;
            getActivity().invalidateOptionsMenu();
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onSessionStarting(CastSession session) {
        }

        @Override
        public void onSessionStartFailed(CastSession session, int error) {
        }

        @Override
        public void onSessionEnding(CastSession session) {
        }

        @Override
        public void onSessionResuming(CastSession session, String sessionId) {
        }

        @Override
        public void onSessionResumeFailed(CastSession session, int error) {
        }

        @Override
        public void onSessionSuspended(CastSession session, int reason) {
        }
    }
}
