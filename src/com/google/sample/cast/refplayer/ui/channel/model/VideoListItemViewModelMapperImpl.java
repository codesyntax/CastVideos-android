package com.google.sample.cast.refplayer.ui.channel.model;

import com.google.sample.cast.refplayer.domain.model.Video;

import java.util.ArrayList;
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
}
