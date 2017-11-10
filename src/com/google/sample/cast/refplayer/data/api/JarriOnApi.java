package com.google.sample.cast.refplayer.data.api;

import com.google.sample.cast.refplayer.data.model.ChannelDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JarriOnApi {
    @GET("/api/1.0/channels.json")
    public Call<List<ChannelDataModel>> getChannels();
}
