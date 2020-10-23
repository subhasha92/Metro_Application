package com.example.metroapplication.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.metroapplication.R;
import com.example.metroapplication.apis.ApiClient;
import com.example.metroapplication.apis.ApiInterface;
import com.example.metroapplication.apis.apiModel.LoginModule;
import com.example.metroapplication.apis.apiModel.LoginPayload;
import com.example.metroapplication.apis.apiModel.LoginResponse;
import com.example.metroapplication.apis.apiModel.LoginResponseData;
import com.example.metroapplication.apis.apiModel.PassengerInfoSJTRequestData;
import com.example.metroapplication.apis.apiModel.SJTTicketGenerateRequest;
import com.example.metroapplication.apis.apiModel.SJTTicketGenerateResponse;
import com.example.metroapplication.apis.apiModel.SJTicketRequest;
import com.example.metroapplication.apis.apiModel.SJTicketRequestData;
import com.example.metroapplication.apis.apiModel.SjtQrResponse;
import com.example.metroapplication.constants.Constants;
import com.example.metroapplication.myDataBase.MYdb;
import com.example.metroapplication.sharedPref.AppPreferences;
import com.example.metroapplication.sharedPref.VariablesConstant;
import com.example.metroapplication.utils.ConnectionDetector;
import com.example.metroapplication.utils.MenuActivity;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class JourneyPreviewActivity extends MenuActivity{

    Button payNow, backBtn;

    TextView preview;

    TextView tvType, tvnOfT, tvAmount, tvDis, tvTotal ,tvFrom,tvTo;

    LinearLayout adultLayout;

    ConnectionDetector cd;

    ApiInterface apiInterface;
MYdb mYdb;
    SJTicketRequest sjTicketRequest;

    String pssType;
    int noOfTkt;
    float tktAmount;
    float discount;
    float amtPaid;
    float totalAmt;
    String type;
    int from;
    int to;

SJTTicketGenerateResponse sjtTicketGenerateResponse;
    SJTTicketGenerateRequest sjtTicketGenerateRequest;

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
        setContentView(R.layout.activity_journey_preview);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Preview");
        } else {
            getSupportActionBar().setTitle("Preview");
        }

        cd=new ConnectionDetector(this);
        mYdb=new MYdb(this);

        sjtTicketGenerateResponse= (SJTTicketGenerateResponse) getIntent().getSerializableExtra("data");

        pssType = "Adult";
        noOfTkt=sjtTicketGenerateResponse.getPayload().get(0).getPsgList().get(0).getNoOfTkt();
        tktAmount=sjtTicketGenerateResponse.getPayload().get(0).getPsgList().get(0).getTktAmount();
        discount=sjtTicketGenerateResponse.getPayload().get(0).getPsgList().get(0).getDiscount();
        amtPaid=sjtTicketGenerateResponse.getPayload().get(0).getPsgList().get(0).getAmtPaid();
        totalAmt=sjtTicketGenerateResponse.getPayload().get(0).getPsgList().get(0).getTotalAmt();
        from=sjtTicketGenerateResponse.getPayload().get(0).getSrcStnId();
        to=sjtTicketGenerateResponse.getPayload().get(0).getDestStnId();
        type=sjtTicketGenerateResponse.getPayload().get(0).getTktType();

        payNow = findViewById(R.id.pay_now_journey_preview);
        backBtn = findViewById(R.id.back_journey_preview);

        tvType=findViewById(R.id.ticket_type_journey_preview);
        tvnOfT=findViewById(R.id.number_of_ticket_journey_preview);
        tvAmount=findViewById(R.id.adult_journey_preview);
        tvDis=findViewById(R.id.dis_amount_journey_preview);
        tvTotal=findViewById(R.id.total_amount_journey_preview);
        tvFrom=findViewById(R.id.from_journey_preview);
        tvTo=findViewById(R.id.to_journey_preview);

        adultLayout = findViewById(R.id.adultLayout);

        preview = findViewById(R.id.preive_preview);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/CaviarDreams_Bold.ttf");
        preview.setTypeface(typeface);

        tvType.setText(type);
        tvnOfT.setText(String.valueOf(noOfTkt));
        tvAmount.setText(String.valueOf(totalAmt));
        tvDis.setText(String.valueOf(discount));
        tvTotal.setText(String.valueOf(amtPaid));
        tvFrom.setText(mYdb.getStationName(from));
        tvTo.setText(mYdb.getStationName(to));

        if (noOfTkt == 0) {
            adultLayout.setVisibility(View.GONE);
        }

        payNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cd.isConnectingToInternet()) {
                    final ProgressDialog progressdialog = ProgressDialog.show(
                            JourneyPreviewActivity.this, "Please wait",
                            "Loading please wait..", true);
                    progressdialog.show();
                    progressdialog.setCancelable(true);
                    loadData();
                    apiInterface = ApiClient.getClient().create(ApiInterface.class);
                    Call<SjtQrResponse> call=apiInterface.sjtBook(sjTicketRequest);

                    call.enqueue(new Callback<SjtQrResponse>() {
                        @Override
                        public void onResponse(Call<SjtQrResponse> call, Response<SjtQrResponse> response) {
                            if (response.code()==200){
                                //Toast.makeText(JourneyPreviewActivity.this, "Success" + response.body(), Toast.LENGTH_SHORT).show();
                                SjtQrResponse sjtQrResponse=response.body();
                                assert sjtQrResponse != null;
                                if (sjtQrResponse.getStatus()==200) {
                                    Intent intent = new Intent(JourneyPreviewActivity.this, PostPaymentActivity.class);
                                    intent.putExtra("data", sjtQrResponse);
                                    intent.putExtra("flag", 1);
                                    progressdialog.dismiss();
                                    startActivity(intent);
                                }else
                                {
                                    progressdialog.dismiss();
                                    Toast.makeText(JourneyPreviewActivity.this, "Server Error : " + sjtQrResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            }

                        }

                        @Override
                        public void onFailure(Call<SjtQrResponse> call, Throwable t) {

                        }
                    });

                }
//                Intent intent = new Intent(JourneyPreviewActivity.this, PostPaymentActivity.class);
//                startActivity(intent);

            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void loadData() {

        MYdb mYdb=new MYdb(this);
        PassengerInfoSJTRequestData passengerInfoSJTRequestData = new PassengerInfoSJTRequestData(pssType,noOfTkt,tktAmount,discount,amtPaid,totalAmt);

        List<PassengerInfoSJTRequestData> llst=new ArrayList<>();
        llst.add(passengerInfoSJTRequestData);

        String userId=AppPreferences.getAppPrefrences(VariablesConstant.USER_EMAIL,this);
        String tktBookingDate = String.valueOf(android.text.format.DateFormat.format("yyyy-MM-dd", new java.util.Date()));
        String srcStnId = String.valueOf(from);
        String destStnId = String.valueOf(to);

        long tktNo=sjtTicketGenerateResponse.getPayload().get(0).getTktNo();
        String cust_IPaddress = Constants.ipAddress;
        String cust_IMIE_No=Constants.imei;
        String tktType=type;
        String paymentMode="Credit Card";
        String paidAmt=String.valueOf(amtPaid);

        String PaymentId="P"+tktNo;

        String token=AppPreferences.getAppPrefrences(VariablesConstant.TOKEN,this);

        SJTicketRequestData sjTicketRequestData=new SJTicketRequestData(userId,tktBookingDate,srcStnId,destStnId,tktNo,cust_IPaddress,cust_IMIE_No,tktType,llst,paymentMode,paidAmt,PaymentId);

        sjTicketRequest=new SJTicketRequest(1,token,sjTicketRequestData );

    }

}
