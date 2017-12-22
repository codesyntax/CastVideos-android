package com.codesyntax.jarrion.domain.interactor;

import android.text.TextUtils;

import com.codesyntax.jarrion.data.preferences.DevicePreferences;
import com.codesyntax.jarrion.data.service.TokenService;
import com.google.firebase.iid.FirebaseInstanceId;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class EnableNotificationsInteractorImpl implements EnableNotificationsInteractor {
    private final TokenService tokenService;
    private final DevicePreferences devicePreferences;

    @Inject
    public EnableNotificationsInteractorImpl(TokenService tokenService, DevicePreferences devicePreferences) {
        this.tokenService = tokenService;
        this.devicePreferences = devicePreferences;
    }

    @Override
    public void execute(boolean enabled, Callback callback) {
        String deviceId = devicePreferences.getJarrionDeviceId();
        String token = FirebaseInstanceId.getInstance().getToken();
        Observable
                .just(1L)
                .flatMap(Long -> Observable.just(updateToken(enabled, deviceId, token)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean updated) {
                        if (updated) {
                            devicePreferences.setNotificationStatus(enabled);
                            callback.onSuccess(updated);
                        }
                        callback.onSuccess(updated);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private boolean updateToken(boolean enabled, String deviceId, String token) {
        boolean result = false;
        if (TextUtils.isEmpty(deviceId)) {
            deviceId = tokenService.registerToken(token);
            if (deviceId != null) {
                result = tokenService.updateToken(token, deviceId, enabled);
            }
        } else {
            result = tokenService.updateToken(token, deviceId, enabled);
        }
        return result;
    }
}
