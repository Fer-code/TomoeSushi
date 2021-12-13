package com.example.tomoesushi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonProperty("IdCli")
    public int IdCli;
    @JsonProperty("NomeCli")
    public String NomeCli;
    @JsonProperty("EmailCli")
    public String EmailCli;
    @JsonProperty("UserCli")
    public String userCli;
    @JsonProperty("SenhaCli")
    public String senhaCli;
    @JsonProperty("TelefoneCli")
    public String TelefoneCli;
    @JsonProperty("CepCli")
    public String cepCli;
    @JsonProperty("LogradouroCli")
    public String logradouroCli;
    @JsonProperty("NumCli")
    public String numCli;
    @JsonProperty("ComplementoCli")
    public String complementoCli;

    public User() {
    }

    public User(int idCli, String nomeCli, String emailCli, String userCli, String senhaCli, String telefoneCli, String cepCli, String logradouroCli, String numCli, String complementoCli) {
        this.IdCli = idCli;
        this.NomeCli = nomeCli;
        this.EmailCli = emailCli;
        this.userCli = userCli;
        this.senhaCli = senhaCli;
        this.TelefoneCli = telefoneCli;
        this.cepCli = cepCli;
        this.logradouroCli = logradouroCli;
        this.numCli = numCli;
        this.complementoCli = complementoCli;
    }

    public User(String nomeCli, String emailCli, String userCli, String senhaCli, String telefoneCli, String cepCli, String logradouroCli, String numCli, String complementoCli) {
        this.NomeCli = nomeCli;
        this.EmailCli = emailCli;
        this.userCli = userCli;
        this.senhaCli = senhaCli;
        this.TelefoneCli = telefoneCli;
        this.cepCli = cepCli;
        this.logradouroCli = logradouroCli;
        this.numCli = numCli;
        this.complementoCli = complementoCli;
    }

    public int getIdUser() {
        return IdCli;
    }

    public void setIdUser(int idUser) {
        this.IdCli = idUser;
    }

    public String getNomeCli() {
        return NomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.NomeCli = nomeCli;
    }

    public String getEmailCli() {
        return EmailCli;
    }

    public void setEmailCli(String emailCli) {
        this.EmailCli = emailCli;
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
        return TelefoneCli;
    }

    public void setTelefoneCli(String telefoneCli) {
        this.TelefoneCli = telefoneCli;
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
