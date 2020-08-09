package com.example.metroapplication.apis.apiModel;


public class MobileVerificationData
{
    public MobileVerificationData(int otp, String imei, String ipAddress) {
        this.otp = otp;
        this.imei = imei;
        this.ipAddress = ipAddress;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
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

    int otp;
        String imei;
              String ipAddress;


}