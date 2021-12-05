package com.example.tomoesushi.models;

public class Pedido {
    public int idPed;
    public int quantPed;
    public String dataPede;
    public String horaPed;
    public String statusPed;
    public String subTotalPed;

    public int getIdPed() {
        return idPed;
    }

    public void setIdPed(int idPed) {
        this.idPed = idPed;
    }

    public int getQuantPed() {
        return quantPed;
    }

    public void setQuantPed(int quantPed) {
        this.quantPed = quantPed;
    }

    public String getDataPede() {
        return dataPede;
    }

    public void setDataPede(String dataPede) {
        this.dataPede = dataPede;
    }

    public String getHoraPed() {
        return horaPed;
    }

    public void setHoraPed(String horaPed) {
        this.horaPed = horaPed;
    }

    public String getStatusPed() {
        return statusPed;
    }

    public void setStatusPed(String statusPed) {
        this.statusPed = statusPed;
    }

    public String getSubTotalPed() {
        return subTotalPed;
    }

    public void setSubTotalPed(String subTotalPed) {
        this.subTotalPed = subTotalPed;
    }
}
