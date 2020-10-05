package com.example.metroapplication.model;

public class StationModel {


    private String stationId;
    private String stationName;
    private String stationInterchange;
    private String stationInterchangeLine;
    private String stationOriginLine;

    public StationModel(String stationId, String stationName, String stationInterchange, String stationInterchangeLine, String stationOriginLine) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.stationInterchange = stationInterchange;
        this.stationInterchangeLine = stationInterchangeLine;
        this.stationOriginLine = stationOriginLine;
    }


    public String getStationId() {
        return stationId;
    }


    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;

    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationInterchange() {
        return stationInterchange;
    }

    public void setStationInterchange(String stationInterchange) {


        this.stationInterchange = stationInterchange;

    }

    public String getStationInterchangeLine() {
        return stationInterchangeLine;
    }

    public void setStationInterchangeLine(String stationInterchangeLine) {
        this.stationInterchangeLine = stationInterchangeLine;
    }

    public String getStationOriginLine() {
        return stationOriginLine;
    }

    public void setStationOriginLine(String stationOriginLine) {
        this.stationOriginLine = stationOriginLine;
    }
}
