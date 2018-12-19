package com.google.sample.cast.refplayer.domain.interactor;

import com.google.sample.cast.refplayer.data.model.LivestreamDataModelMapper;
import com.google.sample.cast.refplayer.data.service.ChannelService;
import com.google.sample.cast.refplayer.domain.model.Livestream;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class GetLivestreamInteractorImpl implements GetLivestreamInteractor {
    private final ChannelService channelService;
    private final LivestreamDataModelMapper livestreamDataModelMapper;

    @Inject
    public GetLivestreamInteractorImpl(ChannelService channelService,
                                       LivestreamDataModelMapper livestreamDataModelMapper) {
        this.channelService = channelService;
        this.livestreamDataModelMapper = livestreamDataModelMapper;
    }

    @Override
    public void execute(Callback callback) {
        Observable
                .just(1L)
                .flatMap(Long ->
                        Observable.just(
                                channelService.getLivestream()
                        ))
                .flatMap(channelDataModels -> Observable
                        .just(livestreamDataModelMapper.map(channelDataModels)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Livestream>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Livestream livestream) {
                        callback.onSuccess(livestream);
                    }

                    @Override
                    public void onError(Throwable e) {
                        //TODO add error handling
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
