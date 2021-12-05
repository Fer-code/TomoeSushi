package com.example.tomoesushi.models;

public class Reserva {
    public int idRes;
    public int idUser;
    public int idMesa;
    public String numPessoas;
    public String dataRes;
    public String horaRes;

    public int getIdRes() {
        return idRes;
    }

    public void setIdRes(int idRes) {
        this.idRes = idRes;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getNumPessoas() {
        return numPessoas;
    }

    public void setNumPessoas(String numPessoas) {
        this.numPessoas = numPessoas;
    }

    public String getDataRes() {
        return dataRes;
    }

    public void setDataRes(String dataRes) {
        this.dataRes = dataRes;
    }

    public String getHoraRes() {
        return horaRes;
    }

    public void setHoraRes(String horaRes) {
        this.horaRes = horaRes;
    }
}
