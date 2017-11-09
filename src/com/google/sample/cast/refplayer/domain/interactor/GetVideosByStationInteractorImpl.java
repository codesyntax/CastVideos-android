package com.google.sample.cast.refplayer.domain.interactor;

import com.google.sample.cast.refplayer.data.model.VideoDataModel;
import com.google.sample.cast.refplayer.data.service.VideoService;
import com.google.sample.cast.refplayer.domain.model.Video;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class GetVideosByStationInteractorImpl implements GetVideosByStationInteractor {

    @Inject
    public GetVideosByStationInteractorImpl() {
    }

    @Override
    public void execute(final Callback callback) {
        Observable
                .just(1L)
                .flatMap((Function<Long, ObservableSource<List<VideoDataModel>>>) aLong -> null)
                .flatMap((Function<List<VideoDataModel>, ObservableSource<List<Video>>>) videoDataModels -> null)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(callback::onSuccess);
    }
}
