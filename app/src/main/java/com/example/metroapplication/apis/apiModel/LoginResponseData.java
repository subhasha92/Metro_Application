package com.example.metroapplication.apis.apiModel;

import com.google.gson.annotations.SerializedName;

public class LoginResponseData {

    @SerializedName("id")
    private int id;
    @SerializedName("token")
    private String token;
    @SerializedName("stations")
    private String stations;
    @SerializedName("status")
    private String status;
    @SerializedName("userRole")
    private String userRole;
    @SerializedName("deviceId")
    private String deviceId;
    @SerializedName("apiKey")
    private String apiKey;
    @SerializedName("errorMsg")
    private String errorMsg;
    @SerializedName("userId")
    private String userId;
    @SerializedName("pwd")
    private String pwd;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStations() {
        return stations;
    }

    public void setStations(String stations) {
        this.stations = stations;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
