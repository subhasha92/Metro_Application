package com.example.metroapplication.apis.apiModel;

public class LoginResponse {

    private int status;

    public int getStatus() { return this.status; }

    public void setStatus(int status) { this.status = status; }

    private String message;

    public String getMessage() { return this.message; }

    public void setMessage(String message) { this.message = message; }

    private LoginResponseData payload;

    public LoginResponseData getPayload() { return this.payload; }

    public void setPayload(LoginResponseData payload) { this.payload = payload; }
}

