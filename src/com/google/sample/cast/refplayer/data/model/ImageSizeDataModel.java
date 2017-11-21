package com.google.sample.cast.refplayer.data.model;

public class ImageSizeDataModel {
    public static final String ADMIN_THUMBNAIL_NAME = "admin_thumbnail";
    public static final String THUMBNAIL_NAME = "thumbnail";
    public static final String MOSAIC_NAME = "mosaic";
    public static final String DISPLAY_NAME = "display";
    private String name;
    private String url;
    private int height;
    private int width;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
