package com.google.sample.cast.refplayer.di.component;

import com.google.sample.cast.refplayer.di.module.StationModule;
import com.google.sample.cast.refplayer.di.scope.FragmentScope;
import com.google.sample.cast.refplayer.ui.station.view.StationFragment;

import dagger.Component;

@FragmentScope
@Component(modules = StationModule.class)
public interface StationComponent {
    void inject(StationFragment fragment);
}
