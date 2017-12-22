package com.codesyntax.jarrion.ui.main.presenter;

import com.codesyntax.jarrion.domain.interactor.EnableNotificationsInteractor;
import com.codesyntax.jarrion.domain.interactor.RegisterDeviceInteractor;

import javax.inject.Inject;

public class MainPresenterImpl implements MainPresenter {
    private final EnableNotificationsInteractor enableNotificationsInteractor;
    private final RegisterDeviceInteractor registerDeviceInteractor;

    @Inject
    public MainPresenterImpl(EnableNotificationsInteractor enableNotificationsInteractor, RegisterDeviceInteractor registerDeviceInteractor) {
        this.enableNotificationsInteractor = enableNotificationsInteractor;
        this.registerDeviceInteractor = registerDeviceInteractor;
    }

    @Override
    public void setNoitificationsEnabled(boolean enabled) {
        enableNotificationsInteractor.execute(enabled, updated -> {

        });
    }

    @Override
    public void registerDeviceId() {
        registerDeviceInteractor.execute(() -> {});
    }
}
