package com.codesyntax.jarrion.navigation;

import android.content.Context;
import android.content.Intent;

import com.codesyntax.jarrion.ui.webview.WebviewActivity;

import javax.inject.Inject;

public class WebviewActivityNavigatorImpl implements WebviewActivityNavigator {
    @Inject
    public WebviewActivityNavigatorImpl() {
    }

    @Override
    public void navigate(Context context, String url) {
        Intent intent = getNavigationIntent(context, url);
        context.startActivity(intent);
    }

    private Intent getNavigationIntent(Context context, String url) {
        Intent intent = new Intent(context, WebviewActivity.class);
        intent.putExtra(EXTRA_URL, url);
        return intent;
    }
}
