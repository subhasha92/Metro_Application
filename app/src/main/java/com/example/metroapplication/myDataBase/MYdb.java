package com.example.metroapplication.myDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.metroapplication.model.MyTicketModel;
import com.example.metroapplication.model.StationModel;

public class MYdb extends SQLiteOpenHelper {


private static final String dbName="MyDB.db";
    private static final int versionCode=1;


  public MYdb(@Nullable Context context) {
        super(context, dbName, null, versionCode);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(MyTicketDbConstant.CREATE_TABLE);
        db.execSQL(Stations.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(String.format("DROP TABLE IF EXISTS %s", MyTicketDbConstant.myTicketTableName));
        db.execSQL(String.format("DROP TABLE IF EXISTS %s", Stations.stationTableName));

        //create the table again
        onCreate(db);

    }


    public void addTicket(MyTicketModel myTicketModel)
    {
        // getting db instance for writing the user
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        // cv.put(User_id,usr.getId());
        cv.put(MyTicketDbConstant.myTicketNo,myTicketModel.getMyTicketNo());
        cv.put(MyTicketDbConstant.myTicketType,myTicketModel.getMyTicketType());
        cv.put(MyTicketDbConstant.myTicketSource,myTicketModel.getMyTicketSource());
        cv.put(MyTicketDbConstant.myTicketDestination,myTicketModel.getMyTicketDestination());
        cv.put(MyTicketDbConstant.myTicketValidity,myTicketModel.getMyTicketValidity());
        cv.put(MyTicketDbConstant.myTicketFare,myTicketModel.getMyTicketFare());
        cv.put(MyTicketDbConstant.myTicketQR,myTicketModel.getMyTicketQR());
        //inserting row
        db.insert(MyTicketDbConstant.myTicketTableName, null, cv);
        //close the database to avoid any leak
        db.close();
    }



    public void addStation(StationModel stationModel)
    {
        // getting db instance for writing the user
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        // cv.put(User_id,usr.getId());
        cv.put(Stations.stationId,stationModel.getStationId());
        cv.put(Stations.stationName,stationModel.getStationName());
        cv.put(Stations.stationInterchange,stationModel.getStationInterchange());
        cv.put(Stations.stationInterchangeLine,stationModel.getStationInterchangeLine());
        cv.put(Stations.stationOriginLine,stationModel.getStationOriginLine());

        //inserting row
        db.insert(Stations.stationTableName, null, cv);
        //close the database to avoid any leak
        db.close();
    }






}
