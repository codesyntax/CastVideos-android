package com.google.sample.cast.refplayer.ui.channel.presenter;

import com.google.sample.cast.refplayer.domain.interactor.GetVideosByStationInteractor;
import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModelMapper;
import com.google.sample.cast.refplayer.ui.channel.view.StationView;

import javax.inject.Inject;

public class ChannelPresenterImpl implements ChannelPresenter {
    private final GetVideosByStationInteractor getVideosByStationInteractor;
    private final VideoListItemViewModelMapper videoListItemViewModelMapper;
    private StationView view;

    @Inject
    public ChannelPresenterImpl(GetVideosByStationInteractor getVideosByStationInteractor,
                                VideoListItemViewModelMapper videoListItemViewModelMapper) {
        this.getVideosByStationInteractor = getVideosByStationInteractor;
        this.videoListItemViewModelMapper = videoListItemViewModelMapper;
    }

    @Override
    public void setView(StationView view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void getVideos(String url, int channelType) {
        getVideosByStationInteractor.execute(url, videos -> {
            if (view != null) {
                view.showVideos(videoListItemViewModelMapper.map(videos, channelType));
            }
        });
    }
}
