package com.example.metroapplication.apis.apiModel;

public class ListRtDetailInfo {
    private int index;
    private int stopId;
    private String stopName;
    private String stopLandmark;
    private String stopAreaName;
    private double stopLat;
    private double stopLong;
    private double distanceFromSrc;
    private Integer travelTime;

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getStopId() {
        return this.stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public String getStopName() {
        return this.stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public String getStopLandmark() {
        return this.stopLandmark;
    }

    public void setStopLandmark(String stopLandmark) {
        this.stopLandmark = stopLandmark;
    }

    public String getStopAreaName() {
        return this.stopAreaName;
    }

    public void setStopAreaName(String stopAreaName) {
        this.stopAreaName = stopAreaName;
    }

    public double getStopLat() {
        return this.stopLat;
    }

    public void setStopLat(double stopLat) {
        this.stopLat = stopLat;
    }

    public double getStopLong() {
        return this.stopLong;
    }

    public void setStopLong(double stopLong) {
        this.stopLong = stopLong;
    }

    public double getDistanceFromSrc() {
        return this.distanceFromSrc;
    }

    public void setDistanceFromSrc(double distanceFromSrc) {
        this.distanceFromSrc = distanceFromSrc;
    }

    public Integer getTravelTime() {
        return this.travelTime;
    }

    public void setTravelTime(Integer travelTime) {
        this.travelTime = travelTime;
    }
}