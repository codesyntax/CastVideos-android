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

public class RegisterDeviceInteractorImpl implements RegisterDeviceInteractor {
    private final TokenService tokenService;
    private final DevicePreferences devicePreferences;

    @Inject
    public RegisterDeviceInteractorImpl(TokenService tokenService, DevicePreferences devicePreferences) {
        this.tokenService = tokenService;
        this.devicePreferences = devicePreferences;
    }

    @Override
    public void execute(Callback callback) {
        String deviceId = devicePreferences.getJarrionDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            String token = FirebaseInstanceId.getInstance().getToken();
            Observable
                    .just(1L)
                    .flatMap(Long -> Observable.just(tokenService.registerToken(token)))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<String>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(String newDeviceId) {
                            devicePreferences.setJarrionDeviceId(newDeviceId);
                            callback.onSuccess();
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } else {
            callback.onSuccess();
        }
    }
}
