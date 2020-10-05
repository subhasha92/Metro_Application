package com.example.metroapplication.activity;

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

import com.example.metroapplication.R;
import com.example.metroapplication.utils.MenuActivity;

import java.util.Objects;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class JourneyPreviewActivity extends MenuActivity {

    Button payNow, backBtn;

    TextView preview;

    LinearLayout adultLayout;


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

        float adultCount = getIntent().getFloatExtra("adult", 0);
//        float childCount= getIntent().getFloatExtra("child",0);
//        float srCount= getIntent().getFloatExtra("sr",0);
        float disc = getIntent().getFloatExtra("disc", 0);
        float actual = getIntent().getFloatExtra("amount", 0);

        payNow = findViewById(R.id.pay_now_journey_preview);
        backBtn = findViewById(R.id.back_journey_preview);

        adultLayout = findViewById(R.id.adultLayout);
//        childLayout=findViewById(R.id.childLayout);
//        srLayout=findViewById(R.id.srLayout);
        preview = findViewById(R.id.preive_preview);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/CaviarDreams_Bold.ttf");
        preview.setTypeface(typeface);

        if (adultCount == 0.0) {
            adultLayout.setVisibility(View.GONE);
        }
//        if (childCount==0.0){
//            childLayout.setVisibility(View.GONE);
//        }
//        if (srCount==0.0){
//            srLayout.setVisibility(View.GONE);
//        }


        payNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JourneyPreviewActivity.this, PostPaymentActivity.class);
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
}
