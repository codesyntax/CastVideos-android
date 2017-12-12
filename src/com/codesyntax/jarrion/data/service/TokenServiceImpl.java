package com.codesyntax.jarrion.data.service;

import com.google.sample.cast.refplayer.data.api.JarriOnApi;

import java.io.IOException;

import javax.inject.Inject;

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
            result = jarriOnApi.registerToken(token).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String updateToken(String deviceId, String token) {
        String result = null;
        try {
            result = jarriOnApi.updateToken(deviceId, token).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
