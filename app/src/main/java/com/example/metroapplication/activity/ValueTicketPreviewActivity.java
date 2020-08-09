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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.metroapplication.apis.ApiClient;
import com.example.metroapplication.apis.ApiInterface;
import com.example.metroapplication.apis.apiModel.IssueValueQRData;
import com.example.metroapplication.apis.apiModel.IssueValueQRRequest;
import com.example.metroapplication.apis.apiModel.IssueValueQRResponse;
import com.example.metroapplication.constants.Constants;
import com.example.metroapplication.utils.ConnectionDetector;
import com.example.metroapplication.utils.MenuActivity;
import com.example.metroapplication.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ValueTicketPreviewActivity extends MenuActivity {

    Button Backbtn, PaynowBtn;

    IssueValueQRData issueValueQRData;
    IssueValueQRRequest issueValueQRRequest;

    ApiInterface apiInterface;

    float value;
    ConnectionDetector cd;

    TextView preview, previewAmount;
    private String TAG = ValueTicketPreviewActivity.class.getName();

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
        setContentView(R.layout.activity_value_ticket_preview);




        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Preview");
        }else{getSupportActionBar().setTitle("Preview");}

        Backbtn=findViewById(R.id.back_btn_vt_preview);
        PaynowBtn=findViewById(R.id.pay_now_btn_vt_preview);

        preview=findViewById(R.id.preive_preview);
        previewAmount=findViewById(R.id.total_amount_vt_preview);
        cd=new ConnectionDetector(this);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/CaviarDreams_Bold.ttf");
        preview.setTypeface(typeface);

         value = getIntent().getFloatExtra("amount",0.00f);

        previewAmount.setText(String.format("Rs %s", value));

        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        PaynowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (value>0)
                {
                    if (cd.isConnectingToInternet()) {
                        final ProgressDialog progressdialog = ProgressDialog.show(
                                ValueTicketPreviewActivity.this, "Please wait",
                                "Loading please wait..", true);
                        progressdialog.show();
                        progressdialog.setCancelable(true);
                        loadData();
                        final String requestBody = issueValueQRRequest.toString();
                        System.out.println("Detail:" + requestBody);
                        apiInterface= ApiClient.getClient().create(ApiInterface.class);
                        Call<IssueValueQRResponse> call=apiInterface.issueValueQR(issueValueQRRequest);

                        call.enqueue(new Callback<IssueValueQRResponse>() {
                            @Override
                            public void onResponse(@NotNull Call<IssueValueQRResponse> call, @NotNull Response<IssueValueQRResponse> response) {

                            IssueValueQRResponse reg = response.body();
//                                Log.i(TAG, "onResponse: "+reg);
//                                progressdialog.dismiss();
//                                Toast.makeText(ValueTicketPreviewActivity.this, ""+response.code(), Toast.LENGTH_SHORT).show();

                                assert reg != null;
                                if (reg.getStatus()==200){
                                    progressdialog.dismiss();

                                    String msg = reg.getMessage();
                                    Log.i(TAG, "onResponse: " + msg);
                                    Toast.makeText(ValueTicketPreviewActivity.this, msg, Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(ValueTicketPreviewActivity.this, PostPaymentActivity.class);
                                    startActivity(intent);
                                    finish();

                                }else if (reg.getStatus() == 400) {
                                    progressdialog.dismiss();
                                    String msg = reg.getMessage();
                                    Log.i(TAG, "onResponse: " + msg);
                                    Toast.makeText(ValueTicketPreviewActivity.this, msg, Toast.LENGTH_SHORT).show();
                                }
                            }
                            @Override
                            public void onFailure(Call<IssueValueQRResponse> call, Throwable t) {
                               String msg= t.getCause().toString();
                                Log.i(TAG, "onFailure: "+msg);
                                progressdialog.dismiss();

                                Toast.makeText(ValueTicketPreviewActivity.this, "Server Error : Please try later", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }else {
                        Toast.makeText(ValueTicketPreviewActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private void loadData() {
        String paymnetMode = "NetBanking";
        issueValueQRData=new IssueValueQRData(value,paymnetMode, Constants.ipAddress,Constants.imei);
        issueValueQRRequest=new IssueValueQRRequest(1,"tok1234",issueValueQRData);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
