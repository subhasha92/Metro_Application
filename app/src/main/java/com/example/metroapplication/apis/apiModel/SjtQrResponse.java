package com.example.metroapplication.apis.apiModel;

import java.io.Serializable;
import java.util.List;

public class SjtQrResponse implements Serializable {

        int status;
        String message;
        List<SjtQrResponseData> payload;


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

    public List<SjtQrResponseData> getPayload() {
        return payload;
    }

    public void setPayload(List<SjtQrResponseData> payload) {
        this.payload = payload;
    }
}
