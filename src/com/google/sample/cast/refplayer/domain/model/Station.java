package com.google.sample.cast.refplayer.domain.model;

public class Station {
    private int id;
    private String coverURL;

    public int getId() {
        return id;
    }

    public String getCoverURL() {
        return coverURL;
    }

    private Station(Builder builder) {
        id = builder.id;
        coverURL = builder.coverURL;
    }

    public static final class Builder {
        private final int id;
        private final String coverURL;

        public Builder(int id, String coverURL) {
            this.id = id;
            this.coverURL = coverURL;
        }

        public Station build() {
            return new Station(this);
        }
    }
}
