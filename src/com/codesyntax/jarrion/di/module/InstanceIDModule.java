package com.codesyntax.jarrion.di.module;

import com.codesyntax.jarrion.di.scope.ServiceScope;
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
}
