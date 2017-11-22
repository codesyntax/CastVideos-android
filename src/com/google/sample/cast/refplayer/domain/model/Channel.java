package com.google.sample.cast.refplayer.domain.model;

public class Channel {
    private int id;
    private String name;
    private String coverURL;
    private String mosaicCoverURL;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCoverURL() {
        return coverURL;
    }

    public String getMosaicCoverURL() {
        return mosaicCoverURL;
    }

    private Channel(Builder builder) {
        id = builder.id;
        name = builder.name;
        coverURL = builder.coverURL;
        mosaicCoverURL = builder.mosaicCoverURL;
    }

    public static final class Builder {
        private int id;
        private String name;
        private String coverURL;
        private String mosaicCoverURL;

        public Builder(int id, String coverURL) {
            this.id = id;
            this.coverURL = coverURL;
        }

        public Builder() {
        }

        public Channel build() {
            return new Channel(this);
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder coverURL(String val) {
            coverURL = val;
            return this;
        }

        public Builder mosaicCoverURL(String val) {
            mosaicCoverURL = val;
            return this;
        }
    }
}