package com.google.sample.cast.refplayer.ui.channel.model;

public class VideoListItemViewModel {
    private String title;
    private String description;
    private String thumbnailURL;
    private String coverURL;
    private String date;
    private long duration;

    private VideoListItemViewModel(Builder builder) {
        title = builder.title;
        description = builder.description;
        thumbnailURL = builder.thumbnailURL;
        coverURL = builder.coverURL;
        date = builder.date;
        duration = builder.duration;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public String getCoverURL() {
        return coverURL;
    }

    public String getDate() {
        return date;
    }

    public long getDuration() {
        return duration;
    }

    public static final class Builder {
        private String title;
        private String description;
        private String thumbnailURL;
        private String coverURL;
        private String date;
        private long duration;

        public Builder() {
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder thumbnailURL(String val) {
            thumbnailURL = val;
            return this;
        }

        public Builder coverURL(String val) {
            coverURL = val;
            return this;
        }

        public Builder date(String val) {
            date = val;
            return this;
        }

        public Builder duration(long val) {
            duration = val;
            return this;
        }

        public VideoListItemViewModel build() {
            return new VideoListItemViewModel(this);
        }
    }
}
