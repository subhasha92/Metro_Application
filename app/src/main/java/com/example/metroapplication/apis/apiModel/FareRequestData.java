package com.example.metroapplication.apis.apiModel;

public class FareRequestData {
            String ticketType;
                   int srcStnId;
                   int desStnId;
                    int paxType;
                   int tktJrnyType;
                   int noOfPax;

    public FareRequestData(String ticketType, int srcStnId, int desStnId, int paxType, int tktJrnyType, int noOfPax) {
        this.ticketType = ticketType;
        this.srcStnId = srcStnId;
        this.desStnId = desStnId;
        this.paxType = paxType;
        this.tktJrnyType = tktJrnyType;
        this.noOfPax = noOfPax;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getSrcStnId() {
        return srcStnId;
    }

    public void setSrcStnId(int srcStnId) {
        this.srcStnId = srcStnId;
    }

    public int getDesStnId() {
        return desStnId;
    }

    public void setDesStnId(int desStnId) {
        this.desStnId = desStnId;
    }

    public int getPaxType() {
        return paxType;
    }

    public void setPaxType(int paxType) {
        this.paxType = paxType;
    }

    public int getTktJrnyType() {
        return tktJrnyType;
    }

    public void setTktJrnyType(int tktJrnyType) {
        this.tktJrnyType = tktJrnyType;
    }

    public int getNoOfPax() {
        return noOfPax;
    }

    public void setNoOfPax(int noOfPax) {
        this.noOfPax = noOfPax;
    }
}
