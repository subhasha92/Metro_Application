package com.example.metroapplication.apis.apiModel;

public class UpdateMyProfileRequest {

        int channelId;

            String tokenId;

        UpdateMyProfileRequestData payload;

    public UpdateMyProfileRequest(int channelId, String tokenId, UpdateMyProfileRequestData payload) {
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

    public UpdateMyProfileRequestData getPayload() {
        return payload;
    }

    public void setPayload(UpdateMyProfileRequestData payload) {
        this.payload = payload;
    }
}
