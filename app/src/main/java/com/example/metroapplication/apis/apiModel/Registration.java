package com.example.metroapplication.apis.apiModel;


public class Registration {

    private int channelId;

    private String tokenId;

    RegistrationData payload;

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

    public RegistrationData getPayload() {
        return payload;
    }

    public void setPayload(RegistrationData payload) {
        this.payload = payload;
    }




}