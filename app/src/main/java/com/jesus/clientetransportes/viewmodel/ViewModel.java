package com.jesus.clientetransportes.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jesus.clientetransportes.model.Repository;
import com.jesus.clientetransportes.model.laravel.pojo.Camionero;
import com.jesus.clientetransportes.model.laravel.pojo.Paquete;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private Repository repository;
    private boolean recycler;
    private Camionero camionero = new Camionero();
    private Paquete paquete = new Paquete();

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public void insertCamionero(Camionero camionero) {
        repository.insertCamionero(camionero);
    }

    public void getCamionero(long id) {
        repository.getCamionero(id);
    }

    public void deleteCamionero(long id) {
        repository.deleteCamionero(id);
    }

    public void updateCamionero(long id, Camionero camionero) {
        repository.updateCamionero(id, camionero);
    }

    public MutableLiveData<List<Camionero>> getListaCamioneros() {
        return repository.getListaCamioneros();
    }

    public void insertPaquete(Paquete paquete) {
        repository.insertPaquete(paquete);
    }

    public void getPaquete(long id) {
        repository.getPaquete(id);
    }

    public void deletePaquete(long id) {
        repository.deletePaquete(id);
    }

    public void updatePaquete(long id, Paquete paquete) {
        repository.updatePaquete(id, paquete);
    }

    public MutableLiveData<List<Paquete>> getListaPaquetes() {
        return repository.getListaPaquetes();
    }

    public boolean isRecycler() {
        return recycler;
    }

    public void setRecycler(boolean recycler) {
        this.recycler = recycler;
    }


    public Camionero getCamionero() {
        return camionero;
    }

    public void setCamionero(Camionero camionero) {
        this.camionero = camionero;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
}
