package com.google.sample.cast.refplayer.ui.channel.presenter;

import com.google.sample.cast.refplayer.domain.interactor.GetLivestreamInteractor;
import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModelMapper;
import com.google.sample.cast.refplayer.ui.channel.view.StationView;
import javax.inject.Inject;

public class LivestreamPresenterImpl implements LivestreamPresenter {
    private final VideoListItemViewModelMapper videoListItemViewModelMapper;
    private final GetLivestreamInteractor getLivestreamInteractor;
    private StationView view;

    @Inject
    public LivestreamPresenterImpl(GetLivestreamInteractor getLivestreamInteractor,
                                   VideoListItemViewModelMapper videoListItemViewModelMapper) {
        this.getLivestreamInteractor = getLivestreamInteractor;
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
    public void getLivestream() {
        getLivestreamInteractor.execute( livestream -> {
            view.showCover(livestream.getCoverURL());
            view.showVideos(videoListItemViewModelMapper.map(livestream));
        });
    }
}
