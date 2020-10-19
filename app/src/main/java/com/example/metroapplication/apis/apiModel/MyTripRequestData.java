package com.example.metroapplication.apis.apiModel;

public class MyTripRequestData {
           String userId;
                    String imei;
                    String ipAddress;
                    int noOfTrips;

    public MyTripRequestData(String userId, String imei, String ipAddress, int noOfTrips) {
        this.userId = userId;
        this.imei = imei;
        this.ipAddress = ipAddress;
        this.noOfTrips = noOfTrips;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public int getNoOfTrips() {
        return noOfTrips;
    }

    public void setNoOfTrips(int noOfTrips) {
        this.noOfTrips = noOfTrips;
    }
}
