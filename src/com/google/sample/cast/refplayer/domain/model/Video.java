package com.google.sample.cast.refplayer.domain.model;

import java.util.Date;

public class Video {
    private String title;
    private String videoURL;
    private Date date;
    private String description;
    private String tumbnailURL;
    private long duration;
    private String smallCoverURL;
    private String bigCoverURL;
    private String studio;
    private String mimeType;

    private Video(Builder builder) {
        title = builder.title;
        videoURL = builder.videoURL;
        date = builder.date;
        description = builder.description;
        tumbnailURL = builder.tumbnailURL;
        duration = builder.duration;
        smallCoverURL = builder.smallCoverURL;
        bigCoverURL = builder.bigCoverURL;
        studio = builder.studio;
        mimeType = builder.mimeType;
    }

    public String getTitle() {
        return title;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getTumbnailURL() {
        return tumbnailURL;
    }

    public long getDuration() {
        return duration;
    }

    public String getSmallCoverURL() {
        return smallCoverURL;
    }

    public String getBigCoverURL() {
        return bigCoverURL;
    }

    public String getStudio() {
        return studio;
    }

    public String getMimeType() {
        return mimeType;
    }

    public static final class Builder {
        private String title;
        private String videoURL;
        private Date date;
        private String description;
        private String tumbnailURL;
        private long duration;
        private String smallCoverURL;
        private String bigCoverURL;
        private String studio;
        private String mimeType;

        public Builder() {
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder videoURL(String val) {
            videoURL = val;
            return this;
        }

        public Builder date(Date val) {
            date = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder tumbnailURL(String val) {
            tumbnailURL = val;
            return this;
        }

        public Builder thumbnailURL(String val) {
            tumbnailURL = val;
            return this;
        }

        public Builder duration(long val) {
            duration = val;
            return this;
        }

        public Builder smallCoverURL(String val) {
            smallCoverURL = val;
            return this;
        }

        public Builder bigCoverURL(String val) {
            bigCoverURL = val;
            return this;
        }

        public Builder studio(String val) {
            studio = val;
            return this;
        }

        public Builder mimeType(String val) {
            mimeType = val;
            return this;
        }

        public Video build() {
            return new Video(this);
        }
    }
}
