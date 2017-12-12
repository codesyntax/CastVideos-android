package com.codesyntax.jarrion.di.module;

import com.codesyntax.jarrion.di.scope.ServiceScope;
import com.codesyntax.jarrion.domain.interactor.RegisterTokenInteractor;
import com.codesyntax.jarrion.domain.interactor.RegisterTokenInteractorImpl;
import com.codesyntax.jarrion.service.instanceid.presenter.JarrionInstanceIdPresenter;
import com.codesyntax.jarrion.service.instanceid.presenter.JarrionInstanceIdPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class InstanceIDModule {
    @ServiceScope
    @Provides
    JarrionInstanceIdPresenter provideJarrionInstanceIdPresenter(JarrionInstanceIdPresenterImpl presenter) {
        return presenter;
    }

    @ServiceScope
    @Provides
    RegisterTokenInteractor provdeRegisterTokenInteractor(RegisterTokenInteractorImpl interactor) {
        return interactor;
    }
}
