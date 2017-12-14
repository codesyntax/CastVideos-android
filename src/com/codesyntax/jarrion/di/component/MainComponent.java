package com.codesyntax.jarrion.di.component;

import com.codesyntax.jarrion.di.module.MainModule;
import com.codesyntax.jarrion.di.scope.ActivityScope;
import com.google.sample.cast.refplayer.di.component.ApplicationComponent;
import com.codesyntax.jarrion.ui.main.View.MainActivity;

import dagger.Component;

@ActivityScope
@Component(modules = MainModule.class, dependencies = ApplicationComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
