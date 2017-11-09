package com.google.sample.cast.refplayer.di.module;

import com.google.sample.cast.refplayer.data.service.VideoService;
import com.google.sample.cast.refplayer.data.service.VideoServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {

    @Singleton
    @Provides
    VideoService provideVideoService(VideoServiceImpl service) {
        return service;
    }
}
