package com.example.metroapplication.apis.apiModel;

public class MyTripRequest {




       int channelId;
            String tokenId;

           MyTripRequestData payload;


    public MyTripRequest(int channelId, String tokenId, MyTripRequestData payload) {
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
}
