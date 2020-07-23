package com.example.metroapplication.activity;




import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.metroapplication.R;
import com.example.metroapplication.utils.ConnectionDetector;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity {

    Button mloginBtn;
    TextView forgotPwd, signUpLink;
    EditText emailInput, passwordInput;
    CheckBox showHide;
    ConnectionDetector cd;
    String email, password;
    //LoginResponse logresponse;
    String fname, lname, emailID, mobileNumber, userPassword, userStatus;
    int userID;

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
        setContentView(R.layout.activity_login);

        mloginBtn = (Button) findViewById(R.id.loginbtn);
        forgotPwd = (TextView) findViewById(R.id.forgot_pswd);
        signUpLink = (TextView) findViewById(R.id.new_user_signup);
        emailInput = (EditText) findViewById(R.id.email_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
        showHide = (CheckBox) findViewById(R.id.show_hide_checkbox);
        cd = new ConnectionDetector(LoginActivity.this);
        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);

            }
        });


        mloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //UI Testing
                    Intent intent = new Intent(LoginActivity.this, MyTicketQR.class);
                    startActivity(intent);

            }
        });

        forgotPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetPassword.class);
                startActivity(intent);

            }
        });

        showHide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    passwordInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    showHide.setText("Show Password");
                } else {

              passwordInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    showHide.setText("Hide Password");
                }
            }
        });

    }
    public boolean isvalidation() {

        if (emailInput.length() == 0) {
            emailInput.setError("Please Enter the email");
            return false;
        } else if (passwordInput.length() == 0) {
            passwordInput.setError("Please Enter the Password");
            return false;
        }

        return true;
    }

}
