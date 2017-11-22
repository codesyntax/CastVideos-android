package com.google.sample.cast.refplayer.domain.interactor;

import com.google.sample.cast.refplayer.domain.model.Video;

import java.util.List;

public interface GetVideosByStationInteractor {
    void execute(String url, Callback callback);

    interface Callback {
        void onSuccess(List<Video> videos);
    }
}
