package com.codesyntax.jarrion.ui.main.presenter;

import com.codesyntax.jarrion.domain.interactor.EnableNotificationsInteractor;

import javax.inject.Inject;

public class MainPresenterImpl implements MainPresenter {
    private final EnableNotificationsInteractor enableNotificationsInteractor;

    @Inject
    public MainPresenterImpl(EnableNotificationsInteractor enableNotificationsInteractor) {
        this.enableNotificationsInteractor = enableNotificationsInteractor;
    }

    @Override
    public void setNoitificationsEnabled(boolean enabled) {
        enableNotificationsInteractor.execute(enabled, updated -> {

        });
    }
}
