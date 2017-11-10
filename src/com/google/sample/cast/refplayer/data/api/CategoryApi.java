package com.google.sample.cast.refplayer.data.api;

import com.google.sample.cast.refplayer.data.model.CategoryDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CategoryApi {
    @GET
    Call<List<CategoryDataModel>> getCategories(@Url String url);
}
