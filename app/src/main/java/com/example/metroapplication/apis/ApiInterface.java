package com.example.metroapplication.apis;


import com.example.metroapplication.apis.apiModel.ChangePassModule;
import com.example.metroapplication.apis.apiModel.ChangePasswordResponse;
import com.example.metroapplication.apis.apiModel.FareRequestApi;
import com.example.metroapplication.apis.apiModel.ForgetPasswordResponse;
import com.example.metroapplication.apis.apiModel.IssueValueQRRequest;
import com.example.metroapplication.apis.apiModel.IssueValueQRResponse;
import com.example.metroapplication.apis.apiModel.LoginModule;
import com.example.metroapplication.apis.apiModel.LoginResponse;
import com.example.metroapplication.apis.apiModel.MasterData;
import com.example.metroapplication.apis.apiModel.MasterRequest;
import com.example.metroapplication.apis.apiModel.MobileVerification;
import com.example.metroapplication.apis.apiModel.OtpResponse;
import com.example.metroapplication.apis.apiModel.Registration;
import com.example.metroapplication.apis.apiModel.RegistrationResponse;
import com.example.metroapplication.apis.apiModel.SJTicketRequest;
import com.example.metroapplication.apis.apiModel.SjtQrResponse;
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
    Call<JSONObject> getFare(@Body FareRequestApi fareRequestApi);


//  @POST(EndApi.UPDATE_PROFILE)
//  Call<UpdateProfileResponse> updateUserProfile(
//          @Query("token") String token,
//          @Query("name") String name,
//          @Query("mobile") String mobile,
//          @Query("dob") String dob,
//           @Query("gender") String gender,
//         @Query("email") String profession,
//           @Query("profile_pic") String profile_pic
//           @Part("profile_pic") RequestBody file);

////    @Multipart
////    @POST(EndApi.UPDATE_PROFILE)
////    Call<UpdateProfileResponse> updateUserProfile2(
////            @Part("token") RequestBody token,
////            @Part("name") RequestBody name,
////            @Part("mobile") RequestBody mobile,
////            @Part("dob") RequestBody dob,
////            @Part("gender") RequestBody gender,
////            @Part("email") RequestBody profession,
////            @Part("profile_pic") RequestBody file
////    );
//
//
////    @POST(EndApi.UPDATE_PROFILE_PICTURE)
////    @FormUrlEncoded
////    Call<UpdateProfilePicture> updateProfilePicture(
////            @Query("token") String token,
////            @Field("profile_pic") String profilePic);
////
////
////    @Multipart
////    @POST("profile_pic")
////    Call<String> uploadImage(
////            @Part("token") RequestBody name,
////            @Part MultipartBody.Part file
////    );
////
////    @Multipart
////    @POST(EndApi.UPDATE_PROFILE_PICTURE)
////    Call<UpdateProfilePicture> uploadImage1(
////            @Part("token") RequestBody name,
////            @Part MultipartBody.Part file
////    );
////
//
//
////    @GET(EndApi.SEND_OTP)
////    Call<SendOTPResponse> sendOtp(@Query("token") String token);
////
////    @POST(EndApi.VALIDATE_OTP)
////    Call<SendOTPResponse> validateOtp(@Query("token") String token,
////                                      @Query("otp") String otp);
////
//
////    @POST(EndApi.VALIDATE_PASSWORD)
////    Call<SendOTPResponse> validatePassword(@Query("otp") String otp,
////                                           @Query("mobile") String mobile,
////                                           @Query("password") String password);
////    @POST(EndApi.VALIDATE_PASSWORD)
////    Call<SendOTPResponse> validatePassword(@Query("mobile") String mobile,
////                                           @Query("password") String password);
////    @POST(EndApi.VALIDATE_PASSWORD)
////    Call<SendOTPResponse> validatePassword1(@Query("password") String password);
////
////    @POST(EndApi.SOCIALLOGIN)
////    Call<SocialLoginResponse> GoogleLogin(
////            @Query("email") String email,
////            @Query("name") String name,
////            @Query("provider_id") String provider_id,
////            @Query("provider") String provider);
////
//
//
//

}