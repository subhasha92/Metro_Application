package com.example.metroapplication.apis.apiModel;

import java.io.Serializable;
import java.util.List;

public class SjtQrResponseData implements Serializable {

        String tktBookingdt;
           int srcStnId;
            int destStnId;
            long tktNo;
            String custIpAddress;
            String custImei;
            String tktType;
    List<PassengerInfoSJTResponseData> psgList;
        String errorMsg;
            String payMode;
            String paidAmt;
            String pmtId;
            String qrTicketHash;
            String tkt_status;
            String tkt_validity;
            String userId;

    public String getTktBookingdt() {
        return tktBookingdt;
    }

    public void setTktBookingdt(String tktBookingdt) {
        this.tktBookingdt = tktBookingdt;
    }

    public int getSrcStnId() {
        return srcStnId;
    }

    public void setSrcStnId(int srcStnId) {
        this.srcStnId = srcStnId;
    }

    public int getDestStnId() {
        return destStnId;
    }

    public void setDestStnId(int destStnId) {
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

    public List<PassengerInfoSJTResponseData> getPsgList() {
        return psgList;
    }

    public void setPsgList(List<PassengerInfoSJTResponseData> psgList) {
        this.psgList = psgList;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
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

    public String getQrTicketHash() {
        return qrTicketHash;
    }

    public void setQrTicketHash(String qrTicketHash) {
        this.qrTicketHash = qrTicketHash;
    }

    public String getTkt_status() {
        return tkt_status;
    }

    public void setTkt_status(String tkt_status) {
        this.tkt_status = tkt_status;
    }

    public String getTkt_validity() {
        return tkt_validity;
    }

    public void setTkt_validity(String tkt_validity) {
        this.tkt_validity = tkt_validity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
