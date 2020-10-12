package com.example.metroapplication.myDataBase;


public class Stations {

    public static final String stationTableName = "stations";
    public static final String stationId = "stnId";
    public static final String stationName = "stnName";
    public static final String stationInterchange = "isInterchange";
    public static final String stationInterchangeLine = "InterchangeLine";
    public static final String stationOriginLine = "orgLine";


    public static final String CREATE_TABLE = "CREATE TABLE " + stationTableName + "(" + stationId
            + " INTEGER PRIMARY KEY," + stationName + " TEXT," + stationInterchange + " BOOLEAN,"
            + stationInterchangeLine + " TEXT," + stationOriginLine + " TEXT" + ")";


}

