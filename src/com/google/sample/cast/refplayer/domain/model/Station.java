package com.google.sample.cast.refplayer.domain.model;

public class Station {
    private int id;
    private String name;
    private String coverURL;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCoverURL() {
        return coverURL;
    }

    private Station(Builder builder) {
        id = builder.id;
        name = builder.name;
        coverURL = builder.coverURL;
    }

    public static final class Builder {
        private int id;
        private String name;
        private String coverURL;

        public Builder(int id, String coverURL) {
            this.id = id;
            this.coverURL = coverURL;
        }

        public Builder() {
        }

        public Station build() {
            return new Station(this);
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
    }
}
