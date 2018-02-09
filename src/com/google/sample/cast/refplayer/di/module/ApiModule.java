package com.google.sample.cast.refplayer.di.module;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.sample.cast.refplayer.data.api.CategoryApi;
import com.google.sample.cast.refplayer.data.api.JarriOnApi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    @Named(NAME_JARRI_ON)
    Retrofit provideJarriOnRetrofit() {
        String baseURL = "https://jarrion.eus/";
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor()).build())
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
