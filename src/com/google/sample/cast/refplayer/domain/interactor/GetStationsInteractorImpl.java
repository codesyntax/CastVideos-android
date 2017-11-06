package com.google.sample.cast.refplayer.domain.interactor;

import com.google.sample.cast.refplayer.domain.model.Station;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class GetStationsInteractorImpl implements GetStationsInteractor {
    private Callback callback;

    @Inject
    public GetStationsInteractorImpl() {}

    @Override
    public void execute(Callback callback) {
        this.callback = callback;
        //TODO call service
        List<Station> models = new ArrayList<>();
        models.add(new Station.Builder()
                .coverURL("https://www.cats.org.uk/uploads/images/featurebox_sidebar_kids/grief-and-loss.jpg")
                .name("Cat channel")
                .build());
        models.add(new Station.Builder()
                .coverURL("https://www.cstatic-images.com/stock/379x253/68/img1113460234-1509471692068.jpg")
                .name("Car channel")
                .build());
        models.add(new Station.Builder()
                .coverURL("https://ladysmithgazette.co.za/wp-content/uploads/sites/64/2016/12/bar-1.jpg")
                .name("Beer channel")
                .build());
        models.add(new Station.Builder()
                .coverURL("http://www.chollos.com/wp-content/uploads/2016/04/Chollos-de-pel%C3%ADculas-de-Marvel.jpg")
                .name("Marvel channel")
                .build());
        models.add(new Station.Builder()
                .coverURL("https://ichef-1.bbci.co.uk/news/660/cpsprodpb/1325A/production/_88762487_junk_food.jpg")
                .name("Food channel")
                .build());
        models.add(new Station.Builder()
                .coverURL("https://c.tadst.com/gfx/750w/christmas.jpg?1")
                .name("Christmas channel")
                .build());
        models.add(new Station.Builder()
                .coverURL("http://athletics.taylor.edu/images/2016-17/Baseball/DeGraaf_NewHampshireDebut.jpg")
                .name("Baseball channel")
                .build());
        models.add(new Station.Builder()
                .coverURL("https://a6adc47bb216dfe8a383-49bf67815854ec9e2c04a8f4abb9cbf5.ssl.cf3.rackcdn.com/images/affiliates/rhs/responsive/category/plants/ferns.jpg")
                .name("Plants channel")
                .build());
        this.callback.onSuccess(models);
    }
}
