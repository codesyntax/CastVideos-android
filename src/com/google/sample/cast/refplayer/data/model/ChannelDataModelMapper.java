package com.google.sample.cast.refplayer.data.model;

import com.google.sample.cast.refplayer.domain.model.Channel;

import java.util.List;

public interface ChannelDataModelMapper {

    Channel map(ChannelDataModel source);

    List<Channel> map(List<ChannelDataModel> source);
}
