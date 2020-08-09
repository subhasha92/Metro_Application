package com.example.metroapplication.activity;




import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.metroapplication.R;
import com.example.metroapplication.constants.Constants;
import com.example.metroapplication.utils.ConnectionDetector;
import com.example.metroapplication.utils.PermissionManagerUtil;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static android.Manifest.permission.READ_PHONE_STATE;
import static com.example.metroapplication.utils.PermissionManagerUtil.REQUEST_PERMISSION_PHONE_STATE;

public class LoginActivity extends AppCompatActivity {

    Button mloginBtn;
    TextView forgotPwd, signUpLink;
    EditText emailInput, passwordInput;
    CheckBox showHide;
    PermissionManagerUtil pm;
    ConnectionDetector cd;
    String email, password;
    //LoginResponse logresponse;
    String fname, lname, emailID, mobileNumber, userPassword, userStatus;
    int userID;

    @Override       // for font style
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @SuppressLint("HardwareIds")
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
        pm=new PermissionManagerUtil(this);
        pm.showPhoneStatePermission();
        Constants.ipAddress=pm.getLocalIpAddress();
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if(PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(this,READ_PHONE_STATE))
        {
            Constants.imei = telephonyManager.getDeviceId();
        }

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


    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            String permissions[],
            int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_PHONE_STATE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission Granted!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Permission Denied!", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + requestCode);
        }
    }

}
