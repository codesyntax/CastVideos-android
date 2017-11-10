package com.google.sample.cast.refplayer;

import android.app.Application;

import com.google.sample.cast.refplayer.di.component.ApplicationComponent;
import com.google.sample.cast.refplayer.di.component.DaggerApplicationComponent;

public class JarriOnApplication extends Application {
    private static JarriOnApplication instance;
    private ApplicationComponent component;

    public static JarriOnApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        component = DaggerApplicationComponent.builder().build();
        component.inject(this);
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
