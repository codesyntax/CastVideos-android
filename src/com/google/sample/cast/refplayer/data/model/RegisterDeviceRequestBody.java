package com.google.sample.cast.refplayer.data.model;

public class RegisterDeviceRequestBody {
    String pwtoken;

    private RegisterDeviceRequestBody(Builder builder) {
        pwtoken = builder.pwtoken;
    }

    public static final class Builder {
        private String pwtoken;

        public Builder() {
        }

        public Builder pwtoken(String val) {
            pwtoken = val;
            return this;
        }

        public RegisterDeviceRequestBody build() {
            return new RegisterDeviceRequestBody(this);
        }
    }
}
