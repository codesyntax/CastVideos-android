package com.codesyntax.jarrion.domain.interactor;

public interface EnableNotificationsInteractor {
    void execute(boolean enabled, Callback callback);

    interface Callback {
        void onSuccess(boolean updated);
    }
}
