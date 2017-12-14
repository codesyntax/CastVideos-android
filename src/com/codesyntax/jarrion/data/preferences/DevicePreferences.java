package com.codesyntax.jarrion.data.preferences;

public interface DevicePreferences {
    String getJarrionDeviceId();
    void setJarrionDeviceId(String deviceId);
    boolean getNotificationStatus();
    void setNotificationStatus(boolean notificationStatus);
}
