package com.example.metroapplication.apis.apiModel;

import java.util.List;

public class MasterPayload {

        List<MasterTicketList> ticketList;

       List<MasterPassList> passList;

        List<MasterPssngrList> pssngrList;

        List<MasterStationList> stnList;

        String errorMsg;
    String masterData;
                String userId;

    public List<MasterTicketList> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<MasterTicketList> ticketList) {
        this.ticketList = ticketList;
    }

    public List<MasterPassList> getPassList() {
        return passList;
    }

    public void setPassList(List<MasterPassList> passList) {
        this.passList = passList;
    }

    public List<MasterPssngrList> getPssngrList() {
        return pssngrList;
    }

    public void setPssngrList(List<MasterPssngrList> pssngrList) {
        this.pssngrList = pssngrList;
    }

    public List<MasterStationList> getStnList() {
        return stnList;
    }

    public void setStnList(List<MasterStationList> stnList) {
        this.stnList = stnList;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMasterData() {
        return masterData;
    }

    public void setMasterData(String masterData) {
        this.masterData = masterData;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
