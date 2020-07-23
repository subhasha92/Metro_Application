package com.example.metroapplication.apis.apiModel;

public class LoginResponseData {

    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private String firstName;

    public String getFirstName() { return this.firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    private String lastName;

    public String getLastName() { return this.lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    private String email;

    public String getEmail() { return this.email; }

    public void setEmail(String email) { this.email = email; }

    private String mobile;

    public String getMobile() { return this.mobile; }

    public void setMobile(String mobile) { this.mobile = mobile; }

    private String status;

    public String getStatus() { return this.status; }

    public void setStatus(String status) { this.status = status; }

    private String password;

    public String getPassword() { return this.password; }

    public void setPassword(String password) { this.password = password; }

    private String mpin;

    public String getMpin() { return this.mpin; }

    public void setMpin(String mpin) { this.mpin = mpin; }
}
