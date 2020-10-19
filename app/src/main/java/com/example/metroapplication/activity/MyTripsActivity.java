package com.example.metroapplication.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.metroapplication.R;
import com.example.metroapplication.adapter.MyTripsAdapter;
import com.example.metroapplication.apis.ApiClient;
import com.example.metroapplication.apis.ApiInterface;
import com.example.metroapplication.apis.apiModel.MyTripRequest;
import com.example.metroapplication.apis.apiModel.MyTripRequestData;
import com.example.metroapplication.apis.apiModel.MyTripResponse;
import com.example.metroapplication.apis.apiModel.MyTripResponseData;
import com.example.metroapplication.constants.Constants;
import com.example.metroapplication.model.MyTrips;
import com.example.metroapplication.sharedPref.AppPreferences;
import com.example.metroapplication.sharedPref.VariablesConstant;
import com.example.metroapplication.utils.ConnectionDetector;
import com.example.metroapplication.utils.MenuActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MyTripsActivity extends MenuActivity {

    ConnectionDetector cd;
    ApiInterface apiInterface;

    MyTripRequest myTripRequest;
    List<MyTripResponseData> tripsList;

    RecyclerView.Adapter adapter;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override       // for font style
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/caviar_dreams.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.activity_my_trips);
        final ProgressDialog progressdialog = ProgressDialog.show(
                MyTripsActivity.this, "Please wait",
                "Loading please wait..", true);
        progressdialog.show();
        progressdialog.setCancelable(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle("My Trips");
        } else {
            getSupportActionBar().setTitle("My Trips");
        }

        RecyclerView mList = findViewById(R.id.recycler_view_my_trips);

        cd=new ConnectionDetector(this);
        apiInterface= ApiClient.getClient().create(ApiInterface.class);
        loadData();
        Call<MyTripResponse> call=apiInterface.getMyTrips(myTripRequest);

        call.enqueue(new Callback<MyTripResponse>() {
            @Override
            public void onResponse(Call<MyTripResponse> call, Response<MyTripResponse> response) {
                if (response.code()==200) {

                    MyTripResponse mt=response.body();
                    if (mt.getStatus()==200){
                        tripsList=mt.getPayload();
                    adapter = new MyTripsAdapter(getApplicationContext(), tripsList);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyTripsActivity.this);
                        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

                        mList.setHasFixedSize(true);
                        mList.setLayoutManager(linearLayoutManager);
                        mList.addItemDecoration(dividerItemDecoration);
                        mList.setAdapter(adapter);
                        progressdialog.dismiss();
                    }else
                    {
                        progressdialog.dismiss();
                        Toast.makeText(MyTripsActivity.this, "Server Down", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MyTripResponse> call, Throwable t) {

                progressdialog.dismiss();
                Toast.makeText(MyTripsActivity.this, "Failed : "+t.getCause(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void loadData() {

        int channelId=1;
        String tokenId= AppPreferences.getAppPrefrences(VariablesConstant.TOKEN,this);

        String userId=AppPreferences.getAppPrefrences(VariablesConstant.USER_EMAIL,this);
        String imei= Constants.imei;
        String ipAdd= Constants.ipAddress;
        int noTrips=10;
        MyTripRequestData myTripRequestData=new MyTripRequestData(userId,imei,ipAdd,noTrips);

        myTripRequest=new MyTripRequest(channelId,tokenId,myTripRequestData);


    }
}
