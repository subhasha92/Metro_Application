package com.example.metroapplication.apis.apiModel;

import java.util.List;

public class SJTTicketGenerateRequest {

    int channelId;

    String tokenId;

    SJTTicketGenerateRequestData payload;

    public SJTTicketGenerateRequest(int channelId, String tokenId, SJTTicketGenerateRequestData payload) {
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

    public SJTTicketGenerateRequestData getPayload() {
        return payload;
    }

    public void setPayload(SJTTicketGenerateRequestData payload) {
        this.payload = payload;
    }
}
