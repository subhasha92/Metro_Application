package com.example.metroapplication.apis.apiModel;

public class PassengerInfoSJTResponseData {

     int pssTypeId;
     String pssType;
     int noOfTkt;
     float tktAmount;
     float discount;
             float amtPaid;
             float totalAmt;



    public int getPssTypeId() {
        return pssTypeId;
    }

    public void setPssTypeId(int pssTypeId) {
        this.pssTypeId = pssTypeId;
    }

    public String getPssType() {
        return pssType;
    }

    public void setPssType(String pssType) {
        this.pssType = pssType;
    }

    public int getNoOfTkt() {
        return noOfTkt;
    }

    public void setNoOfTkt(int noOfTkt) {
        this.noOfTkt = noOfTkt;
    }

    public float getTktAmount() {
        return tktAmount;
    }

    public void setTktAmount(float tktAmount) {
        this.tktAmount = tktAmount;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getAmtPaid() {
        return amtPaid;
    }

    public void setAmtPaid(float amtPaid) {
        this.amtPaid = amtPaid;
    }

    public float getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(float totalAmt) {
        this.totalAmt = totalAmt;
    }
}
