package com.google.sample.cast.refplayer.ui.channel.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class VideoListItemViewModel implements Parcelable {
    private String id;
    private String title;
    private String description;
    private String thumbnailURL;
    private String coverURL;
    private Date date;
    private long duration;
    private String videoURL;
    private String studio;
    private String mimetype;

    private VideoListItemViewModel(Builder builder) {
        id = builder.id;
        title = builder.title;
        description = builder.description;
        thumbnailURL = builder.thumbnailURL;
        coverURL = builder.coverURL;
        date = builder.date;
        duration = builder.duration;
        videoURL = builder.videoURL;
        studio = builder.studio;
        mimetype = builder.mimetype;
    }

    protected VideoListItemViewModel(Parcel in) {
        id = in.readString();
        title = in.readString();
        description = in.readString();
        thumbnailURL = in.readString();
        coverURL = in.readString();
        date = (Date) in.readSerializable();
        duration = in.readLong();
        videoURL = in.readString();
        studio = in.readString();
        mimetype = in.readString();
    }

    public static final Creator<VideoListItemViewModel> CREATOR = new Creator<VideoListItemViewModel>() {
        @Override
        public VideoListItemViewModel createFromParcel(Parcel in) {
            return new VideoListItemViewModel(in);
        }

        @Override
        public VideoListItemViewModel[] newArray(int size) {
            return new VideoListItemViewModel[size];
        }
    };

    public String getId() {
        return id;
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

    public Date getDate() {
        return date;
    }

    public long getDuration() {
        return duration;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public String getStudio() {
        return studio;
    }

    public String getMimetype() {
        return mimetype;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(thumbnailURL);
        parcel.writeString(coverURL);
        parcel.writeSerializable(date);
        parcel.writeLong(duration);
        parcel.writeString(videoURL);
        parcel.writeString(studio);
        parcel.writeString(mimetype);
    }


    public static final class Builder {
        private String title;
        private String description;
        private String thumbnailURL;
        private String coverURL;
        private Date date;
        private long duration;
        private String videoURL;
        private String studio;
        private String mimetype;
        private String id;

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

        public Builder date(Date val) {
            date = val;
            return this;
        }

        public Builder duration(long val) {
            duration = val;
            return this;
        }

        public Builder videoURL(String val) {
            videoURL = val;
            return this;
        }

        public Builder studio(String val) {
            studio = val;
            return this;
        }

        public Builder mimetype(String val) {
            mimetype = val;
            return this;
        }

        public VideoListItemViewModel build() {
            return new VideoListItemViewModel(this);
        }

        public Builder id(String val) {
            id = val;
            return this;
        }
    }
}
