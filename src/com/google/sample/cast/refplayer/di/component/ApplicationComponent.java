package com.google.sample.cast.refplayer.di.component;

import com.google.sample.cast.refplayer.JarriOnApplication;
import com.google.sample.cast.refplayer.data.api.CategoryApi;
import com.google.sample.cast.refplayer.data.api.JarriOnApi;
import com.google.sample.cast.refplayer.data.model.ChannelDataModelMapper;
import com.google.sample.cast.refplayer.data.model.VideoDataModelMapper;
import com.codesyntax.jarrion.data.preferences.DevicePreferences;
import com.google.sample.cast.refplayer.data.service.ChannelService;
import com.google.sample.cast.refplayer.data.service.VideoService;
import com.google.sample.cast.refplayer.di.module.ApiModule;
import com.google.sample.cast.refplayer.di.module.DataMapperModule;
import com.codesyntax.jarrion.di.module.PreferencesModule;
import com.google.sample.cast.refplayer.di.module.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ServiceModule.class, DataMapperModule.class, ApiModule.class, PreferencesModule.class})
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
    //PREFERENCES
    DevicePreferences getDevicePreferences();
}
