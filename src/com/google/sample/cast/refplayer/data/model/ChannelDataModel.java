package com.google.sample.cast.refplayer.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChannelDataModel {
    private String channelid;
    private String description;
    private ImageDataModel image;
    @SerializedName("source_json_url")
    private String sourceJsonURL;
    private String title;
    private String website;

    public String getChannelid() {
        return channelid;
    }

    public String getDescription() {
        return description;
    }

    public ImageDataModel getImage() {
        return image;
    }

    public String getSourceJsonURL() {
        return sourceJsonURL;
    }

    public String getTitle() {
        return title;
    }

    public String getWebsite() {
        return website;
    }

    public String getMosaicURL() {
        String result = "";
        if (image != null) {
            List<ImageSizeDataModel> sizes = image.getSizes();
            if (sizes != null) {
                for (ImageSizeDataModel size : sizes) {
                    if (ImageSizeDataModel.MOSAIC_NAME.equals(size.getName())) {
                        result = size.getUrl();
                        break;
                    }
                }
            }
        }
        return result;
    }

    public String getDisplayURL() {
        String result = "";
        if (image != null) {
            List<ImageSizeDataModel> sizes = image.getSizes();
            if (sizes != null) {
                for (ImageSizeDataModel size : sizes) {
                    if (ImageSizeDataModel.DISPLAY_NAME.equals(size.getName())) {
                        result = size.getUrl();
                        break;
                    }
                }
            }
        }
        return result;
    }
}
