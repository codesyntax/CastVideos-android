package com.google.sample.cast.refplayer.ui.stationlist.model;

public class StationListViewModel {
    private int id;
    private String coverURL;

    public int getId() {
        return id;
    }

    public String getCoverURL() {
        return coverURL;
    }

    private StationListViewModel(Builder builder) {
        id = builder.id;
        coverURL = builder.coverURL;
    }

    public static final class Builder {
        private int id;
        private String coverURL;

        public Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder coverURL(String val) {
            coverURL = val;
            return this;
        }

        public StationListViewModel build() {
            return new StationListViewModel(this);
        }
    }
}
