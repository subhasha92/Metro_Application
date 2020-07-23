package com.example.metroapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.metroapplication.helper.IncreamentDecreament;
import com.example.metroapplication.utils.MenuActivity;
import com.example.metroapplication.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class PassActivity extends MenuActivity {

    IncreamentDecreament mID;
    Button addAdult, minusAdult, addChild, minusChild, addSr, minusSr, previewBtn, backBtn;
    TextView adultCount, childCount, srCount, adultFare, childFare, srFare, discountFare, totalFare, actualFare;

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
        setContentView(R.layout.activity_pass);

        mID =new IncreamentDecreament(this);
        addAdult = findViewById(R.id.increase_adult_home);
        minusAdult=findViewById(R.id.decrease_adult_home);
        addChild=findViewById(R.id.increase_child_home);
        minusChild=findViewById(R.id.decrease_child_home);
        addSr=findViewById(R.id.increase_sr_home);
        minusSr=findViewById(R.id.decrease_sr_home);
        adultCount=findViewById(R.id.adult_number_home);
        childCount=findViewById(R.id.number_child_home);
        srCount=findViewById(R.id.number_sr_home);
        previewBtn=findViewById(R.id.pay_now_btn_pass);
        adultFare=findViewById(R.id.adult_amount_home);
        childFare=findViewById(R.id.child_amount_home);
        srFare=findViewById(R.id.sr_amount_home);

        totalFare=findViewById(R.id.total_amount_home);
        actualFare=findViewById(R.id.actual_amount_pass);
        backBtn=findViewById(R.id.back_btn_pass);



        addAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mID.increase(adultCount);
                UpdateFare();
            }
        });
        addChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mID.increase(childCount);
                UpdateFare();
            }
        });
        addSr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mID.increase(srCount);
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
        minusChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mID.decrease(childCount);
                UpdateFare();

            }
        });
        minusSr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mID.decrease(srCount);
                UpdateFare();

            }
        });

        previewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PassActivity.this,PassPreviewActivity.class);
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

        int adult= Integer.parseInt(adultCount.getText().toString());
        int fare = 150;
        int adultFare = fare * adult;
        int child= Integer.parseInt(childCount.getText().toString());
        int childFare = fare * child;
        int sr= Integer.parseInt(srCount.getText().toString());
        int srFare = fare * sr;
        int Total= adultFare + childFare + srFare;

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
}
