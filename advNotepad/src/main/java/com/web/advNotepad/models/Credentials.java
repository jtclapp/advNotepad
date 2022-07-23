package com.web.advNotepad.models;

public class Credentials
{
    private String password;
    private String email;

    public Credentials(String password, String email) {
        this.password = password;
        this.email = email;
    }
    public Credentials() {

    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
