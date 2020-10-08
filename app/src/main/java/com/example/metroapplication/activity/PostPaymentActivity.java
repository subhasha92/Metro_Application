package com.example.metroapplication.activity;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.metroapplication.R;
import com.example.metroapplication.apis.apiModel.IssueValueQRResponse;
import com.example.metroapplication.apis.apiModel.SjtQrResponse;
import com.example.metroapplication.utils.MenuActivity;
import com.example.metroapplication.utils.QRGenerator;

import java.io.Serializable;
import java.util.Objects;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class PostPaymentActivity extends MenuActivity {

    String qrText;
    Toast toast;
    ImageView imageView;
    ProgressBar pb;

    TextView tvFrom,tvTo,tvAmountPaiḍ,tvDate,tvTime,tvValid,tvPmtId,tvTcktId,tvTrnscId;

    LinearLayout llFrom, llTo;

    TextView yourPay, yourText;

    int flag;
    SjtQrResponse sjtQrResponse;
    IssueValueQRResponse issueValueQRResponse;

    QRGenerator qr;

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
        setContentView(R.layout.activity_post_payment);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Payment ");
        } else {
            getSupportActionBar().setTitle("Payment");
        }

        tvFrom=findViewById(R.id.from_post_payment);
        tvTo=findViewById(R.id.to_post_payment);
        tvAmountPaiḍ=findViewById(R.id.amount_paid_post_payment);
        tvDate=findViewById(R.id.date_post_payment);
        tvTime=findViewById(R.id.time_post_payment);
        tvValid=findViewById(R.id.valid_post_payment);
        tvPmtId=findViewById(R.id.payment_id_post_payment);
        tvTcktId=findViewById(R.id.ticket_id_post_payment);
        tvTrnscId=findViewById(R.id.transaction_id_post_payment);
        llFrom=findViewById(R.id.fromlinear_post_payment);
        llTo=findViewById(R.id.tolinear_post_payment);


        flag=getIntent().getIntExtra("flag",0);
        if (flag==1)
        {
            sjtQrResponse= (SjtQrResponse) getIntent().getSerializableExtra("data");
        qrText=String.valueOf(sjtQrResponse.getPayload().get(0).getQrTicketHash())==null?"subhash":String.valueOf(sjtQrResponse.getPayload().get(0).getQrTicketHash());
        tvAmountPaiḍ.setText(String.valueOf(sjtQrResponse.getPayload().get(0).getPaidAmt()));
        tvDate.setText(String.valueOf(sjtQrResponse.getPayload().get(0).getTktBookingdt()));
        tvValid.setText(String.valueOf(sjtQrResponse.getPayload().get(0).getTkt_validity()));
        tvPmtId.setText(String.valueOf(sjtQrResponse.getPayload().get(0).getPmtId()));
        tvTcktId.setText(String.valueOf(sjtQrResponse.getPayload().get(0).getTktNo()));

        }else{
            issueValueQRResponse= (IssueValueQRResponse) getIntent().getSerializableExtra("data");
            llFrom.setVisibility(View.GONE);
            llTo.setVisibility(View.GONE);
            qrText=issueValueQRResponse.getPayload().get(0).getQrTicketHash()==null?"subhash":issueValueQRResponse.getPayload().get(0).getQrTicketHash();
            tvAmountPaiḍ.setText(String.valueOf(issueValueQRResponse.getPayload().get(0).getAmount()));
            tvDate.setText(String.valueOf(issueValueQRResponse.getPayload().get(0).getIssueDate()));
            tvValid.setText(String.valueOf(issueValueQRResponse.getPayload().get(0).getTicketValidity()));
            tvPmtId.setText(String.valueOf(issueValueQRResponse.getPayload().get(0).getFullTicketNo()));
            tvTcktId.setText(String.valueOf(issueValueQRResponse.getPayload().get(0).getTicketId()));
        }

        imageView = findViewById(R.id.imageview_ticket_qr);
        pb = findViewById(R.id.progress_post_payment);
        qr = new QRGenerator();

        yourPay = findViewById(R.id.yourPayment);
        yourText = findViewById(R.id.yourText);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/CaviarDreams_Bold.ttf");
        yourPay.setTypeface(typeface);
        yourText.setTypeface(typeface);


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
