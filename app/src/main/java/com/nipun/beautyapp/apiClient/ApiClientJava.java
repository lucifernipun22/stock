package com.nipun.beautyapp.apiClient;

import com.nipun.beautyapp.model.ArticleItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiClientJava {

    @GET("/data")
    Call<List<ArticleItem>> getData();
}
