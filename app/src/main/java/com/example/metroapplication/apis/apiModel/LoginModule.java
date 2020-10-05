package com.example.metroapplication.apis.apiModel;

public class LoginModule {

       String channelId;

       String tokenId;

       LoginPayload payload;


    public LoginModule(String channelId, String tokenId, LoginPayload payload) {
        this.channelId = channelId;
        this.tokenId = tokenId;
        this.payload = payload;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public LoginPayload getPayload() {
        return payload;
    }

    public void setPayload(LoginPayload payload) {
        this.payload = payload;
    }
}
