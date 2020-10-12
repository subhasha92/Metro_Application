package com.example.metroapplication.activity;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
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

import com.example.metroapplication.R;
import com.example.metroapplication.apis.ApiClient;
import com.example.metroapplication.apis.ApiInterface;
import com.example.metroapplication.apis.apiModel.LoginModule;
import com.example.metroapplication.apis.apiModel.LoginPayload;
import com.example.metroapplication.apis.apiModel.LoginResponse;
import com.example.metroapplication.apis.apiModel.LoginResponseData;
import com.example.metroapplication.constants.Constants;
import com.example.metroapplication.sharedPref.AppPreferences;
import com.example.metroapplication.sharedPref.VariablesConstant;
import com.example.metroapplication.utils.ConnectionDetector;
import com.example.metroapplication.utils.PermissionManagerUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.example.metroapplication.utils.PermissionManagerUtil.REQUEST_PERMISSION_PHONE_STATE;

public class LoginActivity extends AppCompatActivity {

    Button mloginBtn;
    TextView forgotPwd, signUpLink;
    EditText emailInput, passwordInput;
    CheckBox showHide;
    PermissionManagerUtil pm;
    ConnectionDetector cd;
    LoginModule loginModule;
    ApiInterface apiInterface;
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

        pm = new PermissionManagerUtil(this);

        Constants.ipAddress = pm.getLocalIpAddress();

        Constants.imei = pm.showPhoneStatePermission();

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

                if (isvalidation()) {
                    if (cd.isConnectingToInternet()) {
                        final ProgressDialog progressdialog = ProgressDialog.show(
                                LoginActivity.this, "Please wait",
                                "Loading please wait..", true);
                        progressdialog.show();
                        progressdialog.setCancelable(true);
                        loadData();
                        apiInterface = ApiClient.getClient().create(ApiInterface.class);

                        Call<LoginResponse> call = apiInterface.login(loginModule);

                        call.enqueue(new Callback<LoginResponse>() {
                            @Override
                            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                                LoginResponse loginResponse = response.body();
                                assert loginResponse != null;
                                if (loginResponse.getStatus() == 200) {
                                    List<LoginResponseData> loginResponseData = loginResponse.getPayload();
                                    if (loginResponseData.get(0).getStatus().equals("Mobile Verified")) {

                                        AppPreferences.setAppPrefrences(VariablesConstant.TOKEN, loginResponseData.get(0).getToken(), LoginActivity.this);
                                        AppPreferences.setAppPrefrences(VariablesConstant.MOBILE, loginResponseData.get(0).getMobile(), LoginActivity.this);
                                        AppPreferences.setAppPrefrences(VariablesConstant.USER_FIRSTNAME,loginResponseData.get(0).getFirstName(),LoginActivity.this);
                                        AppPreferences.setAppPrefrences(VariablesConstant.USER_LASTNAME,loginResponseData.get(0).getLastName(),LoginActivity.this);
                                        AppPreferences.setAppPrefrences(VariablesConstant.USER_EMAIL,loginResponseData.get(0).getEmailId(),LoginActivity.this);
                                        AppPreferences.setAppPrefrences(VariablesConstant.PASSWORD,loginResponseData.get(0).getPwd(),LoginActivity.this);
                                        progressdialog.dismiss();
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                 else if (loginResponse.getMessage().equals("Email_Id or Password wrong")){
                                    progressdialog.dismiss();
                                    Toast.makeText(LoginActivity.this, "Email ID or Password wrong", Toast.LENGTH_SHORT).show();
                                    }else
                                    {
                                        progressdialog.dismiss();
                                        Toast.makeText(LoginActivity.this, "Error : " +loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                }else
                                { progressdialog.dismiss();
                                    Toast.makeText(LoginActivity.this, "Error : " +loginResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            }

                            @Override
                            public void onFailure(Call<LoginResponse> call, Throwable t) {

                                progressdialog.dismiss();
                                Toast.makeText(LoginActivity.this, "Failed : " + t.getCause(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
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

    private void loadData() {
        String email = emailInput.getText().toString();
        String pass = passwordInput.getText().toString();
        String imei = Constants.imei;

        LoginPayload payload = new LoginPayload(email,pass,imei);
        loginModule = new LoginModule("1", "tok1234", payload);
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
            String[] permissions,
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
