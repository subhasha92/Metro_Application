package com.example.metroapplication.apis.apiModel;

import java.util.List;

public class MyTripResponse {

       int status;
             String message;
    List<MyTripResponseData> payload;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<MyTripResponseData> getPayload() {
        return payload;
    }
}
