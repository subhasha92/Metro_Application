package com.example.metroapplication.apis.apiModel;

public class LoginPayload {

    String mobile;
    String pwd;
    String imei;

    public LoginPayload(String mobile, String pwd, String imei) {
        this.mobile = mobile;
        this.pwd = pwd;
        this.imei = imei;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}

