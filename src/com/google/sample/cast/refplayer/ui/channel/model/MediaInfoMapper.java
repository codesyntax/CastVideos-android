package com.google.sample.cast.refplayer.ui.channel.model;

import com.google.android.gms.cast.MediaInfo;

public interface MediaInfoMapper {
    MediaInfo map(String channelId, VideoListItemViewModel source);
}
