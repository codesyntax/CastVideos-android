package com.codesyntax.jarrion.service.instanceid;

import com.codesyntax.jarrion.di.component.DaggerInstanceIDComponent;
import com.codesyntax.jarrion.service.instanceid.presenter.JarrionInstanceIdPresenter;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.sample.cast.refplayer.JarriOnApplication;
import com.google.sample.cast.refplayer.di.component.ApplicationComponent;

import javax.inject.Inject;

public class JarrionInstanceIDService extends FirebaseInstanceIdService {
    @Inject
    JarrionInstanceIdPresenter presenter;

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationComponent component = JarriOnApplication.getInstance().getComponent();
        DaggerInstanceIDComponent.builder().applicationComponent(component).build().inject(this);
    }

    @Override
    public void onTokenRefresh() {
        String firebaseToken = FirebaseInstanceId.getInstance().getToken();
        presenter.registerToken(firebaseToken);
    }
}
