package com.codesyntax.jarrion.service.instanceid.presenter;

import android.text.TextUtils;

import com.codesyntax.jarrion.data.preferences.DevicePreferences;
import com.codesyntax.jarrion.domain.interactor.RegisterTokenInteractor;
import com.codesyntax.jarrion.domain.interactor.UpdateTokenInteractor;

import javax.inject.Inject;

public class JarrionInstanceIdPresenterImpl implements JarrionInstanceIdPresenter {
    private final RegisterTokenInteractor tokenInteractor;
    private final DevicePreferences devicePreferences;
    private final UpdateTokenInteractor updateTokenInteractor;

    @Inject
    public JarrionInstanceIdPresenterImpl(RegisterTokenInteractor tokenInteractor,
                                          DevicePreferences devicePreferences,
                                          UpdateTokenInteractor updateTokenInteractor) {
        this.tokenInteractor = tokenInteractor;
        this.devicePreferences = devicePreferences;
        this.updateTokenInteractor = updateTokenInteractor;
    }

    @Override
    public void registerToken(String token) {
        String deviceId = devicePreferences.getJarrionDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            tokenInteractor.execute(token, newDeviceId -> {

            });
        } else {
            boolean notificationStatus = devicePreferences.getNotificationStatus();
            updateTokenInteractor.execute(token, notificationStatus, updated -> {

            });
        }
    }
}
