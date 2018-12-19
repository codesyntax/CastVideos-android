package com.google.sample.cast.refplayer.data.service;

import com.google.sample.cast.refplayer.data.model.ChannelDataModel;

import com.google.sample.cast.refplayer.data.model.LivestreamResponse;
import java.util.List;

public interface ChannelService {
    List<ChannelDataModel> getChannels();

    LivestreamResponse getLivestream();
}
