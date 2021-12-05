package com.example.tomoesushi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("IdCli")
    public int idUser;
    @JsonProperty("NomeCli")
    public String nomeUser;
    @JsonProperty("EmailCli")
    public String emailUser;
    @JsonProperty("UserCli")
    public String userCli;
    @JsonProperty("SenhaCli")
    public String senhaUser;
    @JsonProperty("TelefoneCli")
    public String telUser;
    @JsonProperty("CepCli")
    public String cepUser;
    @JsonProperty("LogradouroCli")
    public String logUser;
    @JsonProperty("NumCli")
    public String numUser;
    @JsonProperty("ComplementoCli")
    public String complementoUser;

    public User(){}

    public User(int idUser, String nomeUser, String emailUser, String userCli, String senhaUser, String telUser, String cepUser, String logUser, String numUser, String complementoUser) {
        this.idUser = idUser;
        this.nomeUser = nomeUser;
        this.emailUser = emailUser;
        this.userCli = userCli;
        this.senhaUser = senhaUser;
        this.telUser = telUser;
        this.cepUser = cepUser;
        this.logUser = logUser;
        this.numUser = numUser;
        this.complementoUser = complementoUser;
    }

    public User(String nomeUser, String emailUser, String userCli, String senhaUser, String telUser, String cepUser, String logUser, String numUser, String complementoUser) {
        this.nomeUser = nomeUser;
        this.emailUser = emailUser;
        this.userCli = userCli;
        this.senhaUser = senhaUser;
        this.telUser = telUser;
        this.cepUser = cepUser;
        this.logUser = logUser;
        this.numUser = numUser;
        this.complementoUser = complementoUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getUserCli() {
        return userCli;
    }

    public void setUserCli(String userCli) {
        this.userCli = userCli;
    }

    public String getSenhaUser() {
        return senhaUser;
    }

    public void setSenhaUser(String senhaUser) {
        this.senhaUser = senhaUser;
    }

    public String getTelUser() {
        return telUser;
    }

    public void setTelUser(String telUser) {
        this.telUser = telUser;
    }

    public String getCepUser() {
        return cepUser;
    }

    public void setCepUser(String cepUser) {
        this.cepUser = cepUser;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public String getNumUser() {
        return numUser;
    }

    public void setNumUser(String numUser) {
        this.numUser = numUser;
    }

    public String getComplementoUser() {
        return complementoUser;
    }

    public void setComplementoUser(String complementoUser) {
        this.complementoUser = complementoUser;
    }
}
