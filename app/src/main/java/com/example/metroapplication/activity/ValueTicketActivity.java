package com.example.metroapplication.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
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

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ValueTicketActivity extends MenuActivity {

    Button Backbtn, PaynowBtn, btn1, btn2, btn3, btn4;


    TextView textView;
    float number=0.00f;




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
        setContentView(R.layout.activity_value_ticket);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Value Ticket");
        }else{
            Objects.requireNonNull(getSupportActionBar()).setTitle("Value Ticket");}


        Backbtn=findViewById(R.id.back_btn_vt);
        PaynowBtn=findViewById(R.id.pay_now_btn_vt);
        btn1=findViewById(R.id.btn_1_vt);
        btn2=findViewById(R.id.btn_2_vt);
        btn3=findViewById(R.id.btn_3_vt);
        btn4=findViewById(R.id.btn_4_vt);
        textView=findViewById(R.id.total_amount_vt);



        btn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View v) {

                number=number +Float.parseFloat(btn1.getText().toString());
                textView.setText(String.format("Rs %.2f",number));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View v) {
                number=number +Float.parseFloat(btn2.getText().toString());
                textView.setText(String.format("Rs %.2f",number));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View v) {
                number=number +Float.parseFloat(btn3.getText().toString());
                textView.setText(String.format("Rs %.2f",number));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View v) {
                number=number +Float.parseFloat(btn4.getText().toString());
                textView.setText(String.format("Rs %.2f",number));
            }
        });

        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        PaynowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Float.parseFloat(textView.getText().toString().substring(3))>0) {
                    Intent intent = new Intent(ValueTicketActivity.this, ValueTicketPreviewActivity.class);
                    intent.putExtra("amount",Float.parseFloat(textView.getText().toString().substring(3)));
                    startActivity(intent);
                }

            }
        });
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
