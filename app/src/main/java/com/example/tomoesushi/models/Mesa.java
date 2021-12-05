package com.example.tomoesushi.models;

public class Mesa {
    public int idMesa;
    public int numMesa;
    public String numAssentos;
    public boolean statusMesa;

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public String getNumAssentos() {
        return numAssentos;
    }

    public void setNumAssentos(String numAssentos) {
        this.numAssentos = numAssentos;
    }

    public boolean isStatusMesa() {
        return statusMesa;
    }

    public void setStatusMesa(boolean statusMesa) {
        this.statusMesa = statusMesa;
    }
}
