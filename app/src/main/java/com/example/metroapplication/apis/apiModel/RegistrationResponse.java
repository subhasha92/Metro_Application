package com.example.metroapplication.apis.apiModel;

import java.util.List;

public class RegistrationResponse {

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<RegistrationResponseData> getPayload() {
        return payload;
    }

    public void setPayload(List<RegistrationResponseData> payload) {
        this.payload = payload;
    }

    int status;
    String message;

    List<RegistrationResponseData> payload;
}



