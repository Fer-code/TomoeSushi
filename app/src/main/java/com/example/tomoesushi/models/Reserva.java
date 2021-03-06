package com.example.tomoesushi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reserva {
    @JsonProperty("IdReserva")
    public int idReserva;
    @JsonProperty("NumPessoas")
    public int numPessoas;
    @JsonProperty("DataHoraReserva")
    public String dataHoraReserva;
    @JsonProperty("StatusReserva")
    public String statusReserva;
    @JsonProperty("IdCli")
    public int idCli;
    @JsonProperty("IdMesa")
    public int idMesa;


    public Reserva(int idReserva, int numPessoas, String dataHoraReserva, String statusReserva, int idCli, int idMesa) {
        this.idReserva = idReserva;
        this.numPessoas = numPessoas;
        this.dataHoraReserva = dataHoraReserva;
        this.statusReserva = statusReserva;
        this.idCli = idCli;
        this.idMesa = idMesa;
    }

    public Reserva(int numPessoas, String dataHoraReserva, String statusReserva, int idCli, int idMesa) {
        this.numPessoas = numPessoas;
        this.dataHoraReserva = dataHoraReserva;
        this.statusReserva = statusReserva;
        this.idCli = idCli;
        this.idMesa = idMesa;
    }

    public Reserva() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getNumPessoas() {
        return numPessoas;
    }

    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }

    public String getDataHoraReserva() {
        return dataHoraReserva;
    }

    public void setDataHoraReserva(String dataHoraReserva) {
        this.dataHoraReserva = dataHoraReserva;
    }

    public String getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(String statusReserva) {
        this.statusReserva = statusReserva;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }
}
