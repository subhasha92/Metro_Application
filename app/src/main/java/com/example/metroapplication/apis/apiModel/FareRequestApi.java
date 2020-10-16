package com.example.metroapplication.apis.apiModel;

public class FareRequestApi {

            int channelId;
            String tokenId;
            FareRequestData payload;

    public FareRequestApi(int channelId, String tokenId, FareRequestData payload) {
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

    public FareRequestData getPayload() {
        return payload;
    }

    public void setPayload(FareRequestData payload) {
        this.payload = payload;
    }
}
