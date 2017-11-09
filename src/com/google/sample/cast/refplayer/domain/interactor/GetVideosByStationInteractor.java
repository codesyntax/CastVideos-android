package com.google.sample.cast.refplayer.domain.interactor;

import com.google.sample.cast.refplayer.domain.model.Video;

import java.util.List;

public interface GetVideosByStationInteractor {
    void execute(Callback callback);

    interface Callback {
        void onSuccess(List<Video> stations);
    }
}
