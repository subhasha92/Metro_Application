package com.example.metroapplication.apis.apiModel;

public class ListFare
{
    private String fareType;

    public String getFareType() { return this.fareType; }

    public void setFareType(String fareType) { this.fareType = fareType; }

    private int minDistance;

    public int getMinDistance() { return this.minDistance; }

    public void setMinDistance(int minDistance) { this.minDistance = minDistance; }

    private double maxDistance;

    public double getMaxDistance() { return this.maxDistance; }

    public void setMaxDistance(double maxDistance) { this.maxDistance = maxDistance; }

    private int busServiceType;

    public int getBusServiceType() { return this.busServiceType; }

    public void setBusServiceType(int busServiceType) { this.busServiceType = busServiceType; }

    private double fareAmount;

    public double getFareAmount() { return this.fareAmount; }

    public void setFareAmount(double fareAmount) { this.fareAmount = fareAmount; }

    private String passengerType;

    public String getPassengerType() { return this.passengerType; }

    public void setPassengerType(String passengerType) { this.passengerType = passengerType; }
}