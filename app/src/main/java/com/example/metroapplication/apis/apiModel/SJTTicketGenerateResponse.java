package com.example.metroapplication.apis.apiModel;

import java.util.List;

public class SJTTicketGenerateResponse {

    int status;
    String message;
    List<SjtQrResponseData> payload;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<SjtQrResponseData> getPayload() {
        return payload;
    }
}
