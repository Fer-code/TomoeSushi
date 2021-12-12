package com.example.tomoesushi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Produto {
    @JsonProperty("IdProd")
    public int midProd;
    @JsonProperty("NomeProd")
    public String mnomeProd;
    @JsonProperty("DescProd")
    public String mdescProd;
    @JsonProperty("PrecoProd")
    public double mprecoProd;
    @JsonProperty("CategoriaProd")
    public String mcatProd;
    @JsonProperty("StatusProd")
    public String mstatusProd;

    public Produto() {}

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

    @Override
    public String toString() {
        return "Produto: " + mnomeProd;
    }
}
