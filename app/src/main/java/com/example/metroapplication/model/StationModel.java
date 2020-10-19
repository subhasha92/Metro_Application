package com.example.metroapplication.model;

public class StationModel {

    int stnId;
    String stnName;

    String gpsLocation;
    String intchngLine;
    String orgLine;

    public StationModel(int stnId, String stnName, String gpsLocation, String intchngLine, String orgLine) {
        this.stnId = stnId;
        this.stnName = stnName;
        this.gpsLocation = gpsLocation;
        this.intchngLine = intchngLine;
        this.orgLine = orgLine;
    }

    public int getStnId() {
        return stnId;
    }

    public void setStnId(int stnId) {
        this.stnId = stnId;
    }

    public String getStnName() {
        return stnName;
    }

    public void setStnName(String stnName) {
        this.stnName = stnName;
    }

    public String getGpsLocation() {
        return gpsLocation;
    }

    public void setGpsLocation(String gpsLocation) {
        this.gpsLocation = gpsLocation;
    }

    public String getIntchngLine() {
        return intchngLine;
    }

    public void setIntchngLine(String intchngLine) {
        this.intchngLine = intchngLine;
    }

    public String getOrgLine() {
        return orgLine;
    }

    public void setOrgLine(String orgLine) {
        this.orgLine = orgLine;
    }
}
