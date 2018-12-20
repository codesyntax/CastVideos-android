package com.google.sample.cast.refplayer.ui.channel.model;

import com.google.sample.cast.refplayer.domain.model.Livestream;
import com.google.sample.cast.refplayer.domain.model.LivestreamItem;
import com.google.sample.cast.refplayer.domain.model.Video;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

public class VideoListItemViewModelMapperImpl implements VideoListItemViewModelMapper {

    @Inject
    public VideoListItemViewModelMapperImpl() {}

    @Override
    public VideoListItemViewModel map(Video source) {
        return new VideoListItemViewModel.Builder()
                .id(source.getId())
                .title(source.getTitle())
                .description(source.getDescription())
                .coverURL(source.getSmallCoverURL())
                .thumbnailURL(source.getTumbnailURL())
                .videoURL(source.getVideoURL())
                .studio(source.getStudio())
                .duration(source.getDuration())
                .date(source.getDate())
                .mimetype(source.getMimeType())
                .build();
    }

    @Override
    public List<VideoListItemViewModel> map(List<Video> source) {
        List<VideoListItemViewModel> result = new ArrayList<>();
        for (Video video : source) {
            result.add(map(video));
        }
        return result;
    }

    @Override
    public List<VideoListItemViewModel> map(Livestream source) {
        List<VideoListItemViewModel> result = new ArrayList<>();
        for (LivestreamItem item: source.getItems()) {
            result.add(new VideoListItemViewModel.Builder()
                           .title(item.getName())
                           .description(item.getDescription())
                           .coverURL(item.getCoverURL())
                           .thumbnailURL(item.getMosaicCoverURL())
                           .videoURL(item.getUrl())
                           .begin(item.getBegin())
                           .end(item.getEnd())
                           .playable(item.getBegin().before(Calendar.getInstance().getTime()) && item.getEnd().after(Calendar.getInstance().getTime()))
                           .live(true)
                           .build());
        }
        return result;
    }
}
