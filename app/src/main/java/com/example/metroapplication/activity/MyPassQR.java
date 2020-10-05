package com.example.metroapplication.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.metroapplication.R;
import com.example.metroapplication.utils.MenuActivity;
import com.example.metroapplication.utils.QRGenerator;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MyPassQR extends MenuActivity {

    ProgressBar pb;
    ImageView imageView;
    QRGenerator qr;
    String qrText;
    Toast toast;


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
        setContentView(R.layout.activity_my_pass_q_r);

        pb = findViewById(R.id.progress_pass_qr);
        imageView = findViewById(R.id.imageview_pass_qr);

        qrText = "Subhash";
        qr = new QRGenerator();


        if (qrText == null || "".equals(qrText) || qrText.length() < 1) {
            toast.setText("Input in Empty");
            toast.show();
            return;
        } else {
            qr.createQR(qrText, imageView);
        }

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                pb.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
            }
        }, 1000);


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
