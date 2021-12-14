package com.example.tomoesushi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Produto {
    @JsonProperty("IdProd")
    public int IdProd;
    @JsonProperty("NomeProd")
    public String NomeProd;
    @JsonProperty("DescProd")
    public String DescProd;
    @JsonProperty("PrecoProd")
    public double PrecoProd;
    @JsonProperty("CategoriaProd")
    public String CategoriaProd;
    @JsonProperty("StatusProd")
    public String StatusProd;

    public Produto() {}

    public Produto(String nomeProd, String descProd, double precoProd, String catProd, String statusProd) {
        NomeProd = nomeProd;
        DescProd = descProd;
        PrecoProd = precoProd;
        CategoriaProd = catProd;
        StatusProd = statusProd;
    }

    public Produto(int idProd, String nomeProd, String descProd, double precoProd, String catProd, String statusProd) {
        IdProd = idProd;
        NomeProd = nomeProd;
        DescProd = descProd;
        PrecoProd = precoProd;
        CategoriaProd = catProd;
        StatusProd = statusProd;
    }

    @Override
    public String toString() {
        return "Produto: " + NomeProd;
    }

    public int getIdProd() {
        return IdProd;
    }

    public void setIdProd(int idProd) {
        IdProd = idProd;
    }

    public String getNomeProd() {
        return NomeProd;
    }

    public void setNomeProd(String nomeProd) {
        NomeProd = nomeProd;
    }

    public String getDescProd() {
        return DescProd;
    }

    public void setDescProd(String descProd) {
        DescProd = descProd;
    }

    public double getPrecoProd() {
        return PrecoProd;
    }

    public void setPrecoProd(double precoProd) {
        PrecoProd = precoProd;
    }

    public String getCategoriaProd() {
        return CategoriaProd;
    }

    public void setCategoriaProd(String categoriaProd) {
        CategoriaProd = categoriaProd;
    }

    public String getStatusProd() {
        return StatusProd;
    }

    public void setStatusProd(String statusProd) {
        StatusProd = statusProd;
    }
}
