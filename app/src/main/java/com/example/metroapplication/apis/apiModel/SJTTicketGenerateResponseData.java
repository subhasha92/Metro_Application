package com.example.metroapplication.apis.apiModel;

import java.io.Serializable;
import java.util.List;

public class SJTTicketGenerateResponseData implements Serializable {

    int srcStnId;
    int destStnId;
    String tktSrNo;
    String custIpAddress;
    String custImei;
    String tktType;
    List<PassengerInfoSJTResponseData> psgList;
    String tktId;
    String tktRequestDate;
    String tktRequestTime;
    String userId;

    public int getSrcStnId() {
        return srcStnId;
    }

    public int getDestStnId() {
        return destStnId;
    }

    public String getTktSrNo() {
        return tktSrNo;
    }

    public String getCustIpAddress() {
        return custIpAddress;
    }

    public String getCustImei() {
        return custImei;
    }

    public String getTktType() {
        return tktType;
    }

    public List<PassengerInfoSJTResponseData> getPsgList() {
        return psgList;
    }

    public String getTktId() {
        return tktId;
    }

    public String getTktRequestDate() {
        return tktRequestDate;
    }

    public String getTktRequestTime() {
        return tktRequestTime;
    }

    public String getUserId() {
        return userId;
    }
}
