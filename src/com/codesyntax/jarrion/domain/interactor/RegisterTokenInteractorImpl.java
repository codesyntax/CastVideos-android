package com.codesyntax.jarrion.domain.interactor;

import android.text.TextUtils;

import com.codesyntax.jarrion.data.preferences.DevicePreferences;
import com.codesyntax.jarrion.data.service.TokenService;

import javax.inject.Inject;

public class RegisterTokenInteractorImpl implements RegisterTokenInteractor {
    private final DevicePreferences devicePreferences;
    private final TokenService tokenService;

    @Inject
    public RegisterTokenInteractorImpl(DevicePreferences devicePreferences, TokenService tokenService) {
        this.devicePreferences = devicePreferences;
        this.tokenService = tokenService;
    }

    @Override
    public void execute(String token, Callback callback) {
        String deviceId = tokenService.registerToken(token);
        if (!TextUtils.isEmpty(deviceId)) {
            devicePreferences.setJarrionDeviceId(deviceId);
            callback.onSuccess(deviceId);
        }
    }
}
