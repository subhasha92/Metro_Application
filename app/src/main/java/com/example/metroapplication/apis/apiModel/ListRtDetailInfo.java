package com.example.metroapplication.apis.apiModel;

public class ListRtDetailInfo
{
    private int index;

    public int getIndex() { return this.index; }

    public void setIndex(int index) { this.index = index; }

    private int stopId;

    public int getStopId() { return this.stopId; }

    public void setStopId(int stopId) { this.stopId = stopId; }

    private String stopName;

    public String getStopName() { return this.stopName; }

    public void setStopName(String stopName) { this.stopName = stopName; }

    private String stopLandmark;

    public String getStopLandmark() { return this.stopLandmark; }

    public void setStopLandmark(String stopLandmark) { this.stopLandmark = stopLandmark; }

    private String stopAreaName;

    public String getStopAreaName() { return this.stopAreaName; }

    public void setStopAreaName(String stopAreaName) { this.stopAreaName = stopAreaName; }

    private double stopLat;

    public double getStopLat() { return this.stopLat; }

    public void setStopLat(double stopLat) { this.stopLat = stopLat; }

    private double stopLong;

    public double getStopLong() { return this.stopLong; }

    public void setStopLong(double stopLong) { this.stopLong = stopLong; }

    private double distanceFromSrc;

    public double getDistanceFromSrc() { return this.distanceFromSrc; }

    public void setDistanceFromSrc(double distanceFromSrc) { this.distanceFromSrc = distanceFromSrc; }

    private Integer travelTime;

    public Integer getTravelTime() { return this.travelTime; }

    public void setTravelTime(Integer travelTime) { this.travelTime = travelTime; }
}