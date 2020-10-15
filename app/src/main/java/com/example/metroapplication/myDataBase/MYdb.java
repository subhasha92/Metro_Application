package com.example.metroapplication.myDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.metroapplication.model.MyTicketModel;
import com.example.metroapplication.model.StationModel;

import java.util.ArrayList;
import java.util.List;

public class MYdb extends SQLiteOpenHelper {


    private static final String dbName = "MyDB.db";
    private static final int versionCode = 1;


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


    public void addTicket(MyTicketModel myTicketModel) {
        // getting db instance for writing the user
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        // cv.put(User_id,usr.getId());
        cv.put(MyTicketDbConstant.myTicketNo, myTicketModel.getMyTicketNo());
        cv.put(MyTicketDbConstant.myTicketType, myTicketModel.getMyTicketType());
        cv.put(MyTicketDbConstant.myTicketSource, myTicketModel.getMyTicketSource());
        cv.put(MyTicketDbConstant.myTicketDestination, myTicketModel.getMyTicketDestination());
        cv.put(MyTicketDbConstant.myTicketValidity, myTicketModel.getMyTicketValidity());
        cv.put(MyTicketDbConstant.myTicketFare, myTicketModel.getMyTicketFare());
        cv.put(MyTicketDbConstant.myTicketQR, myTicketModel.getMyTicketQR());
        db.insert(MyTicketDbConstant.myTicketTableName, null, cv);
        db.close();
    }


    public void addStation(StationModel stationModel) {
        // getting db instance for writing the user
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        // cv.put(User_id,usr.getId());
        cv.put(Stations.stationId, stationModel.getStnId());
        cv.put(Stations.stationName, stationModel.getStnName());
        cv.put(Stations.gpsLocation, stationModel.getIntchngLine());
        cv.put(Stations.stationInterchangeLine, stationModel.getIntchngLine());
        cv.put(Stations.stationOriginLine, stationModel.getOrgLine());

        //inserting row
        db.insert(Stations.stationTableName, null, cv);
        //close the database to avoid any leak
        db.close();
    }


    public List<String> getAllLabels(){
        List<String> list = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Stations.stationTableName;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);//selectQuery,selectedArguments

        // looping through all rows and adding to list
        list.add("Select Your Station");
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(1));//adding 2nd column data
            } while (cursor.moveToNext());
        }
        // closing connection
        cursor.close();
        db.close();
        // returning lables
        return list;
    }

}
