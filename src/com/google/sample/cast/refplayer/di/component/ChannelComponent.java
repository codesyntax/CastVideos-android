package com.google.sample.cast.refplayer.di.component;

import com.google.sample.cast.refplayer.di.module.ChannelModule;
import com.google.sample.cast.refplayer.di.scope.FragmentScope;
import com.google.sample.cast.refplayer.ui.channel.view.ChannelFragment;

import dagger.Component;

@FragmentScope
@Component(modules = ChannelModule.class, dependencies = ApplicationComponent.class)
public interface ChannelComponent {
    void inject(ChannelFragment fragment);
}
