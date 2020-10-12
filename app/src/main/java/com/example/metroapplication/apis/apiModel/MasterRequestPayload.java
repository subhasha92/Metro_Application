package com.example.metroapplication.apis.apiModel;

public class MasterRequestPayload {

      String masterData;
              String userId;

    public MasterRequestPayload(String masterData, String userId) {
        this.masterData = masterData;
        this.userId = userId;
    }

    public String getMasterData() {
        return masterData;
    }

    public void setMasterData(String masterData) {
        this.masterData = masterData;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
