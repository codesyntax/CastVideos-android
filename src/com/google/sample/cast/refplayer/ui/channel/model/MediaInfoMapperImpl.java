package com.google.sample.cast.refplayer.ui.channel.model;

import com.google.android.gms.cast.MediaInfo;
import com.google.sample.cast.refplayer.browser.VideoProvider;

import javax.inject.Inject;

public class MediaInfoMapperImpl implements MediaInfoMapper {

    @Inject
    public MediaInfoMapperImpl() {}

    @Override
    public MediaInfo map(String channelId, VideoListItemViewModel source) {
        return VideoProvider
                .buildMediaInfo(source.getTitle(),
                        source.getStudio(),
                        source.getDescription(),
                        (int) source.getDuration(),
                        source.getVideoURL(),
                        source.getMimetype(),
                        source.getThumbnailURL(),
                        source.getCoverURL(),
                        null,
                        source.getDate(),
                        source.getId(),
                        channelId);
    }
}
