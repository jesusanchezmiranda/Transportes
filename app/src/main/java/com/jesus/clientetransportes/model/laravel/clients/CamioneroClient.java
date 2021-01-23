package com.jesus.clientetransportes.model.laravel.clients;

import com.jesus.clientetransportes.model.laravel.pojo.Camionero;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CamioneroClient {

    @DELETE("camionero/{id}")
    Call<Integer> deleteCamionero(@Path("id") long id);

    @GET("camionero/{id}")
    Call<Camionero> getCamionero(@Path("id") long id);

    @GET("camionero")
    Call<List<Camionero>> getCamioneros();

    @POST("camionero")
    Call<Long> postCamionero(@Body Camionero camionero);

    @PUT("camionero/{id}")
    Call<Boolean> putCamionero(@Path("id") long id, @Body Camionero camionero);



}
