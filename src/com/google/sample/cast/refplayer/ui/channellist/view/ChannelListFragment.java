package com.google.sample.cast.refplayer.ui.channellist.view;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.Toast;
import com.google.sample.cast.refplayer.JarriOnApplication;
import com.google.sample.cast.refplayer.R;
import com.google.sample.cast.refplayer.di.component.ApplicationComponent;
import com.google.sample.cast.refplayer.di.component.DaggerChannelListComponent;
import com.google.sample.cast.refplayer.navigation.ChannelActivityNavigator;
import com.google.sample.cast.refplayer.navigation.LocalPlayerActivityNavigator;
import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModel;
import com.google.sample.cast.refplayer.ui.channellist.ChannelListListener;
import com.google.sample.cast.refplayer.ui.channellist.model.ChannelListItemViewModel;
import com.google.sample.cast.refplayer.ui.channellist.presenter.ChannelListPresenter;

import java.util.List;

import javax.inject.Inject;

public class ChannelListFragment extends Fragment
        implements ChannelListView, ChannelListItemClickListener {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView stationsRecyclerView;
    private ChannelListAdapter channelListAdapter;
    @Inject
    ChannelListPresenter presenter;
    @Inject
    ChannelActivityNavigator channelActivityNavigator;
    @Inject
    LocalPlayerActivityNavigator localPlayerActivityNavigator;
    private ChannelListListener channelListListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationComponent component = JarriOnApplication.getInstance().getComponent();
        DaggerChannelListComponent.builder()
                .applicationComponent(component)
                .build()
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_channel_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView(view);
        setupRefreshLayout(view);
        presenter.setView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getStations();
    }

    @Override
    public void onDestroyView() {
        if (presenter != null) {
            presenter.removeView();
        }
        super.onDestroyView();
    }

    private void setupRefreshLayout(View view) {
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(() -> presenter.getStations());
    }

    private void setupRecyclerView(View view) {
        stationsRecyclerView = (RecyclerView) view.findViewById(R.id.stations_recycler_view);
        channelListAdapter = new ChannelListAdapter(this);
        stationsRecyclerView.setAdapter(channelListAdapter);
        Resources r = getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, r.getDisplayMetrics());
        stationsRecyclerView.addItemDecoration(
                new ChannelItemDecoration((int) px, 2));
    }

    @Override
    public void showStations(List<ChannelListItemViewModel> stations) {
        channelListAdapter.setStations(stations);
        if (channelListListener != null) {
            channelListListener.onNumChannelsChanged(stations.size());
        }
    }

    public void setChannelListListener(ChannelListListener channelListListener) {
        this.channelListListener = channelListListener;
    }

    @Override
    public void hideRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onItemClick(ChannelListItemViewModel channelListItemViewModel, ImageView imageView) {
        if (channelListItemViewModel.getChannelType() == 3 || channelListItemViewModel.getChannelType() == 4) {
            presenter.onChannelClicked(channelListItemViewModel, imageView);
        } else {
            channelActivityNavigator.navigate(getContext(),
                                              channelListItemViewModel.getId(),
                                              channelListItemViewModel.getJsonURL(),
                                              channelListItemViewModel.getName(),
                                              channelListItemViewModel.getCoverURL());
        }
    }

    @Override
    public void navigateToVideo(VideoListItemViewModel videoListItemViewModel, String channelId, ImageView imageView) {
        localPlayerActivityNavigator.navigate(getActivity(), channelId, videoListItemViewModel, false, imageView);
    }

    public void filter(int filter) {
        channelListAdapter.setFilter(filter);
    }
}
