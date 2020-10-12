package com.example.metroapplication.apis.apiModel;

public class MasterData {

    int status;
            String message;
    MasterPayload payload;


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

    public MasterPayload getPayload() {
        return payload;
    }

    public void setPayload(MasterPayload payload) {
        this.payload = payload;
    }
}
