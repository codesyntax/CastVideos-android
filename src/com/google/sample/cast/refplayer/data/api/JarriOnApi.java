package com.google.sample.cast.refplayer.data.api;

import com.google.sample.cast.refplayer.data.model.ChannelsResponseDataModel;
import com.google.sample.cast.refplayer.data.model.LivestreamResponse;
import com.google.sample.cast.refplayer.data.model.RegisterDeviceRequestBody;
import com.google.sample.cast.refplayer.data.model.RegisterDeviceResponse;
import com.google.sample.cast.refplayer.data.model.UpdateDeviceRequestBody;
import com.google.sample.cast.refplayer.data.model.UpdateDeviceResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JarriOnApi {
    @GET("api/1.0/channels.json")
    Call<ChannelsResponseDataModel> getChannels();

    @POST("api/1.0/register-device")
    Call<RegisterDeviceResponse> registerDevice(@Body RegisterDeviceRequestBody body);

    @POST("api/1.0/update-device")
    Call<UpdateDeviceResponse> updateDevice(@Body UpdateDeviceRequestBody body);

    @GET("api/1.0/livestreams.json")
    Call<LivestreamResponse> getLivestream();
}
