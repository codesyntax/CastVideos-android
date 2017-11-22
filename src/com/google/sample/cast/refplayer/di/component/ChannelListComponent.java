package com.google.sample.cast.refplayer.di.component;

import com.google.sample.cast.refplayer.di.module.ChannelListModule;
import com.google.sample.cast.refplayer.di.scope.FragmentScope;
import com.google.sample.cast.refplayer.ui.channellist.view.ChannelListFragment;

import dagger.Component;

@FragmentScope
@Component(modules = ChannelListModule.class, dependencies = ApplicationComponent.class)
public interface ChannelListComponent {
    void inject(ChannelListFragment fragment);
}
