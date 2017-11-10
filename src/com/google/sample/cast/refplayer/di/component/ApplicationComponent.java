package com.google.sample.cast.refplayer.di.component;

import com.google.sample.cast.refplayer.JarriOnApplication;
import com.google.sample.cast.refplayer.data.model.VideoDataModelMapper;
import com.google.sample.cast.refplayer.data.service.VideoService;
import com.google.sample.cast.refplayer.di.module.DataMapperModule;
import com.google.sample.cast.refplayer.di.module.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ServiceModule.class, DataMapperModule.class})
public interface ApplicationComponent {
    void inject(JarriOnApplication app);
    VideoService getVideoService();
    VideoDataModelMapper getVideoDataModelMapper();
}
