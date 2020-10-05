package com.example.metroapplication.apis.apiModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginResponse {

    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("payload")
    private List<LoginResponseData> payload;

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LoginResponseData> getPayload() {
        return this.payload;
    }

    public void setPayload(List<LoginResponseData> payload) {
        this.payload = payload;
    }
}

