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
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.metroapplication.R;
import com.example.metroapplication.helper.IncreamentDecreament;
import com.example.metroapplication.utils.MenuActivity;

import java.util.Objects;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class HomeActivity extends MenuActivity {

    Spinner from, to;
    Button addAdult, minusAdult, addChild, minusChild, addSr, minusSr, previewBtn, back;
    TextView adultCount, childCount, srCount, adultFare, childFare, srFare, discountFare, totalFare, actualFare;
    TextView joourneyTIck, amountToPay;

    float adult, child, sr, disc, Actual;

    // --Commented out by Inspecti// --Commented out by Inspection (22-07-2020 18:46):on (22-07-2020 18:46):RadioGroup selectedTrips;
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
//        addChild=findViewById(R.id.increase_child_home);
//        minusChild=findViewById(R.id.decrease_child_home);
//        addSr=findViewById(R.id.increase_sr_home);
//        minusSr=findViewById(R.id.decrease_sr_home);
        adultCount = findViewById(R.id.adult_number_home);
//        childCount=findViewById(R.id.number_child_home);
//        srCount=findViewById(R.id.number_sr_home);
        previewBtn = findViewById(R.id.preview_home);
        adultFare = findViewById(R.id.adult_amount_home);
//        childFare=findViewById(R.id.child_amount_home);
//        srFare=findViewById(R.id.sr_amount_home);
        discountFare = findViewById(R.id.discounted_fare_home);
        totalFare = findViewById(R.id.total_amount_home);
        actualFare = findViewById(R.id.actual_amount_home);
        back = findViewById(R.id.back_home);
        joourneyTIck = findViewById(R.id.juorneyTick);
        from = findViewById(R.id.spinner_from);
        to = findViewById(R.id.spinner_to);
        amountToPay = findViewById(R.id.amounttopay_home);


        int type = getIntent().getIntExtra("type", 0);

        if (type == 2) {
            returnTrip.setChecked(true);
        }

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/CaviarDreams_Bold.ttf");
        joourneyTIck.setTypeface(typeface);
        actualFare.setTypeface(typeface);
        amountToPay.setTypeface(typeface);

        adultFare.setText("Rs 0.00");
//        childFare.setText("Rs 0.00");
//        srFare.setText("Rs 0.00");
        totalFare.setText("Rs 0.00");

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
//        addChild.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mID.increase(childCount);
//                UpdateFare();
//            }
//        });
//        addSr.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mID.increase(srCount);
//                UpdateFare();
//            }
//        });
        minusAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mID.decrease(adultCount);
                UpdateFare();

            }
        });
//        minusChild.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                mID.decrease(childCount);
//                UpdateFare();
//
//            }
//        });
//        minusSr.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                mID.decrease(srCount);
//                UpdateFare();
//
//            }
//        });

        previewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isvalidation()) {


                    Intent intent = new Intent(HomeActivity.this, JourneyPreviewActivity.class);
                    intent.putExtra("adult", adult);
//                intent.putExtra("child",child);
//                intent.putExtra("sr",sr);
                    intent.putExtra("disc", disc);
                    intent.putExtra("amount", Actual);
                    startActivity(intent);
                }

            }
        });

    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void UpdateFare() {

        adult = Float.parseFloat(adultCount.getText().toString());
        int fare = 40;
        float adultFare = fare * adult;
//         child= Float.parseFloat(childCount.getText().toString());
//        float childFare = fare * child;
//         sr= Float.parseFloat(srCount.getText().toString());
//        float srFare = fare * sr;
        float Total = adultFare;
        disc = Total * 10 / 100;
        Actual = Total - disc;

        this.adultFare.setText(String.format("Rs %.2f", adultFare));
//        this.childFare.setText(String.format("Rs %.2f", childFare));
//        this.srFare.setText(String.format("Rs %.2f", srFare));
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

        String name1 = from.getSelectedItem().toString();
        String name2 = to.getSelectedItem().toString();

        if (name1.equals("Null")) {
            ((TextView) from.getChildAt(0)).setError("Select Location");
            return false;
        }
        if (name2.equals("Null")) {
            ((TextView) to.getSelectedView()).setError("Select Location");
            return false;
        }

        return true;
    }
}
