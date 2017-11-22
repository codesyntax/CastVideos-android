package com.google.sample.cast.refplayer.ui.channellist.model;

import com.google.sample.cast.refplayer.domain.model.Channel;

import java.util.List;

public interface ChannelListItemViewModelMapper {

    ChannelListItemViewModel map(Channel source);

    List<ChannelListItemViewModel> map(List<Channel> source);
}
