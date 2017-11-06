package com.google.sample.cast.refplayer.navigation;

import android.content.Context;

public interface VideoBrowserActivityNavigator {
    public static final String EXTRA_ID = "extra_id";
    void navigate(Context context, int id);
}
