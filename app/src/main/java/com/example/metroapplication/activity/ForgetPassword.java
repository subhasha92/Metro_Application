package com.example.metroapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.metroapplication.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ForgetPassword extends AppCompatActivity {

    Button submit, verify, confirm;
    LinearLayout mobileLayout, otpLayout, passLayout;


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
        setContentView(R.layout.activity_forget_password);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Objects.requireNonNull(getSupportActionBar()).setTitle("Trip Details");
//        }else{getSupportActionBar().setTitle("Trip Details");}

        submit = findViewById(R.id.submit_forget_password);
        verify = findViewById(R.id.verify_forget_password);
        confirm = findViewById(R.id.confirm_forget_password_btn);
        mobileLayout = findViewById(R.id.mobile_layout);
        otpLayout = findViewById(R.id.otp_layout);
        passLayout = findViewById(R.id.password_layout);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mobileLayout.setVisibility(View.GONE);
                otpLayout.setVisibility(View.VISIBLE);

            }
        });

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                otpLayout.setVisibility(View.GONE);
                passLayout.setVisibility(View.VISIBLE);

            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPassword.this, LoginActivity.class);
                startActivity(intent);
                finish();


            }
        });
    }
}
