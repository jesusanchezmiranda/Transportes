package com.jesus.clientetransportes.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jesus.clientetransportes.model.laravel.clients.CamioneroClient;
import com.jesus.clientetransportes.model.laravel.clients.PaqueteClient;
import com.jesus.clientetransportes.model.laravel.pojo.Camionero;
import com.jesus.clientetransportes.model.laravel.pojo.Paquete;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private CamioneroClient camioneroClient;
    private PaqueteClient paqueteClient;
    private Retrofit retrofit;
    private Context context;

    public Repository(Context context) {
        String url = "https://informatica.ieszaidinvergeles.org:9037/laraveles/transportesApp/public/api/";
        retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        this.context = context;
    }

    public void insertCamionero(Camionero camionero){

        camioneroClient = retrofit.create(CamioneroClient.class);
        Call<Long> request = camioneroClient.postCamionero(camionero);
        request.enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                Log.v("XXXXX", response.body().toString());
            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {
                Log.v("XXXXX",  t.getLocalizedMessage());
            }
        });

    }


    public void getCamionero(long id){
        camioneroClient = retrofit .create(CamioneroClient.class);
        Call<Camionero> requestCamionero = camioneroClient.getCamionero(id);
        requestCamionero.enqueue(new Callback<Camionero>() {
            @Override
            public void onResponse(Call<Camionero> call, Response<Camionero> response) {
                Log.v("XXXXX", response.body().toString());
            }

            @Override
            public void onFailure(Call<Camionero> call, Throwable t) {
                Log.v("XXXXX", t.getLocalizedMessage());
            }
        });

    }

    public void deleteCamionero(long id){
        camioneroClient = retrofit.create(CamioneroClient.class);
        Call<Integer> requestCamionero = camioneroClient.deleteCamionero(id);
        requestCamionero.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Log.v("XXXXX", response.body().toString());
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.v("XXXXX", t.getLocalizedMessage());
            }
        });

    }


    public void updateCamionero(long id, Camionero camionero){
        camioneroClient = retrofit.create(CamioneroClient.class);
        Call<Boolean> requestCamionero = camioneroClient.putCamionero(id, camionero);
        requestCamionero.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                Log.v("XXXXX", response.body().toString());
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.v("XXXXX", t.getLocalizedMessage());
            }
        });

    }


    public MutableLiveData<List<Camionero>> getListaCamioneros(){
        camioneroClient = retrofit.create(CamioneroClient.class);
        MutableLiveData<List<Camionero>> liveDataCamionero = new MutableLiveData<>();
        Call<List<Camionero>> requestCamionero = camioneroClient.getCamioneros();
        requestCamionero.enqueue(new Callback<List<Camionero>>() {
            @Override
            public void onResponse(Call<List<Camionero>> call, Response<List<Camionero>> response) {
                Log.v("XXXXX", response.body().toString());
                liveDataCamionero.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Camionero>> call, Throwable t) {
                Log.v("XXXXX", "onFailure: failed to getlistaCamioneros");
            }

        });

        return liveDataCamionero;

    }

    public void insertPaquete(Paquete paquete){
        paqueteClient = retrofit.create(PaqueteClient.class);
        Call<Long> request = paqueteClient.postPaquete(paquete);
        request.enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                Log.v("XXXXX", response.body().toString());
            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {
                Log.v("XXXXX",  t.getLocalizedMessage());
            }
        });

    }


    public void getPaquete(long id){
        paqueteClient = retrofit.create(PaqueteClient.class);
        Call<Paquete> requestCoche = paqueteClient.getPaquete(id);
        requestCoche.enqueue(new Callback<Paquete>() {
            @Override
            public void onResponse(Call<Paquete> call, Response<Paquete> response) {
                Log.v("XXXXX", response.body().toString());
            }

            @Override
            public void onFailure(Call<Paquete> call, Throwable t) {
                Log.v("XXXXX", t.getLocalizedMessage());
            }
        });

    }

    public void deletePaquete(long id){
        paqueteClient = retrofit.create(PaqueteClient.class);
        Call<Integer> requestCoche = paqueteClient.deletePaquete(id);
        requestCoche.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Log.v("XXXXX", response.body().toString());
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.v("XXXXX", t.getLocalizedMessage());
            }
        });

    }


    public void updatePaquete(long id, Paquete paquete){
        paqueteClient = retrofit.create(PaqueteClient.class);
        Call<Boolean> requestCoche = paqueteClient.putPaquete(id, paquete);
        requestCoche.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                Log.v("XXXXX", response.body().toString());
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.v("XXXXX", t.getLocalizedMessage());
            }
        });

    }


    public MutableLiveData<List<Paquete>> getListaPaquetes(){
        paqueteClient = retrofit.create(PaqueteClient.class);
        MutableLiveData<List<Paquete>> liveDataPaquete = new MutableLiveData<>();
        Call<ArrayList<Paquete>> listaPaquetes = paqueteClient.getPaquetes();
        listaPaquetes.enqueue(new Callback<ArrayList<Paquete>>() {
            @Override
            public void onResponse(Call<ArrayList<Paquete>> call, Response<ArrayList<Paquete>> response) {
                liveDataPaquete.setValue(response.body());
                Log.v("XXXXX", response.body().toString());
            }

            @Override
            public void onFailure(Call<ArrayList<Paquete>> call, Throwable t) {
                Log.v("XXXXX",  t.getLocalizedMessage());
            }
        });

        return liveDataPaquete;

    }

}
