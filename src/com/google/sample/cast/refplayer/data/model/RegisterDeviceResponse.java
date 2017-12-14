package com.google.sample.cast.refplayer.data.model;

import com.google.gson.annotations.SerializedName;

public class RegisterDeviceResponse {
    @SerializedName("device_id")
    private String deviceId;
    private int time;

    public String getDeviceId() {
        return deviceId;
    }

    public int getTime() {
        return time;
    }
}
