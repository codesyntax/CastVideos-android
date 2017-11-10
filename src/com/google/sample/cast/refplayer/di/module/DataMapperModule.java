package com.google.sample.cast.refplayer.di.module;

import com.google.sample.cast.refplayer.data.model.VideoDataModelMapper;
import com.google.sample.cast.refplayer.data.model.VideoDataModelMapperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataMapperModule {

    @Singleton
    @Provides
    VideoDataModelMapper provideVideoDataModelMapper(VideoDataModelMapperImpl mapper) {
        return mapper;
    }
}
