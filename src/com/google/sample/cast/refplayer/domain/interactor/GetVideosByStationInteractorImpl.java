package com.google.sample.cast.refplayer.domain.interactor;

import android.util.Log;

import com.google.sample.cast.refplayer.data.model.VideoDataModelMapper;
import com.google.sample.cast.refplayer.data.service.VideoService;
import com.google.sample.cast.refplayer.domain.model.Video;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
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
    public void execute(String url, final Callback callback) {
        Observable
                .just(1L)
                .flatMap(Long -> Observable.just(videoService.getVideos(url)))
                .flatMap(categoryDataModel -> Observable
                        .just(videoDataModelMapper.map(categoryDataModel)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Video>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //NO-OP
                    }

                    @Override
                    public void onNext(List<Video> videos) {
                        callback.onSuccess(videos);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("","");
                        //TODO make error response
                    }

                    @Override
                    public void onComplete() {
                        //NO-OP
                    }
                });
    }
}
