package com.example.metroapplication.model;

public class MyTicketModel {

    private String myTicketNo;
    private String myTicketType;
    private String myTicketSource;
    private String myTicketDestination;
    private String myTicketValidity;
    private String myTicketFare;
    private String myTicketQR;



    public MyTicketModel( String myTicketNo, String myTicketType, String myTicketSource, String myTicketDestination, String myTicketValidity, String myTicketFare, String myTicketQR) {
        this.myTicketNo = myTicketNo;
        this.myTicketType = myTicketType;
        this.myTicketSource = myTicketSource;
        this.myTicketDestination = myTicketDestination;
        this.myTicketValidity = myTicketValidity;
        this.myTicketFare = myTicketFare;
        this.myTicketQR = myTicketQR;
    }


    public String getMyTicketNo() {
        return myTicketNo;
    }

    public void setMyTicketNo(String myTicketNo) {
        this.myTicketNo = myTicketNo;
    }

    public String getMyTicketType() {
        return myTicketType;
    }

    public void setMyTicketType(String myTicketType) {
        this.myTicketType = myTicketType;
    }

    public String getMyTicketSource() {
        return myTicketSource;
    }

    public void setMyTicketSource(String myTicketSource) {
        this.myTicketSource = myTicketSource;
    }

    public String getMyTicketDestination() {
        return myTicketDestination;
    }

    public void setMyTicketDestination(String myTicketDestination) {
        this.myTicketDestination = myTicketDestination;
    }

    public String getMyTicketValidity() {
        return myTicketValidity;
    }

    public void setMyTicketValidity(String myTicketValidity) {
        this.myTicketValidity = myTicketValidity;
    }

    public String getMyTicketFare() {
        return myTicketFare;
    }

    public void setMyTicketFare(String myTicketFare) {
        this.myTicketFare = myTicketFare;
    }

    public String getMyTicketQR() {
        return myTicketQR;
    }

    public void setMyTicketQR(String myTicketQR) {
        this.myTicketQR = myTicketQR;
    }
}
