package com.example.codingtest.codingapplication.network;

import com.example.codingtest.codingapplication.domainobject.LocationDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * APIInterface is an interface for service call
 */
public interface APIInterface {

    @GET("sample.json")
    Call<List<LocationDetail>> getLocationData();
}
