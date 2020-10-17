package com.example.metroapplication.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.metroapplication.R;
import com.example.metroapplication.apis.ApiClient;
import com.example.metroapplication.apis.ApiInterface;
import com.example.metroapplication.apis.apiModel.FareRequestApi;
import com.example.metroapplication.apis.apiModel.FareRequestData;
import com.example.metroapplication.apis.apiModel.FareResponse;
import com.example.metroapplication.helper.IncreamentDecreament;
import com.example.metroapplication.myDataBase.MYdb;
import com.example.metroapplication.myDataBase.MyTicketDbConstant;
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

import static android.widget.AdapterView.*;

public class HomeActivity extends MenuActivity implements OnItemSelectedListener {

    Spinner fromSpinner, toSpinner;
    Button addAdult, minusAdult, previewBtn, back;
    TextView adultCount, adultFare, discountFare, totalFare, actualFare;
    TextView joourneyTIck, amountToPay;

    float disc, Actual;
    float Total;
    int adult;

    ConnectionDetector cd;
    ApiInterface apiInterface;

    String jType;

    MYdb mYdb;

    FareRequestApi fareRequestApi;

    int fare = 40;

    int typeT;

    RadioButton singleTrip, returnTrip;

    IncreamentDecreament mID;

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
        setContentView(R.layout.activity_home);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Ticket");
        } else {
            getSupportActionBar().setTitle("Ticket");
        }

        mID = new IncreamentDecreament(this);

        singleTrip = findViewById(R.id.single_radio_home);
        returnTrip = findViewById(R.id.return_radio_home);
        addAdult = findViewById(R.id.increase_adult_home);
        minusAdult = findViewById(R.id.decrease_adult_home);

        adultCount = findViewById(R.id.adult_number_home);

        previewBtn = findViewById(R.id.preview_home);
        adultFare = findViewById(R.id.adult_amount_home);

        discountFare = findViewById(R.id.discounted_fare_home);
        totalFare = findViewById(R.id.total_amount_home);
        actualFare = findViewById(R.id.actual_amount_home);
        back = findViewById(R.id.back_home);
        joourneyTIck = findViewById(R.id.juorneyTick);
        fromSpinner = findViewById(R.id.spinner_from);
        toSpinner = findViewById(R.id.spinner_to);
        amountToPay = findViewById(R.id.amounttopay_home);

        loadSpinnerData();


        int type = getIntent().getIntExtra("type", 0);

        if (type == 2) {
            returnTrip.setChecked(true);
            jType="RJT";
            typeT=2;

        }else
        {jType="SJT";
            typeT=1;}

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/CaviarDreams_Bold.ttf");
        joourneyTIck.setTypeface(typeface);
        actualFare.setTypeface(typeface);
        amountToPay.setTypeface(typeface);

        adultFare.setText("Rs 0.00");

        totalFare.setText("Rs 0.00");

        cd=new ConnectionDetector(this);

       fromSpinner.setOnItemSelectedListener(this);
       toSpinner.setOnItemSelectedListener(this);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mID.increase(adultCount);
                UpdateFare();
            }
        });

        minusAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mID.decrease(adultCount);
                UpdateFare();

            }
        });

        previewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isvalidation()) {

                    int adultCounting= Integer.parseInt(adultCount.getText().toString().trim());

                    Intent intent = new Intent(HomeActivity.this, JourneyPreviewActivity.class);
                    intent.putExtra("count", adult);
                    intent.putExtra("total", Total);
                    intent.putExtra("tiketType", jType);
                    intent.putExtra("disc", disc);
                    intent.putExtra("fare",fare);
                    intent.putExtra("amount", Actual);
                    startActivity(intent);
                }

            }
        });

    }

    private void UpdateFare() {
        adult = Integer.parseInt(adultCount.getText().toString());
        float adultFare = fare * adult;
         Total = adultFare;
        disc = Total * 10 / 100;
        Actual = Total - disc;

        this.adultFare.setText(String.format("Rs %.2f", adultFare));

        this.totalFare.setText(String.format("Rs %.2f", Total));
        this.discountFare.setText(String.format("Rs %.2f", disc));
        this.actualFare.setText(String.format("Rs %.2f", Actual));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    public boolean isvalidation() {

        String name1 = fromSpinner.getSelectedItem().toString();
        String name2 = toSpinner.getSelectedItem().toString();

        if (name1.equals("Null")) {
            ((TextView) fromSpinner.getChildAt(0)).setError("Select Location");
            return false;
        }
        if (name2.equals("Null")) {
            ((TextView) toSpinner.getSelectedView()).setError("Select Location");
            return false;
        }

        return true;
    }

    private void loadSpinnerData() {
        MYdb db = new MYdb(getApplicationContext());
        List<String> labels = db.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        fromSpinner.setSelection(0);
        toSpinner.setSelection(0);
        fromSpinner.setAdapter(dataAdapter);
        toSpinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String fromname= fromSpinner.getSelectedItem().toString();
        String toname= toSpinner.getSelectedItem().toString();
        if (!fromname.equals("Select your Station") && !toname.equals("Select your Station"));
        {
            mYdb = new MYdb(this);
            if (cd.isConnectingToInternet()) {
                loadData();
                apiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<FareResponse> call=apiInterface.getFare(fareRequestApi);
                call.enqueue(new Callback<FareResponse>() {
                    @Override
                    public void onResponse(Call<FareResponse> call, Response<FareResponse> response) {

                        if (response.code()==200){}




                    }

                    @Override
                    public void onFailure(Call<FareResponse> call, Throwable t) {



                    }
                });


            }
        }
    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void loadData() {
        int channelId = 1;
        String tokenId= AppPreferences.getAppPrefrences(VariablesConstant.TOKEN,this);

        String ticketType = jType;
        int srcStnId = mYdb.getStationId(fromSpinner.getSelectedItem().toString());
        int desStnId=mYdb.getStationId(toSpinner.getSelectedItem().toString());
        int paxType =3;
        int tktJrnyType=typeT;
        int noOfPax=1;

        FareRequestData payload=new FareRequestData(ticketType,srcStnId,desStnId,paxType,tktJrnyType,noOfPax);

        fareRequestApi=new FareRequestApi(channelId,tokenId,payload);
    }




}
