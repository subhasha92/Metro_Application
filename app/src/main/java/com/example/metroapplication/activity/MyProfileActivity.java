package com.example.metroapplication.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.metroapplication.R;
import com.example.metroapplication.sharedPref.AppPreferences;
import com.example.metroapplication.sharedPref.VariablesConstant;
import com.example.metroapplication.utils.MenuActivity;

import java.util.Objects;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MyProfileActivity extends MenuActivity {

    Button chPassword, Backbtn, SaveBtn;
    EditText etFname, etLname, etEmai,etMobile,etAddress,etCity,etState,etPincode;

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
        setContentView(R.layout.activity_my_profile);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle("My Profile");
        } else {
            getSupportActionBar().setTitle("My Profile");
        }

        // chPassword=findViewById(R.id.chpass_btn_my_profile);

        etFname=findViewById(R.id.fname_my_profile);
        etLname=findViewById(R.id.lname_my_profile);
        etMobile=findViewById(R.id.mobile_my_profile);
        etEmai=findViewById(R.id.email_my_profile);
        etAddress=findViewById(R.id.address_my_profile);
        etCity=findViewById(R.id.city_my_profile);
        etState=findViewById(R.id.state_my_profile);
        etPincode=findViewById(R.id.pin_my_profile);


        Backbtn = findViewById(R.id.back_btn_my_profile);
        SaveBtn = findViewById(R.id.save_btn_my_profile);

        etMobile.setEnabled(false);

        etFname.setText(AppPreferences.getAppPrefrences(VariablesConstant.USER_FIRSTNAME,this));
        etLname.setText(AppPreferences.getAppPrefrences(VariablesConstant.USER_LASTNAME,this));
        etMobile.setText(AppPreferences.getAppPrefrences(VariablesConstant.MOBILE,this));
        etEmai.setText(AppPreferences.getAppPrefrences(VariablesConstant.USER_EMAIL,this));


        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyProfileActivity.this, "Profile Updated", Toast.LENGTH_SHORT).show();
            }
        });

//        chPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MyProfileActivity.this, ChangePassword.class);
//                startActivity(intent);
//
//            }
//        });

        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
