package com.example.metroapplication.apis.apiModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IssueValueQRResponse {


    @SerializedName("status")
    int status;
    @SerializedName("message")
    String message;
    @SerializedName("payload")
    List<IssueValueQRResponseData> payload;

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

    public List<IssueValueQRResponseData> getPayload() {
        return payload;
    }

    public void setPayload(List<IssueValueQRResponseData> payload) {
        this.payload = payload;
    }
}
