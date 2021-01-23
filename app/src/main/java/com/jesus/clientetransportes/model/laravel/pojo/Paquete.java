package com.jesus.clientetransportes.model.laravel.pojo;

public class Paquete {

    private long id;
    private long idcamionero;
    private String descripcion;
    private float precio;
    private String created_at;
    private String updated_at;

    public Paquete() {
    }

    public Paquete(long idcamionero, String descripcion, float precio, String created_at, String updated_at) {
        this.idcamionero = idcamionero;
        this.descripcion = descripcion;
        this.precio = precio;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdcamionero() {
        return idcamionero;
    }

    public void setIdcamionero(long idcamionero) {
        this.idcamionero = idcamionero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "id=" + id +
                ", idcamionero=" + idcamionero +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
