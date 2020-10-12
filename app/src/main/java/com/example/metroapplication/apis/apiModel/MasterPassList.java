package com.example.metroapplication.apis.apiModel;

public class MasterPassList {

    int id ;
            int passId;
            String passName;
            String passType;
            String passDesc;
            String passPeriod;
            String tripAllowed;
            String linesValidOn;
            float passAmt;
            String validity;
            String validFrom;
            String validTo;
            String paxType;
            int distance_Src_Dest;
            String doc_Reqd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassId() {
        return passId;
    }

    public void setPassId(int passId) {
        this.passId = passId;
    }

    public String getPassName() {
        return passName;
    }

    public void setPassName(String passName) {
        this.passName = passName;
    }

    public String getPassType() {
        return passType;
    }

    public void setPassType(String passType) {
        this.passType = passType;
    }

    public String getPassDesc() {
        return passDesc;
    }

    public void setPassDesc(String passDesc) {
        this.passDesc = passDesc;
    }

    public String getPassPeriod() {
        return passPeriod;
    }

    public void setPassPeriod(String passPeriod) {
        this.passPeriod = passPeriod;
    }

    public String getTripAllowed() {
        return tripAllowed;
    }

    public void setTripAllowed(String tripAllowed) {
        this.tripAllowed = tripAllowed;
    }

    public String getLinesValidOn() {
        return linesValidOn;
    }

    public void setLinesValidOn(String linesValidOn) {
        this.linesValidOn = linesValidOn;
    }

    public float getPassAmt() {
        return passAmt;
    }

    public void setPassAmt(float passAmt) {
        this.passAmt = passAmt;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidTo() {
        return validTo;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }

    public String getPaxType() {
        return paxType;
    }

    public void setPaxType(String paxType) {
        this.paxType = paxType;
    }

    public int getDistance_Src_Dest() {
        return distance_Src_Dest;
    }

    public void setDistance_Src_Dest(int distance_Src_Dest) {
        this.distance_Src_Dest = distance_Src_Dest;
    }

    public String getDoc_Reqd() {
        return doc_Reqd;
    }

    public void setDoc_Reqd(String doc_Reqd) {
        this.doc_Reqd = doc_Reqd;
    }
}
