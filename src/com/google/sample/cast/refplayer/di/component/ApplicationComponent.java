package com.google.sample.cast.refplayer.di.component;

import com.google.sample.cast.refplayer.JarriOnApplication;
import com.google.sample.cast.refplayer.data.service.VideoService;
import com.google.sample.cast.refplayer.di.module.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ServiceModule.class)
public interface ApplicationComponent {
    void inject(JarriOnApplication app);
    VideoService getVideoService();
}
