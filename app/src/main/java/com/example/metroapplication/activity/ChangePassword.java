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

import com.example.metroapplication.R;
import com.example.metroapplication.apis.ApiClient;
import com.example.metroapplication.apis.ApiInterface;
import com.example.metroapplication.apis.apiModel.ChangePassData;
import com.example.metroapplication.apis.apiModel.ChangePassModule;
import com.example.metroapplication.constants.Constants;
import com.example.metroapplication.sharedPref.AppPreferences;
import com.example.metroapplication.sharedPref.VariablesConstant;
import com.example.metroapplication.utils.MenuActivity;
import com.google.gson.JsonElement;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ChangePassword extends MenuActivity {
// helllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll







    Button submit;
    EditText edtCurrectpasswrd, edtPassword, edtConfirmPassword;
    String currentPass, newPass, confirmPass;

    ChangePassData changePassData;
    ChangePassModule changePassModule;
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
        setContentView(R.layout.activity_change_password);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Change Password");
        } else {
            getSupportActionBar().setTitle("Change Password");
        }

        submit = findViewById(R.id.submit_chnPasswordBtn);
        edtCurrectpasswrd = findViewById(R.id.current_pass_chp);
        edtPassword = findViewById(R.id.new_pass_chp);
        edtConfirmPassword = findViewById(R.id.confirm_pass_chp);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isvalidation()) {
                    loadData();
                    changePassModule = new ChangePassModule();
                    changePassModule.setChannelId(1);
                    changePassModule.setTokenId("tok1234");
                    changePassModule.setPayload(changePassData);

                    apiInterface = ApiClient.getClient().create(ApiInterface.class);

                    Call<JsonElement> call = apiInterface.changePassword(changePassModule);
                    call.enqueue(new Callback<JsonElement>() {
                        @Override
                        public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {

                            if (response.code() == 200) {
                                Intent intent = new Intent(ChangePassword.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }

                        }

                        @Override
                        public void onFailure(Call<JsonElement> call, Throwable t) {
                        }
                    });

                }
            }
        });
    }

    private void loadData() {
        changePassData = new ChangePassData();
        currentPass = edtCurrectpasswrd.getText().toString();
        newPass = edtPassword.getText().toString();
        confirmPass = edtConfirmPassword.getText().toString();

        String userid = AppPreferences.getAppPrefrences(VariablesConstant.USER_ID, this);

        changePassData.setUserId(userid);
        changePassData.setOldPassword(currentPass);
        changePassData.setNewPassword(newPass);
        changePassData.setImei(Constants.imei);
        changePassData.setIpAddress(Constants.ipAddress);

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
        } else if (!edtPassword.getText().toString().equals(edtConfirmPassword.getText().toString())) {
            edtConfirmPassword.setError("Confirm Password doesn't Match");
//            edtConfirmPassword.setText("");
            return false;
        } else if (edtCurrectpasswrd.length() == 0) {
            edtCurrectpasswrd.setError("Please Enter Current Password");


            return false;
        }

        return true;
    }


}
