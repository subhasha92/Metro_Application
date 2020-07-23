package com.example.metroapplication.apis;


import com.example.metroapplication.apis.apiModel.ChangePasswordResponse;
import com.example.metroapplication.apis.apiModel.ForgetPasswordResponse;
import com.example.metroapplication.apis.apiModel.LoginResponse;
import com.example.metroapplication.apis.apiModel.Registration;
import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @POST(EndApi.REGISTER_USER)

   Call<JsonElement> registerUser(@Body Registration registrationModule);

   @POST(EndApi.LOGIN_USER)
   Call<LoginResponse> login(@Query("email") String email,

                           @Query("password") String password);

    @POST(EndApi.LOGIN_USER)
   Call<LoginResponse> login2(@Query("email") String email,
                             @Query("password") String password,
                            @Query("mobile") String mobile);

  @POST(EndApi.FORGET_PASSWORD)

  Call<ForgetPasswordResponse> forgotPassword(@Query("email") String email);

//   @GET(EndApi.PROFILE_INFO)
//   Call<FromResponse> FromStationList(@Query("token") String token);


//  @POST(EndApi.LOGIN_USER)
//  Call<LogoutResponse> logout(@Query("user_id ") String user_id);

       @POST(EndApi.CHANGE_PASSWORD)
  Call<ChangePasswordResponse> changePassword(@Query("token") String token,
                                            @Query("old_password") String old_password,
                                           @Query("new_password") String new_password);


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