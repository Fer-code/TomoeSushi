package com.example.tomoesushi.models;

public class User {
    public int idUser;
    public String nomeUser;
    public String emailUser;
    public String telUser;
    public String user;
    public String senhaUser;
    public String cepUser;
    public String logUser;
    public String complementoUser;
    public String numUser;

    public User(){

    }

    public User(String nomeUser, String emailUser, String telUser, String user, String senhaUser, String cepUser, String logUser, String complementoUser, String numUser) {
        this.nomeUser = nomeUser;
        this.emailUser = emailUser;
        this.telUser = telUser;
        this.user = user;
        this.senhaUser = senhaUser;
        this.cepUser = cepUser;
        this.logUser = logUser;
        this.complementoUser = complementoUser;
        this.numUser = numUser;
    }

    public User(String nomeUser, String emailUser, String telUser, String user, String senhaUser) {
        this.nomeUser = nomeUser;
        this.emailUser = emailUser;
        this.telUser = telUser;
        this.user = user;
        this.senhaUser = senhaUser;
    }

    public User(int idUser, String nomeUser, String emailUser, String telUser, String user, String senhaUser, String cepUser, String logUser, String complementoUser, String numUser) {
        this.idUser = idUser;
        this.nomeUser = nomeUser;
        this.emailUser = emailUser;
        this.telUser = telUser;
        this.user = user;
        this.senhaUser = senhaUser;
        this.cepUser = cepUser;
        this.logUser = logUser;
        this.complementoUser = complementoUser;
        this.numUser = numUser;
    }

    public User(int idUser, String nomeUser, String emailUser, String telUser, String user, String senhaUser) {
        this.idUser = idUser;
        this.nomeUser = nomeUser;
        this.emailUser = emailUser;
        this.telUser = telUser;
        this.user = user;
        this.senhaUser = senhaUser;
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

    public String getComplementoUser() {
        return complementoUser;
    }

    public void setComplementoUser(String complementoUser) {
        this.complementoUser = complementoUser;
    }

    public String getNumUser() {
        return numUser;
    }

    public void setNumUser(String numUser) {
        this.numUser = numUser;
    }

    public User(String nomeUser, String emailUser, String telUser, String senhaUser) {
        this.nomeUser = nomeUser;
        this.emailUser = emailUser;
        this.telUser = telUser;
        this.senhaUser = senhaUser;
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

    public String getTelUser() {
        return telUser;
    }

    public void setTelUser(String telUser) {
        this.telUser = telUser;
    }

    public String getSenhaUser() {
        return senhaUser;
    }

    public void setSenhaUser(String senhaUser) {
        this.senhaUser = senhaUser;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
