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
        String mosaicURL = source.getMosaicURL();
        return new Channel.Builder()
                .name(source.getTitle())
                .mosaicCoverURL(mosaicURL)
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
