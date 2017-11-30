package com.google.sample.cast.refplayer.ui.channel.model;

import com.google.android.gms.cast.MediaInfo;
import com.google.sample.cast.refplayer.browser.VideoProvider;

import javax.inject.Inject;

public class MediaInfoMapperImpl implements MediaInfoMapper {

    @Inject
    public MediaInfoMapperImpl() {}

    @Override
    public MediaInfo map(VideoListItemViewModel source) {
        return VideoProvider
                .buildMediaInfo(source.getTitle(),
                        source.getStudio(),
                        source.getDescription(),
                        (int) source.getDuration(),
                        source.getVideoURL(),
                        //TODO set data from server
                        "video/mp4",
                        source.getThumbnailURL(),
                        source.getCoverURL(),
                        null,
                        source.getDate());
    }
}
