package com.codesyntax.jarrion.data.service;

import com.google.sample.cast.refplayer.data.api.JarriOnApi;
import com.google.sample.cast.refplayer.data.model.RegisterDeviceRequestBody;
import com.google.sample.cast.refplayer.data.model.RegisterDeviceResponse;
import com.google.sample.cast.refplayer.data.model.UpdateDeviceRequestBody;
import com.google.sample.cast.refplayer.data.model.UpdateDeviceResponse;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Response;

public class TokenServiceImpl implements TokenService {
    private final JarriOnApi jarriOnApi;

    @Inject
    public TokenServiceImpl(JarriOnApi jarriOnApi) {
        this.jarriOnApi = jarriOnApi;
    }

    @Override
    public String registerToken(String token) {
        String result = null;
        try {
            RegisterDeviceRequestBody body = new RegisterDeviceRequestBody.Builder()
                    .pwtoken(token).build();
            RegisterDeviceResponse responseBody = jarriOnApi.registerDevice(body).execute().body();
            if (responseBody != null) {
                result = responseBody.getDeviceId();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateToken(String token, String deviceId, boolean notificationStatus) {
        boolean result = false;
        try {
            UpdateDeviceRequestBody body = new UpdateDeviceRequestBody.Builder()
                    .pwtoken(token)
                    .uuid(deviceId)
                    .notificationStatus(notificationStatus)
                    .build();
            UpdateDeviceResponse responseBody = jarriOnApi.updateDevice(body).execute().body();
            if (responseBody != null) {
                result = responseBody.isUpdated();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
