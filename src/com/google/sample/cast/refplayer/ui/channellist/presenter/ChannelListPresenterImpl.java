package com.google.sample.cast.refplayer.ui.channellist.presenter;

import android.widget.ImageView;
import com.google.sample.cast.refplayer.domain.interactor.GetChannelsInteractor;
import com.google.sample.cast.refplayer.domain.interactor.GetVideosByStationInteractor;
import com.google.sample.cast.refplayer.domain.model.Channel;
import com.google.sample.cast.refplayer.domain.model.Video;
import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModelMapper;
import com.google.sample.cast.refplayer.ui.channellist.model.ChannelListItemViewModel;
import com.google.sample.cast.refplayer.ui.channellist.model.ChannelListItemViewModelMapper;
import com.google.sample.cast.refplayer.ui.channellist.view.ChannelListView;

import java.util.List;

import javax.inject.Inject;

public class ChannelListPresenterImpl implements ChannelListPresenter, GetChannelsInteractor.Callback {
    private final GetChannelsInteractor getChannelsInteractor;
    private final ChannelListItemViewModelMapper channelListItemViewModelMapper;
    private final GetVideosByStationInteractor getVideosByStationInteractor;
    private final VideoListItemViewModelMapper videoListItemViewModelMapper;
    private ChannelListView view;

    @Inject
    public ChannelListPresenterImpl(GetChannelsInteractor getChannelsInteractor,
                                    ChannelListItemViewModelMapper channelListItemViewModelMapper,
                                    GetVideosByStationInteractor getVideosByStationInteractor,
                                    VideoListItemViewModelMapper videoListItemViewModelMapper) {
        this.getChannelsInteractor = getChannelsInteractor;
        this.channelListItemViewModelMapper = channelListItemViewModelMapper;
        this.getVideosByStationInteractor = getVideosByStationInteractor;
        this.videoListItemViewModelMapper = videoListItemViewModelMapper;
    }

    @Override
    public void setView(ChannelListView view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        view = null;
    }

    @Override
    public void getStations() {
        getChannelsInteractor.execute(this);
    }

    @Override
    public void onChannelClicked(ChannelListItemViewModel channelListItemViewModel, ImageView imageView) {
        getVideosByStationInteractor.execute(channelListItemViewModel.getJsonURL(), new GetVideosByStationInteractor.Callback() {
            @Override
            public void onSuccess(List<Video> videos) {
                view.navigateToVideo(videoListItemViewModelMapper.map(videos.get(0)), channelListItemViewModel.getId(), imageView);
            }
        });
    }

    @Override
    public void onSuccess(List<Channel> channels) {
        List<ChannelListItemViewModel> channelListItemViewModels
                = channelListItemViewModelMapper.map(channels);
        view.hideRefresh();
        view.showStations(channelListItemViewModels);
    }
}
