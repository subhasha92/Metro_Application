package com.example.metroapplication.apis.apiModel;

import java.util.List;

public class FareResponse {

        int status;
            String message;
           List<FareResponseData> payload;

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

    public List<FareResponseData> getPayload() {
        return payload;
    }

    public void setPayload(List<FareResponseData> payload) {
        this.payload = payload;
    }
}
