package com.example.metroapplication.apis.apiModel;

public class SJTicketRequest {

    int channelId;

    String tokenId;

    SJTicketRequestData payload;

    public SJTicketRequest(int channelId, String tokenId, SJTicketRequestData payload) {
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

    public SJTicketRequestData getPayload() {
        return payload;
    }

    public void setPayload(SJTicketRequestData payload) {
        this.payload = payload;
    }
}
