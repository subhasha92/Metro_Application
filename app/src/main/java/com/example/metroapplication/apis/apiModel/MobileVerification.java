package com.example.metroapplication.apis.apiModel;

public class MobileVerification {

    int channelId;
    String tokenId;

    MobileVerificationData payload;

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

    public MobileVerificationData getPayload() {
        return payload;
    }

    public void setPayload(MobileVerificationData payload) {
        this.payload = payload;
    }

    public MobileVerification(int channelId, String tokenId, MobileVerificationData payload) {
        this.channelId = channelId;
        this.tokenId = tokenId;
        this.payload = payload;
    }
}
