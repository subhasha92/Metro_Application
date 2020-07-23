package com.example.metroapplication.apis.apiModel;

import java.util.ArrayList;

public class ListRouteDetail
{
    private int routeId;

    public int getRouteId() { return this.routeId; }

    public void setRouteId(int routeId) { this.routeId = routeId; }

    private String routeNo;

    public String getRouteNo() { return this.routeNo; }

    public void setRouteNo(String routeNo) { this.routeNo = routeNo; }

    private ArrayList<ListRtDetailInfo> listRtDetailInfo;

    public ArrayList<ListRtDetailInfo> getListRtDetailInfo() { return this.listRtDetailInfo; }

    public void setListRtDetailInfo(ArrayList<ListRtDetailInfo> listRtDetailInfo) { this.listRtDetailInfo = listRtDetailInfo; }
}
