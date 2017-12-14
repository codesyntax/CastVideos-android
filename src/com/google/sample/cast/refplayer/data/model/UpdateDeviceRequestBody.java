package com.google.sample.cast.refplayer.data.model;

import com.google.gson.annotations.SerializedName;

public class UpdateDeviceRequestBody {
    private String uuid;
    @SerializedName("notification_status")
    private boolean notificationStatus;
    private String pwtoken;

    private UpdateDeviceRequestBody(Builder builder) {
        uuid = builder.uuid;
        notificationStatus = builder.notificationStatus;
        pwtoken = builder.pwtoken;
    }

    public String getUuid() {
        return uuid;
    }

    public boolean isNotificationStatus() {
        return notificationStatus;
    }

    public String getPwtoken() {
        return pwtoken;
    }

    public static final class Builder {
        private String uuid;
        private boolean notificationStatus;
        private String pwtoken;

        public Builder() {
        }

        public Builder uuid(String val) {
            uuid = val;
            return this;
        }

        public Builder notificationStatus(boolean val) {
            notificationStatus = val;
            return this;
        }

        public Builder pwtoken(String val) {
            pwtoken = val;
            return this;
        }

        public UpdateDeviceRequestBody build() {
            return new UpdateDeviceRequestBody(this);
        }
    }
}
