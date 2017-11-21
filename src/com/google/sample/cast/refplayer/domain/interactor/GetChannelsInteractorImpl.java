package com.google.sample.cast.refplayer.domain.interactor;

import com.google.sample.cast.refplayer.data.model.ChannelDataModelMapper;
import com.google.sample.cast.refplayer.data.service.ChannelService;
import com.google.sample.cast.refplayer.domain.model.Channel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GetChannelsInteractorImpl implements GetChannelsInteractor {
    private final ChannelService channelService;
    private final ChannelDataModelMapper channelDataModelMapper;

    @Inject
    public GetChannelsInteractorImpl(ChannelService channelService,
                                     ChannelDataModelMapper channelDataModelMapper) {
        this.channelService = channelService;
        this.channelDataModelMapper = channelDataModelMapper;
    }

    @Override
    public void execute(Callback callback) {
        Observable
                .just(1L)
                .flatMap(Long ->
                        Observable.just(
                                channelService.getChannels()
                        ))
                .flatMap(channelDataModels -> Observable
                        .just(channelDataModelMapper.map(channelDataModels)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Channel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<Channel> channels) {
                        callback.onSuccess(channels);
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
