package com.example.metroapplication.apis.apiModel;

public class MasterData {

       String channelId;
       String tokenId;

       MasterPayload payload;


    public MasterData(String channelId, String tokenId, MasterPayload payload) {
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

    public MasterPayload getPayload() {
        return payload;
    }

    public void setPayload(MasterPayload payload) {
        this.payload = payload;
    }
}
