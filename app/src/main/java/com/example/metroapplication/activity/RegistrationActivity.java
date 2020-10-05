package com.example.metroapplication.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.example.metroapplication.R;
import com.example.metroapplication.apis.ApiClient;
import com.example.metroapplication.apis.ApiInterface;
import com.example.metroapplication.apis.apiModel.Registration;
import com.example.metroapplication.apis.apiModel.RegistrationData;
import com.example.metroapplication.apis.apiModel.RegistrationResponse;
import com.example.metroapplication.apis.apiModel.RegistrationResponseData;
import com.example.metroapplication.constants.Constants;
import com.example.metroapplication.utils.ConnectionDetector;
import com.example.metroapplication.utils.PermissionManagerUtil;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static android.Manifest.permission.READ_PHONE_STATE;
import static com.example.metroapplication.utils.PermissionManagerUtil.REQUEST_PERMISSION_PHONE_STATE;

public class RegistrationActivity extends Activity {
    final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    EditText edtfirstName, edtlastName, edtmob, edtEmail, edtPassword, edtConfirmPassword, edtAddress, edtCity, edtState, edtPincode;
    Button btnRegistration;
    TextView txtAlreadyUser, cmpleteProfile, errorText;
    ConnectionDetector cd;
    PermissionManagerUtil p;
    String firstName, lastName, email, password;
    String mobileNo, address, city, state, pincode;
    RegistrationData registrationData;
    ApiInterface apiInterface;

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
        p = new PermissionManagerUtil(this);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        btnRegistration = findViewById(R.id.registrationBtn);
        edtfirstName = findViewById(R.id.first_name);
        edtlastName = findViewById(R.id.last_name);
        edtmob = findViewById(R.id.mobile);
        edtConfirmPassword = findViewById(R.id.register_confirm_password);
        edtEmail = findViewById(R.id.register_email);
        edtPassword = findViewById(R.id.register_password);
        edtAddress = findViewById(R.id.register_address);
        edtCity = findViewById(R.id.register_city);
        edtState = findViewById(R.id.register_state);
        edtPincode = findViewById(R.id.register_pincode);
        txtAlreadyUser = findViewById(R.id.new_user_signup);
        cmpleteProfile = findViewById(R.id.complete_profile);
        errorText = findViewById(R.id.register_errors);
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
                final ProgressDialog progressdialog = ProgressDialog.show(
                        RegistrationActivity.this, "Please wait",
                        "Loading please wait..", true);
                progressdialog.show();
                progressdialog.setCancelable(true);
                if (isvalidation()) {
                    p.showPhoneStatePermission();
                    loadData();
                    Registration registration;
                    registration = new Registration();
                    registration.setChannelId(1);
                    registration.setTokenId("tok1234");
                    registration.setPayload(registrationData);

                    Call<RegistrationResponse> call = apiInterface.registerUser(registration);
                    call.enqueue(new Callback<RegistrationResponse>() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                            if (response.code() == 200) {
                                progressdialog.dismiss();
                                errorText.setVisibility(View.GONE);
                                RegistrationResponse rg = response.body();
                                assert rg != null;
                                List<RegistrationResponseData> rgData = rg.getPayload();
                                System.out.print(rgData.get(0).getMobileOtp());
                                Intent i = new Intent(RegistrationActivity.this, OtpActivity.class);
                                i.putExtra("otp", rgData.get(0).getMobileOtp());
                                i.putExtra("tokenId", rgData.get(0).getTokenId());
                                startActivity(i);
                            } else if (response.message().equals("Email_Id already Exist")) {
                                progressdialog.dismiss();
                                edtEmail.setError("Email ID already Exist");
                                edtEmail.setFocusable(true);
                                errorText.setVisibility(View.VISIBLE);
                                errorText.setText("Email ID already Exist");
                            }

                        }

                        @Override
                        public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                            progressdialog.dismiss();
                            Toast.makeText(RegistrationActivity.this, "Error " + t.getCause(), Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
    }

    @SuppressLint("HardwareIds")
    private void loadData() {
        registrationData = new RegistrationData();
        firstName = edtfirstName.getText().toString();
        lastName = edtlastName.getText().toString();
        email = edtEmail.getText().toString();
        mobileNo = edtmob.getText().toString();
        password = edtPassword.getText().toString();
        address = edtAddress.getText().toString();
        city = edtCity.getText().toString();
        state = edtState.getText().toString();
        pincode = edtPincode.getText().toString();

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(this, READ_PHONE_STATE)) {
            Constants.imei = telephonyManager.getDeviceId();
        }

        Constants.ipAddress = p.getLocalIpAddress();
        registrationData.setFirstName(firstName);
        registrationData.setLastName(lastName);
        registrationData.setEmail(email);
        registrationData.setMobile(mobileNo);
        registrationData.setPassword(password);
        registrationData.setImei(Constants.imei);
        registrationData.setIpAddress(Constants.ipAddress);
        registrationData.setAddress(address);
        registrationData.setCity(city);
        registrationData.setState(state);
        registrationData.setPinCode(pincode);

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
        } else if (!edtPassword.getText().toString().equals(edtConfirmPassword.getText().toString())) {
            edtConfirmPassword.setError("Confirm Password doesn't Match");
//            edtConfirmPassword.setText("");
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
                    Toast.makeText(RegistrationActivity.this, "Permission Denied!", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + requestCode);
        }
    }


}
