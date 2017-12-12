package com.codesyntax.jarrion.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.sample.cast.refplayer.JarriOnApplication;
import com.google.sample.cast.refplayer.R;
import com.codesyntax.jarrion.data.preferences.DevicePreferences;
import com.codesyntax.jarrion.data.preferences.DevicePreferencesImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PreferencesModule {
    @Singleton
    @Provides
    Context proivideContext() {
        return JarriOnApplication.getInstance();
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences(
                context.getString(R.string.key_shared_preferences),
                Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    DevicePreferences provideDevicePreferences(DevicePreferencesImpl devicePreferences) {
        return devicePreferences;
    }
}
