package com.google.sample.cast.refplayer.navigation;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;

public interface ChannelActivityNavigator {
    String EXTRA_JSON_URL = "extra_json_url";
    String EXTRA_TITLE = "extra_title";
    void navigate(Context context, String jsonURL, String title, AppCompatTextView name);
}
