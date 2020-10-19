package com.example.metroapplication.apis.apiModel;

public class MyTripResponseData {

    String customerId;
            String deviceId;
            String deviceIp;
    String noOfTrips;
    String tripStartFrom;
    String tripId;
    String tripDate;
    String tripStartTime;
    String tripAmount;
    String paymentMode;
    String tripEndTime;
    String inStnName;
    String outStnName;
    String inGateId;
    String outGateId;


    public String getCustomerId() {
        return customerId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public String getNoOfTrips() {
        return noOfTrips;
    }

    public String getTripStartFrom() {
        return tripStartFrom;
    }

    public String getTripId() {
        return tripId;
    }

    public String getTripDate() {
        return tripDate;
    }

    public String getTripStartTime() {
        return tripStartTime;
    }

    public String getTripAmount() {
        return tripAmount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public String getTripEndTime() {
        return tripEndTime;
    }

    public String getInStnName() {
        return inStnName;
    }

    public String getOutStnName() {
        return outStnName;
    }

    public String getInGateId() {
        return inGateId;
    }

    public String getOutGateId() {
        return outGateId;
    }
}
