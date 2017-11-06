package com.google.sample.cast.refplayer.domain.interactor;

import com.google.sample.cast.refplayer.domain.model.Station;

import java.util.List;

public interface GetStationsInteractor {
    void execute(Callback callback);

    interface Callback {
        void onSuccess(List<Station> stations);
    }
}
