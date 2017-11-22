package com.google.sample.cast.refplayer.navigation;

import android.content.Context;

public interface ChannelActivityNavigator {
    String EXTRA_JSON_URL = "extra_json_url";
    void navigate(Context context, String jsonURL);
}
