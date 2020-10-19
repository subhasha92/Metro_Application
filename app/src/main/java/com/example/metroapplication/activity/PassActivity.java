package com.example.metroapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.metroapplication.R;
import com.example.metroapplication.helper.IncreamentDecreament;
import com.example.metroapplication.myDataBase.MYdb;
import com.example.metroapplication.utils.MenuActivity;

import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static android.text.Html.FROM_HTML_MODE_LEGACY;

public class PassActivity extends MenuActivity {

    IncreamentDecreament mID;
    Spinner fromSpinner, toSpinner;
    RadioGroup rg;
    RadioButton radioButton ,rb1,rb2,rb3;
    Button addAdult, minusAdult, addChild, minusChild, addSr, minusSr, previewBtn, backBtn;
    TextView adultCount, childCount, srCount, adultFare, childFare, srFare, discountFare, totalFare, actualFare;

    @Override       // for font style
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/caviar_dreams.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.activity_pass);



        previewBtn = findViewById(R.id.pay_now_btn_pass);




        fromSpinner = findViewById(R.id.spinner_from);
        toSpinner = findViewById(R.id.spinner_to);
        backBtn = findViewById(R.id.back_btn_pass);
        loadSpinnerData();
//        if (fromSpinner.getDisplay().toString().equals("Null") || toSpinner.getDisplay().toString().equals("Null")) {
//            rg.setEnabled(false);
//        }
        int amount=400;

//        int amount= 440;
//        Resources res = getResources();
//        String text=getString(R.string.pass_details,amount);
////        Spanned styledText = Html.fromHtml(text, FROM_HTML_MODE_LEGACY);
//        radioButton.setText(""+text);




        previewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PassActivity.this, PassPreviewActivity.class);
                startActivity(intent);

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void UpdateFare() {

        int adult = Integer.parseInt(adultCount.getText().toString());
        int fare = 150;
        int adultFare = fare * adult;
        int child = Integer.parseInt(childCount.getText().toString());
        int childFare = fare * child;
        int sr = Integer.parseInt(srCount.getText().toString());
        int srFare = fare * sr;
        int Total = adultFare + childFare + srFare;

        this.adultFare.setText(String.valueOf(adultFare));
        this.childFare.setText(String.valueOf(childFare));
        this.srFare.setText(String.valueOf(srFare));
        this.totalFare.setText(String.valueOf(Total));
        actualFare.setText(String.valueOf(Total));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
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
}
