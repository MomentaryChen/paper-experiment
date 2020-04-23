package com.example.hw4;

public class User {
    String account;
    String password;

    public User(String account, String password){
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        password = password;
    }
}
