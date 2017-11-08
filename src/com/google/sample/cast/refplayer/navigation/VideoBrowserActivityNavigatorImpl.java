package com.google.sample.cast.refplayer.navigation;

import android.content.Context;
import android.content.Intent;

import com.google.sample.cast.refplayer.ui.station.view.StationActivity;

import javax.inject.Inject;

public class VideoBrowserActivityNavigatorImpl implements VideoBrowserActivityNavigator {
    @Inject
    public VideoBrowserActivityNavigatorImpl() {}

    @Override
    public void navigate(Context context, int id) {
        Intent intent = getNavigationIntent(context, id);
        context.startActivity(intent);
    }

    private Intent getNavigationIntent(Context context, int id) {
        Intent result = new Intent(context, StationActivity.class);
        result.putExtra(EXTRA_ID, id);
        return result;
    }
}
