package com.example.metroapplication.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.metroapplication.R;
import com.example.metroapplication.apis.ApiClient;
import com.example.metroapplication.apis.ApiInterface;
import com.example.metroapplication.apis.apiModel.UpdateMyProfileRequest;
import com.example.metroapplication.apis.apiModel.UpdateMyProfileRequestData;
import com.example.metroapplication.apis.apiModel.UpdateMyProfileResponse;
import com.example.metroapplication.constants.Constants;
import com.example.metroapplication.sharedPref.AppPreferences;
import com.example.metroapplication.sharedPref.VariablesConstant;
import com.example.metroapplication.utils.ConnectionDetector;
import com.example.metroapplication.utils.MenuActivity;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MyProfileActivity extends MenuActivity {

    Button chPassword, Backbtn, SaveBtn;
    EditText etFname, etLname, etEmai, etMobile, etAddress1, etAddress2, etCity, etState, etPincode;

    String firstName, lastName, email, password;
    String mobileNo, address, city, state, pincode;

    TextView tvUpdateStatus;

    ConnectionDetector cd;
    ApiInterface apiInterface;

    UpdateMyProfileRequest updateMyProfileRequest;


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
        setContentView(R.layout.activity_my_profile);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle("My Profile");
        } else {
            getSupportActionBar().setTitle("My Profile");
        }

        etFname = findViewById(R.id.fname_my_profile);
        etLname = findViewById(R.id.lname_my_profile);
        etMobile = findViewById(R.id.mobile_my_profile);
        etEmai = findViewById(R.id.email_my_profile);
        etAddress1 = findViewById(R.id.address1_my_profile);
        etAddress2 = findViewById(R.id.address2_my_profile);
        etCity = findViewById(R.id.city_my_profile);
        etState = findViewById(R.id.state_my_profile);
        etPincode = findViewById(R.id.pin_my_profile);
        tvUpdateStatus=findViewById(R.id.textViewStatus_My_prifile);


        Backbtn = findViewById(R.id.back_btn_my_profile);
        SaveBtn = findViewById(R.id.save_btn_my_profile);

        etMobile.setEnabled(false);

        etFname.setText(AppPreferences.getAppPrefrences(VariablesConstant.USER_FIRSTNAME, this));
        etLname.setText(AppPreferences.getAppPrefrences(VariablesConstant.USER_LASTNAME, this));
        etMobile.setText(AppPreferences.getAppPrefrences(VariablesConstant.MOBILE, this));
        etEmai.setText(AppPreferences.getAppPrefrences(VariablesConstant.USER_EMAIL, this));
        etAddress1.setText(AppPreferences.getAppPrefrences(VariablesConstant.ADDRESS_1, this));
        etAddress2.setText(AppPreferences.getAppPrefrences(VariablesConstant.ADDRESS_2, this));
        etCity.setText(AppPreferences.getAppPrefrences(VariablesConstant.CITY, this));
        etState.setText(AppPreferences.getAppPrefrences(VariablesConstant.STATE, this));
        etPincode.setText(AppPreferences.getAppPrefrences(VariablesConstant.PINCODE, this));


        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isvalidation()) {
                    final ProgressDialog progressdialog = ProgressDialog.show(
                            MyProfileActivity.this, "Please wait",
                            "Loading please wait..", true);
                    progressdialog.show();
                    progressdialog.setCancelable(true);
                    loadData();
                    cd=new ConnectionDetector(MyProfileActivity.this);

                    if (cd.isConnectingToInternet()){

                        apiInterface= ApiClient.getClient().create(ApiInterface.class);

                        Call<UpdateMyProfileResponse> call=apiInterface.updateMyProfile(updateMyProfileRequest);

                        call.enqueue(new Callback<UpdateMyProfileResponse>() {
                            @Override
                            public void onResponse(Call<UpdateMyProfileResponse> call, Response<UpdateMyProfileResponse> response) {
                                if (response.code()==200) {
                                    UpdateMyProfileResponse updateMyProfileResponse = response.body();
                                    if (updateMyProfileResponse.getStatus()==200){

                                        tvUpdateStatus.setText(updateMyProfileResponse.getMessage());
                                        progressdialog.dismiss();

                                    }else {
                                        tvUpdateStatus.setText("Server Error Try after sometime");
                                        progressdialog.dismiss();

                                    }
                                }else
                                {
                                    progressdialog.dismiss();
                                    Toast.makeText(MyProfileActivity.this, "Connection Issue after some time.", Toast.LENGTH_SHORT).show();

                                }

                            }

                            @Override
                            public void onFailure(Call<UpdateMyProfileResponse> call, Throwable t) {
                                progressdialog.dismiss();
                                Toast.makeText(MyProfileActivity.this, "Failed : "+t.getCause(), Toast.LENGTH_SHORT).show();

                            }
                        });
                    }

                }

            }
        });

//        chPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MyProfileActivity.this, ChangePassword.class);
//                startActivity(intent);
//
//            }
//        });

        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void loadData() {

        firstName = etFname.getText().toString();
        lastName = etLname.getText().toString();
        email = etEmai.getText().toString();
        mobileNo = etMobile.getText().toString();
        String address1 = etAddress1.getText().toString();
        String address2 = etAddress2.getText().toString();
        city = etCity.getText().toString();
        state = etState.getText().toString();
        pincode = etPincode.getText().toString();
        String imei= Constants.imei;
        String ipAdress=Constants.ipAddress;

        UpdateMyProfileRequestData updateMyProfileRequestData=new UpdateMyProfileRequestData(firstName,lastName,address1,address2,city,state,pincode,email,mobileNo,imei,ipAdress);

        String token=AppPreferences.getAppPrefrences(VariablesConstant.TOKEN,this);

        updateMyProfileRequest=new UpdateMyProfileRequest(1,token,updateMyProfileRequestData);

    }

    public boolean isvalidation() {

        Pattern ps = Pattern.compile("^[a-zA-Z ]+$");
        Matcher fname = ps.matcher(etFname.getText().toString());
        Matcher lname = ps.matcher(etLname.getText().toString());
        boolean isfnameValid = fname.matches();
        boolean isLnameValid = lname.matches();

        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (etFname.getText().toString().trim().length() == 0) {
            etFname.setError("Please Enter First Name");
            return false;
        } else if (!isfnameValid) {
            etFname.setError("Please Enter Valid First Name");
            return false;
        } else if (etLname.getText().toString().trim().length() == 0) {
            etLname.setError("Please Enter Last Name");
            return false;
        } else if (!isLnameValid) {
            etLname.setError("Please Enter Valid Last Name");
            return false;
        } else if (etMobile.length() == 0) {
            etMobile.setError("Please Enter Mobile Number");
            return false;
        } else if (etMobile.length() < 10) {
            etMobile.setError("Please Enter valid Mobile Number");
            return false;
        } else if (etEmai.getText().toString().trim().length() == 0) {
            etEmai.setError("Please Enter Email");
            return false;
        } else if (!etEmai.getText().toString().matches(emailPattern)) {
            etEmai.setError("Please Enter Valid Email");
            return false;
        }

        return true;
    }
}
