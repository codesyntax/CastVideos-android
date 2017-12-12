package com.codesyntax.jarrion.data.service;

public interface TokenService {
    String registerToken(String token);
    String updateToken(String deviceId, String token);
}
