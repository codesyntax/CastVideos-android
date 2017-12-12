package com.codesyntax.jarrion.domain.interactor;

public interface RegisterTokenInteractor {
    void execute(String token, Callback callback);

    interface Callback {
        void onSuccess(String deviceId);
    }
}
