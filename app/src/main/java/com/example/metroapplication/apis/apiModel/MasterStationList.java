package com.example.metroapplication.apis.apiModel;

public class MasterStationList {

    int id;
            int stnId;
            String stnName;
    String stnAddress;
    String landMark;
            String gpsLocation;
    String stnBrandName;
            String stnType;

            String intchngLine;

            String orgLine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStnAddress() {
        return stnAddress;
    }

    public void setStnAddress(String stnAddress) {
        this.stnAddress = stnAddress;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getGpsLocation() {
        return gpsLocation;
    }

    public void setGpsLocation(String gpsLocation) {
        this.gpsLocation = gpsLocation;
    }

    public String getStnBrandName() {
        return stnBrandName;
    }

    public void setStnBrandName(String stnBrandName) {
        this.stnBrandName = stnBrandName;
    }

    public String getStnType() {
        return stnType;
    }

    public void setStnType(String stnType) {
        this.stnType = stnType;
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
