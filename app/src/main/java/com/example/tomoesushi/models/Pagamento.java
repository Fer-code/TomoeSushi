package com.example.tomoesushi.models;

public class Pagamento {
    public int idPag;
    public int idPed;
    public String CPF;
    public Double totalPag;
    public Double trocoPag;
    public String tipoPag;

    public int getIdPag() {
        return idPag;
    }

    public void setIdPag(int idPag) {
        this.idPag = idPag;
    }

    public int getIdPed() {
        return idPed;
    }

    public void setIdPed(int idPed) {
        this.idPed = idPed;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Double getTotalPag() {
        return totalPag;
    }

    public void setTotalPag(Double totalPag) {
        this.totalPag = totalPag;
    }

    public Double getTrocoPag() {
        return trocoPag;
    }

    public void setTrocoPag(Double trocoPag) {
        this.trocoPag = trocoPag;
    }

    public String getTipoPag() {
        return tipoPag;
    }

    public void setTipoPag(String tipoPag) {
        this.tipoPag = tipoPag;
    }
}
