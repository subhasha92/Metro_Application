package com.example.metroapplication.apis.apiModel;

public class IssueValueQRRequest {

    private int channelId;

    private String tokenId;

    IssueValueQRData payload;

    public IssueValueQRRequest(int channelId, String tokenId, IssueValueQRData payload) {
        this.channelId = channelId;
        this.tokenId = tokenId;
        this.payload = payload;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public IssueValueQRData getPayload() {
        return payload;
    }

    public void setPayload(IssueValueQRData payload) {
        this.payload = payload;
    }
}
