package com.google.sample.cast.refplayer.data.model;

import com.google.sample.cast.refplayer.domain.model.Channel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ChannelDataModelMapperImpl implements ChannelDataModelMapper {

    @Inject
    public ChannelDataModelMapperImpl() {}

    @Override
    public Channel map(ChannelDataModel source) {
        return new Channel.Builder()
                .id(String.valueOf(source.getId()))
                .name(source.getTitle())
                .mosaicCoverURL(source.getMosaicURL())
                .coverURL(source.getDisplayURL())
                .jsonURL(source.getSourceJsonURL())
                .build();
    }

    @Override
    public List<Channel> map(List<ChannelDataModel> source) {
        List<Channel> result = new ArrayList<>();
        for (ChannelDataModel channelDataModel : source) {
            result.add(map(channelDataModel));
        }
        return result;
    }
}
