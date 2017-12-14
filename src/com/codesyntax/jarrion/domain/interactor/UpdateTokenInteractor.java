package com.codesyntax.jarrion.domain.interactor;

public interface UpdateTokenInteractor {
    void execute(String token, boolean notificationStatus, Callback callback);

    interface Callback {
        void onSuccess(boolean updated);
    }
}
