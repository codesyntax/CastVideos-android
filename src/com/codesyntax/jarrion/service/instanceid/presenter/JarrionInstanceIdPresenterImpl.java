package com.codesyntax.jarrion.service.instanceid.presenter;

import com.codesyntax.jarrion.domain.interactor.RegisterTokenInteractor;

import javax.inject.Inject;

public class JarrionInstanceIdPresenterImpl implements JarrionInstanceIdPresenter {
    private final RegisterTokenInteractor tokenInteractor;

    @Inject
    public JarrionInstanceIdPresenterImpl(RegisterTokenInteractor tokenInteractor) {
        this.tokenInteractor = tokenInteractor;
    }

    @Override
    public void registerToken(String token) {
        tokenInteractor.execute(token, deviceId -> {

        });
    }
}
