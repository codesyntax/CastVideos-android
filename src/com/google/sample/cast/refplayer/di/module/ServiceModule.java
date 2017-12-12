package com.google.sample.cast.refplayer.di.module;

import com.codesyntax.jarrion.data.service.TokenService;
import com.codesyntax.jarrion.data.service.TokenServiceImpl;
import com.google.sample.cast.refplayer.data.service.ChannelService;
import com.google.sample.cast.refplayer.data.service.ChannelServiceImpl;
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

    @Singleton
    @Provides
    ChannelService providesChannelService(ChannelServiceImpl service) {
        return service;
    }

    @Singleton
    @Provides
    TokenService proviceTokenService(TokenServiceImpl service) {
        return service;
    }
}
