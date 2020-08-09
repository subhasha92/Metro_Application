package com.example.metroapplication.apis.apiModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IssueValueQRResponseData {


    @SerializedName("amount")
     int amount;
    @SerializedName("paymentMode")
        String paymentMode;
    @SerializedName("imei")
        String imei;
    @SerializedName("ipAddress")
        String ipAddress;
    @SerializedName("ticketId")
        int ticketId;
    @SerializedName("fullTicketNo")
        String fullTicketNo;
    @SerializedName("qrTicketHash")
        String qrTicketHash;
    @SerializedName("paymentStatus")
        String paymentStatus;
    @SerializedName("ticketStatus")
        String ticketStatus;
    @SerializedName("ticketValidity")
        String ticketValidity;
    @SerializedName("issueDate")
        String issueDate;
    @SerializedName("issueTime")
        String issueTime;
    @SerializedName("errorMsg")
        String errorMsg;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getFullTicketNo() {
        return fullTicketNo;
    }

    public void setFullTicketNo(String fullTicketNo) {
        this.fullTicketNo = fullTicketNo;
    }

    public String getQrTicketHash() {
        return qrTicketHash;
    }

    public void setQrTicketHash(String qrTicketHash) {
        this.qrTicketHash = qrTicketHash;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getTicketValidity() {
        return ticketValidity;
    }

    public void setTicketValidity(String ticketValidity) {
        this.ticketValidity = ticketValidity;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
