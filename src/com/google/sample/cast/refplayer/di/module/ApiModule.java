package com.google.sample.cast.refplayer.di.module;

import com.google.sample.cast.refplayer.data.api.CategoryApi;
import com.google.sample.cast.refplayer.data.api.JarriOnApi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {
    private static final String NAME_CATEGORY = "Category";
    private static final String NAME_JARRI_ON = "JarriOn";

    @Singleton
    @Provides
    @Named(NAME_CATEGORY)
    Retrofit provideCategoryRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://ignore.ignore")
                .build();
    }

    @Singleton
    @Provides
    @Named(NAME_JARRI_ON)
    Retrofit provideJarriOnRetrofit() {
        String baseURL = "https://jarrion.korpoweb.com";
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .build();
    }

    @Singleton
    @Provides
    CategoryApi provideCategoryApi(@Named(NAME_CATEGORY) Retrofit retrofit) {
        return retrofit.create(CategoryApi.class);
    }

    @Singleton
    @Provides
    JarriOnApi provideJarriOnApi(@Named(NAME_JARRI_ON) Retrofit retrofit) {
        return retrofit.create(JarriOnApi.class);
    }
}
