package com.example.metroapplication.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.metroapplication.R;
import com.example.metroapplication.utils.ConnectionDetector;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class RegistrationActivity extends Activity {
    EditText edtfirstName, edtlastName, edtmob, edtEmail, edtPassword, edtConfirmPassword;
    Button btnRegistration;
    TextView txtAlreadyUser, cmpleteProfile;
   ConnectionDetector cd;
    String firstName, lastName, mobileNo, email, password;
    //Registration reg;
    final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

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

        setContentView(R.layout.activity_registration);


        btnRegistration = (Button) findViewById(R.id.registrationBtn);
        edtfirstName = (EditText) findViewById(R.id.first_name);
        edtlastName = (EditText) findViewById(R.id.last_name);
        edtmob = (EditText) findViewById(R.id.mobile);
        edtConfirmPassword = (EditText) findViewById(R.id.register_confirm_password);
        edtEmail = (EditText) findViewById(R.id.register_email);
        edtPassword = (EditText) findViewById(R.id.register_password);
        txtAlreadyUser = (TextView) findViewById(R.id.new_user_signup);
        cmpleteProfile=findViewById(R.id.complete_profile);
        cd = new ConnectionDetector(RegistrationActivity.this);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/CaviarDreams_Bold.ttf");
        cmpleteProfile.setTypeface(typeface);

        txtAlreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });


        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //UI Testing
                if (isvalidation()){
                    Intent i = new Intent (RegistrationActivity.this, OtpActivity.class);
                    startActivity(i);
                }

            }
        });
    }




    public boolean isvalidation() {

        Pattern ps = Pattern.compile("^[a-zA-Z ]+$");
        Matcher fname = ps.matcher(edtfirstName.getText().toString());
        Matcher lname = ps.matcher(edtfirstName.getText().toString());
        boolean isfnameValid = fname.matches();
        boolean isLnameValid = lname.matches();

        if (edtfirstName.getText().toString().trim().length() == 0) {
            edtfirstName.setError("Please Enter First Name");
            return false;
        } else if (!isfnameValid) {
            edtfirstName.setError("Please Enter Valid First Name");
            return false;
        } else if (edtlastName.getText().toString().trim().length() == 0) {
            edtlastName.setError("Please Enter Last Name");
            return false;
        } else if (!isLnameValid) {
            edtlastName.setError("Please Enter Valid Last Name");
            return false;
        } else if (edtmob.length() == 0) {
            edtmob.setError("Please Enter Mobile Number");
            return false;
        } else if (edtmob.length() < 10) {
            edtmob.setError("Please Enter valid Mobile Number");
            return false;
        } else if (edtEmail.getText().toString().trim().length() == 0) {
            edtEmail.setError("Please Enter Email");
            return false;
        } else if (!edtEmail.getText().toString().matches(emailPattern)) {
            edtEmail.setError("Please Enter Valid Email");
            return false;
        } else if (edtPassword.getText().toString().trim().length() == 0) {
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
