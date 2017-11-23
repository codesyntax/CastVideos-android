package com.google.sample.cast.refplayer.navigation;

import android.content.Context;

public interface ChannelActivityNavigator {
    String EXTRA_JSON_URL = "extra_json_url";
    String EXTRA_TITLE = "extra_title";
    String EXTRA_COVER_URL = "extra_cover_url";
    void navigate(Context context, String jsonURL, String title, String coverURL);
}
