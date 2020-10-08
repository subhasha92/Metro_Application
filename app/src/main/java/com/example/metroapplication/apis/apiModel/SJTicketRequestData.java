package com.example.metroapplication.apis.apiModel;

import java.util.List;

public class SJTicketRequestData {

    String userId;
    String tktBookingdt;
    String srcStnId;
    String destStnId;
    long tktNo;
    String custIpAddress;
    String custImei;
    String tktType;
    List<PassengerInfoSJTRequestData> psgList;
    String payMode;
    String paidAmt;
    String pmtId;

    public SJTicketRequestData(String userId, String tktBookingdt, String srcStnId, String destStnId, long tktNo, String custIpAddress, String custImei, String tktType, List<PassengerInfoSJTRequestData> psgList, String payMode, String paidAmt, String pmtId) {
        this.userId = userId;
        this.tktBookingdt = tktBookingdt;
        this.srcStnId = srcStnId;
        this.destStnId = destStnId;
        this.tktNo = tktNo;
        this.custIpAddress = custIpAddress;
        this.custImei = custImei;
        this.tktType = tktType;
        this.psgList = psgList;
        this.payMode = payMode;
        this.paidAmt = paidAmt;
        this.pmtId = pmtId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTktBookingdt() {
        return tktBookingdt;
    }

    public void setTktBookingdt(String tktBookingdt) {
        this.tktBookingdt = tktBookingdt;
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

    public long getTktNo() {
        return tktNo;
    }

    public void setTktNo(long tktNo) {
        this.tktNo = tktNo;
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

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getPaidAmt() {
        return paidAmt;
    }

    public void setPaidAmt(String paidAmt) {
        this.paidAmt = paidAmt;
    }

    public String getPmtId() {
        return pmtId;
    }

    public void setPmtId(String pmtId) {
        this.pmtId = pmtId;
    }
}

