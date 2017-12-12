package com.google.sample.cast.refplayer.data.api;

import com.google.sample.cast.refplayer.data.model.ChannelsResponseDataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JarriOnApi {
    @GET("api/1.0/channels.json")
    Call<ChannelsResponseDataModel> getChannels();

    //TODO change to real info
    @POST("/api/1.0/register-device")
    Call<String> registerToken(String token);

    //TODO change to real info
    @POST("/api/1.0/register-device")
    Call<String> updateToken(String deviceId, String token);
}
