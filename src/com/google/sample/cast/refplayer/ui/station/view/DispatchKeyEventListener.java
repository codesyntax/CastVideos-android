package com.google.sample.cast.refplayer.ui.station.view;

import android.support.annotation.NonNull;
import android.view.KeyEvent;

public interface DispatchKeyEventListener {
    boolean dispatchKeyEvent(@NonNull KeyEvent event);
}
