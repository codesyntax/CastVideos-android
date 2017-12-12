package com.codesyntax.jarrion.data.preferences;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class DevicePreferencesImpl implements DevicePreferences {
    private static final String KEY_DEVICE_ID = "key_device_id";
    private static final String EMPTY = "";
    private final SharedPreferences preferences;

    @Inject
    public DevicePreferencesImpl(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public String getJarrionDeviceId() {
        String defaultValue = EMPTY;
        return preferences.getString(KEY_DEVICE_ID, defaultValue);
    }

    @Override
    public void setJarrionDeviceId(String deviceId) {
        preferences.edit().putString(KEY_DEVICE_ID, deviceId).apply();
    }
}
