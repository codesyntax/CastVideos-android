package com.google.sample.cast.refplayer;

import android.app.Application;

import com.google.sample.cast.refplayer.di.component.DaggerApplicationComponent;

public class JarriOnApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.builder().build().inject(this);
    }
}
