package com.google.sample.cast.refplayer.di.component;

import com.codesyntax.jarrion.di.scope.FragmentScope;
import com.google.sample.cast.refplayer.di.module.ChannelModule;
import com.google.sample.cast.refplayer.di.module.LivestreamModule;
import com.google.sample.cast.refplayer.ui.channel.view.ChannelFragment;
import com.google.sample.cast.refplayer.ui.channel.view.LivestreamFragment;
import dagger.Component;

@FragmentScope
@Component(modules = LivestreamModule.class, dependencies = ApplicationComponent.class)
public interface LivestreamComponent {
    void inject(LivestreamFragment fragment);
}
