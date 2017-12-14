package com.codesyntax.jarrion.data.service;

public interface TokenService {
    String registerToken(String token);
    boolean updateToken(String token, String deviceId, boolean notificationStatus);
}
