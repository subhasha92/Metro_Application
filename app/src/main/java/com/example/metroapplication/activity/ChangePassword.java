package com.example.metroapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.metroapplication.utils.MenuActivity;
import com.example.metroapplication.R;

import java.util.Objects;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ChangePassword extends MenuActivity {

    Button submit;
    EditText edtPassword, edtConfirmPassword;

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
        setContentView(R.layout.activity_change_password);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Change Password");
        }else{getSupportActionBar().setTitle("Change Password");}

        submit=findViewById(R.id.submit_chnPasswordBtn);
        edtPassword=findViewById(R.id.new_pass_chp);
        edtConfirmPassword=findViewById(R.id.confirm_pass_chp);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChangePassword.this,MainActivity.class);
                startActivity(intent);
                finish();
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



    public boolean isvalidation() {


         if (edtPassword.getText().toString().trim().length() == 0) {
            edtPassword.setError("Please Enter Password");
            return false;
        } else if (edtConfirmPassword.length() == 0) {
            edtConfirmPassword.setError("Please Enter Confirm Password");
            return false;
        }else if (!edtPassword.getText().toString().equals(edtConfirmPassword.getText().toString())) {
            edtConfirmPassword.setError("Confirm Password doesn't Match");
//            edtConfirmPassword.setText("");
            return false;
        }

        return true;
    }

}
