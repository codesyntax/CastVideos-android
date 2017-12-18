package com.google.sample.cast.refplayer.data.model;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.sample.cast.refplayer.domain.model.Video;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

public class VideoDataModelMapperImpl implements VideoDataModelMapper {

    @Inject
    public VideoDataModelMapperImpl() {}

    @Override
    public Video map(VideoDataModel source, CategoryDataModel categoryDataModel) {
        String imageBaseURL = categoryDataModel.getImages();
        String videoBaseURL = categoryDataModel.getMp4();
        return new Video.Builder()
                .id(source.getVideoid())
                .title(source.getTitle())
                .description(source.getSubtitle())
                .bigCoverURL(imageBaseURL + source.getBigImageURL())
                .smallCoverURL(imageBaseURL + source.getSmallImageURL())
                .thumbnailURL(imageBaseURL + source.getThumb())
                .videoURL(videoBaseURL + source.getSources().get(0).getUrl())
                .studio(source.getStudio())
                .duration(source.getDuration())
                .date(getDate(source.getDate()))
                .mimeType(source.getSources().get(0).getMime())
                .build();
    }

    private Date getDate(String date) {
        if (date == null) {
            return null;
        }
        Date result = null;
        ParsePosition parsePosition = new ParsePosition(0);
        try {
            result = ISO8601Utils.parse(date, parsePosition);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Video> map(CategoryDataModel source) {
        List<Video> result = new ArrayList<>();
        for (VideoDataModel videoDataModel : source.getVideos()) {
            result.add(map(videoDataModel, source));
        }
        return result;
    }
}
