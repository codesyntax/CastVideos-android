package com.google.sample.cast.refplayer.data.service;

import com.google.sample.cast.refplayer.data.api.JarriOnApi;
import com.google.sample.cast.refplayer.data.model.ChannelDataModel;
import com.google.sample.cast.refplayer.data.model.LivestreamResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class ChannelServiceImpl implements ChannelService {
    private final JarriOnApi jarriOnApi;

    @Inject
    public ChannelServiceImpl(JarriOnApi jarriOnApi) {
        this.jarriOnApi = jarriOnApi;
    }

    @Override
    public List<ChannelDataModel> getChannels() {
        List<ChannelDataModel> response = new ArrayList<>();
        try {
            response = jarriOnApi.getChannels()
                    .execute()
                    .body().getData().getChannels();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public LivestreamResponse getLivestream() {
        LivestreamResponse response = null;
        try {
            response = jarriOnApi.getLivestream().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
