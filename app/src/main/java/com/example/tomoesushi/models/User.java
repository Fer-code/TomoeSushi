package com.example.tomoesushi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("idCli")
    public int idCli;
    @JsonProperty("nomeCli")
    public String nomeCli;
    @JsonProperty("emailCli")
    public String emailCli;
    @JsonProperty("userCli")
    public String userCli;
    @JsonProperty("senhaCli")
    public String senhaCli;
    @JsonProperty("telefoneCli")
    public String telefoneCli;
    @JsonProperty("cepCli")
    public String cepCli;
    @JsonProperty("LogradouroCli")
    public String logradouroCli;
    @JsonProperty("numCli")
    public String numCli;
    @JsonProperty("complementoCli")
    public String complementoCli;

    public User(){}

    public User(int idCli, String nomeCli, String emailCli, String userCli, String senhaCli, String telefoneCli, String cepCli, String logradouroCli, String numCli, String complementoCli) {
        this.idCli = idCli;
        this.nomeCli = nomeCli;
        this.emailCli = emailCli;
        this.userCli = userCli;
        this.senhaCli = senhaCli;
        this.telefoneCli = telefoneCli;
        this.cepCli = cepCli;
        this.logradouroCli = logradouroCli;
        this.numCli = numCli;
        this.complementoCli = complementoCli;
    }

    public User(String nomeCli, String emailCli, String userCli, String senhaCli, String telefoneCli, String cepCli, String logradouroCli, String numCli, String complementoCli) {
        this.nomeCli = nomeCli;
        this.emailCli = emailCli;
        this.userCli = userCli;
        this.senhaCli = senhaCli;
        this.telefoneCli = telefoneCli;
        this.cepCli = cepCli;
        this.logradouroCli = logradouroCli;
        this.numCli = numCli;
        this.complementoCli = complementoCli;
    }

    public int getIdUser() {
        return idCli;
    }

    public void setIdUser(int idUser) {
        this.idCli = idUser;
    }

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    public String getEmailCli() {
        return emailCli;
    }

    public void setEmailCli(String emailCli) {
        this.emailCli = emailCli;
    }

    public String getUserCli() {
        return userCli;
    }

    public void setUserCli(String userCli) {
        this.userCli = userCli;
    }

    public String getSenhaCli() {
        return senhaCli;
    }

    public void setSenhaCli(String senhaCli) {
        this.senhaCli = senhaCli;
    }

    public String getTelefoneCli() {
        return telefoneCli;
    }

    public void setTelefoneCli(String telefoneCli) {
        this.telefoneCli = telefoneCli;
    }

    public String getCepCli() {
        return cepCli;
    }

    public void setCepCli(String cepCli) {
        this.cepCli = cepCli;
    }

    public String getLogradouroCli() {
        return logradouroCli;
    }

    public void setLogradouroCli(String logradouroCli) {
        this.logradouroCli = logradouroCli;
    }

    public String getNumCli() {
        return numCli;
    }

    public void setNumCli(String numCli) {
        this.numCli = numCli;
    }

    public String getComplementoCli() {
        return complementoCli;
    }

    public void setComplementoCli(String complementoCli) {
        this.complementoCli = complementoCli;
    }
}
