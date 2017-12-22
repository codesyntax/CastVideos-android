package com.codesyntax.jarrion.domain.interactor;

public interface RegisterDeviceInteractor {
    void execute(Callback callback);

    interface Callback {
        void onSuccess();
    }
}
