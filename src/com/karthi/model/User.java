package com.karthi.model;

public class User {
    private String username;
    private String password;

    public User(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    public void setUserName(String username){
        this.username = username;
    }

    public String getUserName(){
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public boolean isUser(User user){
        return this.username.equals(user.getUserName()) && this.password.equals(user.getPassword());
    }
}
