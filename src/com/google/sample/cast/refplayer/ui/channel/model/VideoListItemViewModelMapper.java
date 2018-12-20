package com.google.sample.cast.refplayer.ui.channel.model;

import com.google.sample.cast.refplayer.domain.model.Livestream;
import com.google.sample.cast.refplayer.domain.model.Video;
import java.util.List;

public interface VideoListItemViewModelMapper {

    VideoListItemViewModel map(Video source, int channelType);

    List<VideoListItemViewModel> map(List<Video> sourc, int channelTypee);

    List<VideoListItemViewModel> map(Livestream source);
}
