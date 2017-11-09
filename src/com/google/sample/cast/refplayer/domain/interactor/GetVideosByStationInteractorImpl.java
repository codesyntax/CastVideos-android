package com.google.sample.cast.refplayer.domain.interactor;

import javax.inject.Inject;

public class GetVideosByStationInteractorImpl implements GetVideosByStationInteractor {
    private Callback callback;

    @Inject
    public GetVideosByStationInteractorImpl() {
    }

    @Override
    public void execute(Callback callback) {
        this.callback = callback;
    }
}
