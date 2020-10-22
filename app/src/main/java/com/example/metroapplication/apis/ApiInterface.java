package com.example.metroapplication.apis;


import com.example.metroapplication.apis.apiModel.ChangePassModule;
import com.example.metroapplication.apis.apiModel.ChangePasswordResponse;
import com.example.metroapplication.apis.apiModel.FareRequestApi;
import com.example.metroapplication.apis.apiModel.FareResponse;
import com.example.metroapplication.apis.apiModel.ForgetPasswordResponse;
import com.example.metroapplication.apis.apiModel.IssueValueQRRequest;
import com.example.metroapplication.apis.apiModel.IssueValueQRResponse;
import com.example.metroapplication.apis.apiModel.LoginModule;
import com.example.metroapplication.apis.apiModel.LoginResponse;
import com.example.metroapplication.apis.apiModel.MasterData;
import com.example.metroapplication.apis.apiModel.MasterRequest;
import com.example.metroapplication.apis.apiModel.MobileVerification;
import com.example.metroapplication.apis.apiModel.MyTripRequest;
import com.example.metroapplication.apis.apiModel.MyTripResponse;
import com.example.metroapplication.apis.apiModel.OtpResponse;
import com.example.metroapplication.apis.apiModel.Registration;
import com.example.metroapplication.apis.apiModel.RegistrationResponse;
import com.example.metroapplication.apis.apiModel.SJTTicketGenerateRequest;
import com.example.metroapplication.apis.apiModel.SJTTicketGenerateResponse;
import com.example.metroapplication.apis.apiModel.SJTicketRequest;
import com.example.metroapplication.apis.apiModel.SjtQrResponse;
import com.example.metroapplication.apis.apiModel.UpdateMyProfileRequest;
import com.example.metroapplication.apis.apiModel.UpdateMyProfileResponse;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST(EndApi.REGISTER_USER)
    Call<RegistrationResponse> registerUser(@Body Registration registrationModule);

    @POST(EndApi.CHANGE_PASSWORD)
    Call<ChangePasswordResponse> changePassword(@Body ChangePassModule changePassModule);


    @POST(EndApi.LOGIN)
    Call<LoginResponse> login(@Body LoginModule loginModule);

    @POST(EndApi.VALUE_QR_TICKET)
    Call<IssueValueQRResponse> issueValueQR(@Body IssueValueQRRequest issueValueQRRequest);

    @POST(EndApi.FORGET_PASSWORD)
    Call<ForgetPasswordResponse> forgotPassword(@Query("email") String email);

    @POST(EndApi.VALIDATE_OTP)
    Call<OtpResponse> validateMobile(@Body MobileVerification mobileVerification);

    @POST(EndApi.GET_MASTER_DATA)
    Call<MasterData> getMasterData(@Body MasterRequest masterData);

    @POST(EndApi.SJT_TICKET)
    Call<SjtQrResponse> sjtBook(@Body SJTicketRequest SJTicketRequest);

    @POST(EndApi.GET_FARE)
    Call<FareResponse> getFare(@Body FareRequestApi fareRequestApi);

    @POST(EndApi.GET_TRIPS)
    Call<MyTripResponse> getMyTrips(@Body MyTripRequest myTripRequest);

    @POST(EndApi.UPDATE_MY_PROFILE)
    Call<UpdateMyProfileResponse> updateMyProfile(@Body UpdateMyProfileRequest updateMyProfileRequest);

    @POST(EndApi.GET_TICKET_ID)
    Call<SJTTicketGenerateResponse> generateTicketID(@Body SJTTicketGenerateRequest sjtTicketGenerateRequest);


}