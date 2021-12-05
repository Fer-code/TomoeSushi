package com.example.tomoesushi.models;

import com.google.gson.annotations.SerializedName;

public class Produto {
    @SerializedName("idProd")
    public int midProd;
    @SerializedName("nomeProd")
    public String mnomeProd;
    @SerializedName("descProd")
    public String mdescProd;
    @SerializedName("precoProd")
    public double mprecoProd;
    @SerializedName("categoriaProd")
    public String mcatProd;
    @SerializedName("statusProd")
    public String mstatusProd;

    public Produto(){

    }

    public Produto(String nomeProd, String descProd, double precoProd, String catProd, String statusProd) {
        mnomeProd = nomeProd;
        mdescProd = descProd;
        mprecoProd = precoProd;
        mcatProd = catProd;
        mstatusProd = statusProd;
    }

    public Produto(int idProd, String nomeProd, String descProd, double precoProd, String catProd, String statusProd) {
        midProd = idProd;
        mnomeProd = nomeProd;
        mdescProd = descProd;
        mprecoProd = precoProd;
        mcatProd = catProd;
        mstatusProd = statusProd;
    }

    public int getIdProd() {
        return midProd;
    }

    public void setIdProd(int idProd) {
        this.midProd = idProd;
    }

    public String getNomeProd() {
        return mnomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.mnomeProd = nomeProd;
    }

    public String getDescProd() {
        return mdescProd;
    }

    public void setDescProd(String descProd) {
        this.mdescProd = descProd;
    }

    public double getPrecoProd() {
        return mprecoProd;
    }

    public void setPrecoProd(double precoProd) {
        this.mprecoProd = precoProd;
    }

    public String getCatProd() {
        return mcatProd;
    }

    public void setCatProd(String catProd) {
        this.mcatProd = catProd;
    }

    public String getStatusProd() {
        return mstatusProd;
    }

    public void setStatusProd(String statusProd) {
        this.mstatusProd = statusProd;
    }
}
