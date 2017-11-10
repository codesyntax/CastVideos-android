package com.google.sample.cast.refplayer.domain.interactor;

import com.google.sample.cast.refplayer.data.model.VideoDataModelMapper;
import com.google.sample.cast.refplayer.data.service.VideoService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GetVideosByStationInteractorImpl implements GetVideosByStationInteractor {

    private final VideoService videoService;
    private final VideoDataModelMapper videoDataModelMapper;

    @Inject
    public GetVideosByStationInteractorImpl(VideoService videoService,
                                            VideoDataModelMapper videoDataModelMapper) {
        this.videoService = videoService;
        this.videoDataModelMapper = videoDataModelMapper;
    }

    @Override
    public void execute(final Callback callback) {
        Observable
                .just(1L)
                .flatMap(Long -> Observable.just(videoService.getVideos()))
                .flatMap(videoDataModels -> Observable.just(videoDataModelMapper.map(videoDataModels)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(callback::onSuccess);
    }
}
