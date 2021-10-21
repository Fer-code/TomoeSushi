package com.example.tomoesushi.models;

public class Produto {
    public int idProd;
    public String nomeProd;
    public String descProd;
    public String DF;
    public String DV;
    public double precoProd;
    public String catProd;
    public boolean statusProd;

    public Produto(){

    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public String getDescProd() {
        return descProd;
    }

    public void setDescProd(String descProd) {
        this.descProd = descProd;
    }

    public String getDF() {
        return DF;
    }

    public void setDF(String DF) {
        this.DF = DF;
    }

    public String getDV() {
        return DV;
    }

    public void setDV(String DV) {
        this.DV = DV;
    }

    public double getPrecoProd() {
        return precoProd;
    }

    public void setPrecoProd(double precoProd) {
        this.precoProd = precoProd;
    }

    public String getCatProd() {
        return catProd;
    }

    public void setCatProd(String catProd) {
        this.catProd = catProd;
    }

    public boolean isStatusProd() {
        return statusProd;
    }

    public void setStatusProd(boolean statusProd) {
        this.statusProd = statusProd;
    }
}
