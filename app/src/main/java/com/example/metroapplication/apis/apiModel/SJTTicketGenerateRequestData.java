package com.example.metroapplication.apis.apiModel;

import java.util.List;

public class SJTTicketGenerateRequestData {

    String userId;
    String srcStnId;
    String destStnId;
    String custIpAddress;
    String custImei;
    String tktType;
    List<PassengerInfoSJTRequestData> psgList;

    public SJTTicketGenerateRequestData(String userId, String srcStnId, String destStnId, String custIpAddress, String custImei, String tktType, List<PassengerInfoSJTRequestData> psgList) {
        this.userId = userId;

        this.srcStnId = srcStnId;
        this.destStnId = destStnId;
        this.custIpAddress = custIpAddress;
        this.custImei = custImei;
        this.tktType = tktType;
        this.psgList = psgList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getSrcStnId() {
        return srcStnId;
    }

    public void setSrcStnId(String srcStnId) {
        this.srcStnId = srcStnId;
    }

    public String getDestStnId() {
        return destStnId;
    }

    public void setDestStnId(String destStnId) {
        this.destStnId = destStnId;
    }

    public String getCustIpAddress() {
        return custIpAddress;
    }

    public void setCustIpAddress(String custIpAddress) {
        this.custIpAddress = custIpAddress;
    }

    public String getCustImei() {
        return custImei;
    }

    public void setCustImei(String custImei) {
        this.custImei = custImei;
    }

    public String getTktType() {
        return tktType;
    }

    public void setTktType(String tktType) {
        this.tktType = tktType;
    }

    public List<PassengerInfoSJTRequestData> getPsgList() {
        return psgList;
    }

    public void setPsgList(List<PassengerInfoSJTRequestData> psgList) {
        this.psgList = psgList;
    }
}
