package com.example.metroapplication.apis.apiModel;

public class PassengerInfoSJTRequestData {

     String pssType;
     int noOfTkt;
     float tktAmount;
      float discount;
      float amtPaid;
      float totalAmt;
    public PassengerInfoSJTRequestData(String pssType, int noOfTkt, float tktAmount, float discount, float amtPaid, float totalAmt) {
        this.pssType = pssType;
        this.noOfTkt = noOfTkt;
        this.tktAmount = tktAmount;
        this.discount = discount;
        this.amtPaid = amtPaid;
        this.totalAmt = totalAmt;
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
