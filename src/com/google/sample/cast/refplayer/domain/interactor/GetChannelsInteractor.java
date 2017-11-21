package com.google.sample.cast.refplayer.domain.interactor;

import com.google.sample.cast.refplayer.domain.model.Channel;

import java.util.List;

public interface GetChannelsInteractor {
    void execute(Callback callback);

    interface Callback {
        void onSuccess(List<Channel> channels);
    }
}
