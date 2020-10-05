package com.example.metroapplication.apis.apiModel;

public class IssueValueQRData {

    float amount;
    String paymentMode;
    String ipAddress;
    String imei;

    public IssueValueQRData(float amount, String paymentMode, String ipAddress, String imei) {
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.ipAddress = ipAddress;
        this.imei = imei;
    }


    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }


}


