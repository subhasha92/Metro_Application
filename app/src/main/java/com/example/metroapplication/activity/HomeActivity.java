package com.example.metroapplication.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
import com.example.metroapplication.apis.apiModel.PassengerInfoSJTRequestData;
import com.example.metroapplication.apis.apiModel.SJTTicketGenerateRequest;
import com.example.metroapplication.apis.apiModel.SJTTicketGenerateRequestData;
import com.example.metroapplication.apis.apiModel.SJTTicketGenerateResponse;
import com.example.metroapplication.apis.apiModel.SJTicketRequest;
import com.example.metroapplication.apis.apiModel.SJTicketRequestData;
import com.example.metroapplication.constants.Constants;
import com.example.metroapplication.helper.IncreamentDecreament;
import com.example.metroapplication.myDataBase.MYdb;
import com.example.metroapplication.sharedPref.AppPreferences;
import com.example.metroapplication.sharedPref.VariablesConstant;
import com.example.metroapplication.utils.ConnectionDetector;
import com.example.metroapplication.utils.MenuActivity;
import com.google.gson.JsonElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class HomeActivity extends MenuActivity {

    Spinner fromSpinner, toSpinner;
    Button addAdult, minusAdult, previewBtn, back;
    TextView adultCount, adultFare, discountFare, totalFare, actualFare;
    TextView joourneyTIck, amountToPay;

    float disc = 0, Actual;
    float Total;
    int adult = 0;

    String pssType;
    int noOfTkt;
    float tktAmount;
    float discount;
    float amtPaid;
    float totalAmt;
    String type, from, to;

    ConnectionDetector cd;
    ApiInterface apiInterface;
    SJTTicketGenerateRequest sjtTicketGenerateRequest;

    String jType;

    MYdb mYdb;

    FareRequestApi fareRequestApi;

    int fare = 0;

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
            Objects.requireNonNull(getSupportActionBar()).setTitle("Ticket");
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
            jType = "RJT";
            typeT = 2;

        } else {
            jType = "SJT";
            typeT = 1;
        }

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/CaviarDreams_Bold.ttf");
        joourneyTIck.setTypeface(typeface);
        actualFare.setTypeface(typeface);
        amountToPay.setTypeface(typeface);

        adultFare.setText("Rs 0.00");

        totalFare.setText("Rs 0.00");

        cd = new ConnectionDetector(this);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int from=fromSpinner.getSelectedItemPosition();
                int to=toSpinner.getSelectedItemPosition();

                if(from!=0 && to !=0) {
                    mID.increase(adultCount);
                    dataUpdate();
                }

            }
        });

        minusAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int from=fromSpinner.getSelectedItemPosition();
                int to=toSpinner.getSelectedItemPosition();

                if(from!=0 && to !=0) {
                    mID.decrease(adultCount);
                    dataUpdate();
                }
            }
        });

        previewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isvalidation()) {


                    int adultCounting = Integer.parseInt(adultCount.getText().toString().trim());


                    if (adultCounting!=0){
                        final ProgressDialog progressdialog = ProgressDialog.show(
                                HomeActivity.this, "Please wait",
                                "Loading please wait..", true);
                        progressdialog.show();
                        progressdialog.setCancelable(true);

                        loadData1();
                        Call<SJTTicketGenerateResponse> call=apiInterface.generateTicketID(sjtTicketGenerateRequest);

                        call.enqueue(new Callback<SJTTicketGenerateResponse>() {
                            @Override
                            public void onResponse(Call<SJTTicketGenerateResponse> call, Response<SJTTicketGenerateResponse> response) {

                                if (response.code()==200) {
                                    SJTTicketGenerateResponse sjtTicketGenerateResponse=response.body();
                                    assert sjtTicketGenerateResponse != null;
                                    if (sjtTicketGenerateResponse.getStatus()==200) {
                                        Intent intent = new Intent(HomeActivity.this, JourneyPreviewActivity.class);
                                        intent.putExtra("data", (Serializable) sjtTicketGenerateResponse);
                                        startActivity(intent);
                                    }
                                }

                            }

                            @Override
                            public void onFailure(Call<SJTTicketGenerateResponse> call, Throwable t) {

                            }
                        });

                }}

            }
        });

    }

    private void UpdateFare() {

        float adultFare = fare;
        Total = adultFare;
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

    private void dataUpdate() {

        final ProgressDialog progressdialog = ProgressDialog.show(
                HomeActivity.this, "Please wait",
                "Loading please wait..", true);
        progressdialog.show();
        progressdialog.setCancelable(true);

        int fromname = fromSpinner.getSelectedItemPosition();
        int toname = toSpinner.getSelectedItemPosition();
        adult = Integer.parseInt(adultCount.getText().toString());
        if (fromname != 0) {
            if (toname != 0) {
                Log.i("calling :" + fromname, "Call :" + toname);
                if (fromname != toname) {
                    if (adult != 0) {
                        Toast.makeText(this, "" + fromname + "     " + toname, Toast.LENGTH_LONG).show();
                        mYdb = new MYdb(this);
                        if (cd.isConnectingToInternet()) {
                            loadData();
                            apiInterface = ApiClient.getClient().create(ApiInterface.class);
                            Call<FareResponse> call = apiInterface.getFare(fareRequestApi);
                            call.enqueue(new Callback<FareResponse>() {
                                @Override
                                public void onResponse(Call<FareResponse> call, Response<FareResponse> response) {
                                    if (response.code() == 200) {
                                        FareResponse fareResponse = response.body();
                                        assert fareResponse != null;
                                        if (fareResponse.getStatus() == 200) {

                                            fare = Integer.parseInt(fareResponse.getPayload().get(0).getFareAmt());
                                            disc = Float.parseFloat(fareResponse.getPayload().get(0).getDiscount());
                                            UpdateFare();
                                            progressdialog.dismiss();

                                        }else
                                        {
                                            progressdialog.dismiss();
                                            Toast.makeText(HomeActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                }

                                @Override
                                public void onFailure(Call<FareResponse> call, Throwable t) {

                                    progressdialog.dismiss();
                                    Toast.makeText(HomeActivity.this, "Failed : "+t.getCause(), Toast.LENGTH_SHORT).show();


                                }
                            });


                        }
                    }
                }
            }
        }
    }

    private void loadSpinnerData() {
        MYdb db = new MYdb(getApplicationContext());
        List<String> labels = db.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, labels);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner

        fromSpinner.setSelection(0);
        toSpinner.setSelection(0);
        fromSpinner.setAdapter(dataAdapter);
        toSpinner.setAdapter(dataAdapter);


    }


    private void loadData() {
        int channelId = 1;
        String tokenId = AppPreferences.getAppPrefrences(VariablesConstant.TOKEN, this);
        String ticketType = jType;
        int srcStnId = mYdb.getStationId(fromSpinner.getSelectedItem().toString());
        int desStnId = mYdb.getStationId(toSpinner.getSelectedItem().toString());
        int paxType = 3;
        int tktJrnyType = typeT;
        int noOfPax = adult;
        FareRequestData payload = new FareRequestData(ticketType, srcStnId, desStnId, paxType, tktJrnyType, noOfPax);
        fareRequestApi = new FareRequestApi(channelId, tokenId, payload);
    }

    public void loadData1(){

        pssType = "Adult";
        noOfTkt=adult;
        tktAmount=fare;
        discount=disc;
        amtPaid=Actual;
        totalAmt=Total;
        type=jType;

        PassengerInfoSJTRequestData passengerInfoSJTRequestData = new PassengerInfoSJTRequestData(pssType,noOfTkt,tktAmount,discount,amtPaid,totalAmt);

        List<PassengerInfoSJTRequestData> llst=new ArrayList<>();
        llst.add(passengerInfoSJTRequestData);

        String userId=AppPreferences.getAppPrefrences(VariablesConstant.USER_EMAIL,this);
        String srcStnId = String.valueOf(mYdb.getStationId(fromSpinner.getSelectedItem().toString()));
        String desStnId = String.valueOf(mYdb.getStationId(toSpinner.getSelectedItem().toString()));
        String cust_IPaddress = Constants.ipAddress;
        String cust_IMIE_No=Constants.imei;
        String tktType=type;

        String token=AppPreferences.getAppPrefrences(VariablesConstant.TOKEN,this);

        SJTTicketGenerateRequestData sjtTicketGenerateRequestData=new SJTTicketGenerateRequestData(userId, srcStnId,desStnId,cust_IPaddress,cust_IMIE_No,tktType,llst);

        sjtTicketGenerateRequest=new SJTTicketGenerateRequest(1,token,sjtTicketGenerateRequestData );

    }

}
