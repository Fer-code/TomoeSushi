package com.example.tomoesushi.models;

public class User {
    public int idUser;
    public String nomeUser;
    public String emailUser;
    public String telUser;
    public String senhaUser;

    public User(){

    }

    public User(int idUser, String nomeUser, String emailUser, String telUser, String senhaUser) {
        this.idUser = idUser;
        this.nomeUser = nomeUser;
        this.emailUser = emailUser;
        this.telUser = telUser;
        this.senhaUser = senhaUser;
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
}
