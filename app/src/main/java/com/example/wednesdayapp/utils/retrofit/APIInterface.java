package com.example.wednesdayapp.utils.retrofit;


import com.example.wednesdayapp.utils.models.ItunesResultData;
import com.example.wednesdayapp.utils.models.RootData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/search")
    Call<RootData> getDataFromServer(@Query("term") String term);
}
