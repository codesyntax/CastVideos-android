package com.google.sample.cast.refplayer.di.component;

import com.google.sample.cast.refplayer.di.module.StationListModule;
import com.google.sample.cast.refplayer.di.scope.FragmentScope;
import com.google.sample.cast.refplayer.ui.stationlist.view.StationListFragment;

import dagger.Component;

@FragmentScope
@Component(modules = StationListModule.class)
public interface StationListComponent {
    void inject(StationListFragment fragment);
}
