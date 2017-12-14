package com.codesyntax.jarrion.domain.interactor;

import com.codesyntax.jarrion.data.preferences.DevicePreferences;
import com.codesyntax.jarrion.data.service.TokenService;

import javax.inject.Inject;

public class UpdateTokenInteractorImpl implements UpdateTokenInteractor {
    private final TokenService tokenService;
    private final DevicePreferences devicePreferences;

    @Inject
    public UpdateTokenInteractorImpl(TokenService tokenService, DevicePreferences devicePreferences) {
        this.tokenService = tokenService;
        this.devicePreferences = devicePreferences;
    }

    @Override
    public void execute(String token, boolean notificationStatus, Callback callback) {
        String deviceId = devicePreferences.getJarrionDeviceId();
        boolean updated = tokenService.updateToken(token, deviceId, notificationStatus);
        if (updated) {
            devicePreferences.setNotificationStatus(notificationStatus);
            callback.onSuccess(updated);
        }
    }
}
