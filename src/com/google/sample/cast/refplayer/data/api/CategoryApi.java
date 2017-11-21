package com.google.sample.cast.refplayer.data.api;

import com.google.sample.cast.refplayer.data.model.CategoriesResponseDataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CategoryApi {
    @GET
    Call<CategoriesResponseDataModel> getCategories(@Url String url);
}
