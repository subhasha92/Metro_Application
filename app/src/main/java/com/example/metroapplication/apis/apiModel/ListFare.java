package com.example.metroapplication.apis.apiModel;

public class ListFare {
    private String fareType;
    private int minDistance;
    private double maxDistance;
    private int busServiceType;
    private double fareAmount;
    private String passengerType;

    public String getFareType() {
        return this.fareType;
    }

    public void setFareType(String fareType) {
        this.fareType = fareType;
    }

    public int getMinDistance() {
        return this.minDistance;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public double getMaxDistance() {
        return this.maxDistance;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public int getBusServiceType() {
        return this.busServiceType;
    }

    public void setBusServiceType(int busServiceType) {
        this.busServiceType = busServiceType;
    }

    public double getFareAmount() {
        return this.fareAmount;
    }

    public void setFareAmount(double fareAmount) {
        this.fareAmount = fareAmount;
    }

    public String getPassengerType() {
        return this.passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }
}