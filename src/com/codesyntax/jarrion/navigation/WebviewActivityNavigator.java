package com.codesyntax.jarrion.navigation;

import android.content.Context;

public interface WebviewActivityNavigator {
    String EXTRA_URL = "extra_url";
    void navigate(Context context, String url);
}
