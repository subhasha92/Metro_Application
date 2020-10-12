package com.example.metroapplication.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.metroapplication.R;
import com.example.metroapplication.apis.ApiClient;
import com.example.metroapplication.apis.ApiInterface;
import com.example.metroapplication.apis.apiModel.MasterData;
import com.example.metroapplication.apis.apiModel.MasterRequest;
import com.example.metroapplication.apis.apiModel.MasterRequestPayload;
import com.example.metroapplication.sharedPref.AppPreferences;
import com.example.metroapplication.sharedPref.VariablesConstant;
import com.example.metroapplication.utils.ConnectionDetector;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {


    Button Singlejourney, returnJourney, MPass, Vticket, myTicket, myTrip, myProfile, lgOut;
    ProgressBar pr;
    LinearLayout img;
    TextView selectTick;

    RelativeLayout relativeLayout;

    ConnectionDetector cd;

    ApiInterface apiInterface;
    MasterRequest masterRequest;

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
        setContentView(R.layout.activity_main);

        cd=new ConnectionDetector(this);
        relativeLayout=findViewById(R.id.relativeLayout);

        final ProgressDialog progressdialog = ProgressDialog.show(
                MainActivity.this, "Please wait",
                "Loading please wait..", true);
        progressdialog.show();
        progressdialog.setCancelable(true);
        loadData();

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<MasterData> call=apiInterface.getMasterData(masterRequest);

        if (cd.isConnectingToInternet()){

        call.enqueue(new Callback<MasterData>() {
            @Override
            public void onResponse(Call<MasterData> call, Response<MasterData> response) {

                if (response.code()==200){
                    MasterData masterData=response.body();
                    if (masterData.getStatus()==200){



                        progressdialog.dismiss();
                        Snackbar.make(relativeLayout,"No Internet Connection",Snackbar.LENGTH_LONG).show();



                    }else
                    {
                        progressdialog.dismiss();
                        Snackbar.make(relativeLayout,"No Internet Connection",Snackbar.LENGTH_LONG).show();
                    }

                }


            }

            @Override
            public void onFailure(Call<MasterData> call, Throwable t) {

            }
        });}
        else
        {
            progressdialog.dismiss();
            Snackbar.make(relativeLayout,"No Internet Connection",Snackbar.LENGTH_LONG).show();
        }



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Home");
        } else {
            getSupportActionBar().setTitle("Home");
        }

        Singlejourney = findViewById(R.id.singleBtn);
        returnJourney = findViewById(R.id.returnBtn);
        MPass = findViewById(R.id.passBtn);
        Vticket = findViewById(R.id.vtBtn);
        myTicket = findViewById(R.id.myTicketBtn);
        myTrip = findViewById(R.id.mTripsBtn);
        myProfile = findViewById(R.id.mProfileBtn);
        lgOut = findViewById(R.id.lgBtn);
        pr = findViewById(R.id.progress_main);
        img = findViewById(R.id.imageview_main);
        selectTick = findViewById(R.id.selecttick);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/CaviarDreams_Bold.ttf");
        selectTick.setTypeface(typeface);

        img.setVisibility(View.INVISIBLE);
        pr.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                pr.setVisibility(View.GONE);
                img.setVisibility(View.VISIBLE);
            }
        }, 1000);

        Singlejourney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("type", 1);
                startActivity(intent);
            }
        });

        returnJourney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("type", 2);
                startActivity(intent);

            }
        });

        MPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, PassActivity.class);
//                startActivity(intent);

            }
        });

        Vticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ValueTicketActivity.class);
                startActivity(intent);


            }
        });

        myTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MyTicketQR.class);
                startActivity(intent);


            }
        });
        myTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MyTripsActivity.class);
                startActivity(intent);


            }
        });

        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyProfileActivity.class);
                startActivity(intent);


            }
        });

        lgOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });


    }

    private void loadData() {
        int channelId=1;
        String token=AppPreferences.getAppPrefrences(VariablesConstant.TOKEN,this);

        String master="getMaster";
        String userId=AppPreferences.getAppPrefrences(VariablesConstant.EMAIL,this);


        MasterRequestPayload masterRequestPayload;
        masterRequestPayload=new MasterRequestPayload(master, userId);


        masterRequest =new MasterRequest(channelId,token,masterRequestPayload);

    }


}
