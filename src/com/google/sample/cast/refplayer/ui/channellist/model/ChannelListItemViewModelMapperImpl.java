package com.google.sample.cast.refplayer.ui.channellist.model;

import com.google.sample.cast.refplayer.domain.model.Channel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ChannelListItemViewModelMapperImpl implements ChannelListItemViewModelMapper {

    @Inject
    public ChannelListItemViewModelMapperImpl() {}

    @Override
    public ChannelListItemViewModel map(Channel source) {
        return new ChannelListItemViewModel.Builder()
                .id(source.getId())
                .name(source.getName())
                .coverURL(source.getMosaicCoverURL())
                .jsonURL(source.getJsonURL())
                .build();
    }

    @Override
    public List<ChannelListItemViewModel> map(List<Channel> source) {
        List<ChannelListItemViewModel> result = new ArrayList<>();
        for (Channel channel : source) {
            result.add(map(channel));
        }
        return result;
    }
}
