package com.jesus.clientetransportes.model.laravel.clients;

import com.jesus.clientetransportes.model.laravel.pojo.Paquete;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PaqueteClient {

    @DELETE("paquete/{id}")
    Call<Integer> deletePaquete(@Path("id") long id);

    @GET("paquete/{id}")
    Call<Paquete> getPaquete(@Path("id") long id);

    @GET("paquete")
    Call<ArrayList<Paquete>> getPaquetes();

    @POST("paquete")
    Call<Long> postPaquete(@Body Paquete paquete);

    @PUT("paquete/{id}")
    Call<Boolean> putPaquete(@Path("id") long id, @Body Paquete paquete);



}
