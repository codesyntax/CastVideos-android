package com.codesyntax.jarrion.di.component;

import com.codesyntax.jarrion.service.instanceid.JarrionInstanceIDService;
import com.codesyntax.jarrion.di.module.InstanceIDModule;
import com.codesyntax.jarrion.di.scope.ServiceScope;
import com.google.sample.cast.refplayer.di.component.ApplicationComponent;

import dagger.Component;

@ServiceScope
@Component(modules = InstanceIDModule.class, dependencies = ApplicationComponent.class)
public interface InstanceIDComponent {
    void inject(JarrionInstanceIDService service);
}
