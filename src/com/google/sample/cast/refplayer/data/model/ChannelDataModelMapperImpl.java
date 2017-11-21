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
        return null;
    }

    @Override
    public List<Channel> map(List<ChannelDataModel> source) {
        return new ArrayList<>();
    }
}
