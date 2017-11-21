package com.google.sample.cast.refplayer.di.component;

import com.google.sample.cast.refplayer.JarriOnApplication;
import com.google.sample.cast.refplayer.data.api.CategoryApi;
import com.google.sample.cast.refplayer.data.api.JarriOnApi;
import com.google.sample.cast.refplayer.data.model.ChannelDataModelMapper;
import com.google.sample.cast.refplayer.data.model.VideoDataModelMapper;
import com.google.sample.cast.refplayer.data.service.ChannelService;
import com.google.sample.cast.refplayer.data.service.VideoService;
import com.google.sample.cast.refplayer.di.module.ApiModule;
import com.google.sample.cast.refplayer.di.module.DataMapperModule;
import com.google.sample.cast.refplayer.di.module.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ServiceModule.class, DataMapperModule.class, ApiModule.class})
public interface ApplicationComponent {
    void inject(JarriOnApplication app);
    //SERVICES
    VideoService getVideoService();
    ChannelService getChannelService();
    //MAPPERS
    VideoDataModelMapper getVideoDataModelMapper();
    ChannelDataModelMapper getChannelDataModelMapper();
    //APIS
    CategoryApi getCategoryApi();
    JarriOnApi getJarriOnApi();
}
