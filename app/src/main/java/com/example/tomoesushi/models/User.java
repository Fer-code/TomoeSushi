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
    public String UserCli;
    @JsonProperty("SenhaCli")
    public String senhaCli;
    @JsonProperty("TelefoneCli")
    public String TelefoneCli;
    @JsonProperty("CepCli")
    public String CepCli;
    @JsonProperty("LogradouroCli")
    public String LogradouroCli;
    @JsonProperty("NumCli")
    public String NumCli;
    @JsonProperty("ComplementoCli")
    public String ComplementoCli;

    public User() {
    }

    public User(int idCli, String nomeCli, String emailCli, String userCli, String senhaCli, String telefoneCli, String cepCli, String logradouroCli, String numCli, String complementoCli) {
        this.IdCli = idCli;
        this.NomeCli = nomeCli;
        this.EmailCli = emailCli;
        this.UserCli = userCli;
        this.senhaCli = senhaCli;
        this.TelefoneCli = telefoneCli;
        this.CepCli = cepCli;
        this.LogradouroCli = logradouroCli;
        this.NumCli = numCli;
        this.ComplementoCli = complementoCli;
    }

    public User(String nomeCli, String emailCli, String userCli, String senhaCli, String telefoneCli, String cepCli, String logradouroCli, String numCli, String complementoCli) {
        this.NomeCli = nomeCli;
        this.EmailCli = emailCli;
        this.UserCli = userCli;
        this.senhaCli = senhaCli;
        this.TelefoneCli = telefoneCli;
        this.CepCli = cepCli;
        this.LogradouroCli = logradouroCli;
        this.NumCli = numCli;
        this.ComplementoCli = complementoCli;
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
        return UserCli;
    }

    public void setUserCli(String userCli) {
        this.UserCli = userCli;
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
        return CepCli;
    }

    public void setCepCli(String cepCli) {
        this.CepCli = cepCli;
    }

    public String getLogradouroCli() {
        return LogradouroCli;
    }

    public void setLogradouroCli(String logradouroCli) {
        this.LogradouroCli = logradouroCli;
    }

    public String getNumCli() {
        return NumCli;
    }

    public void setNumCli(String numCli) {
        this.NumCli = numCli;
    }

    public String getComplementoCli() {
        return ComplementoCli;
    }

    public void setComplementoCli(String complementoCli) {
        this.ComplementoCli = complementoCli;
    }
}
