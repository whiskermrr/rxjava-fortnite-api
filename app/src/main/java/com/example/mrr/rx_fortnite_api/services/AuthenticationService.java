package com.example.mrr.rx_fortnite_api.services;

import com.example.mrr.rx_fortnite_api.Utils.FortniteApiConstants;
import com.example.mrr.rx_fortnite_api.models.auth.AuthenticationToken;

import java.util.Map;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AuthenticationService {

    @FormUrlEncoded
    @Headers({
            "Accept: */*",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @POST(FortniteApiConstants.AUTH_TOKEN_URL)
    Single<AuthenticationToken> requestAuthenticationToken(
            @Header("Authorization") String launcherToken,
            @FieldMap Map<String, String> params
            );


    @Headers({
            "Accept: */*",
            "Content-Type: application/json"
    })
    @GET(FortniteApiConstants.AUTH_EXCHANGE_URL)
    Single<ResponseBody> requestExchangeToken(
            @Header("Authorization") String launcherToken
    );


    @FormUrlEncoded
    @Headers({
            "Accept: */*",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @POST(FortniteApiConstants.AUTH_TOKEN_URL)
    Single<AuthenticationToken> requestAccessToken(
            @Header("Authorization") String fortniteToken,
            @FieldMap Map<String, String> params
    );


    @FormUrlEncoded
    @Headers({
            "Accept: */*",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @POST(FortniteApiConstants.AUTH_TOKEN_URL)
    Single<AuthenticationToken> requestRefreshToken(
            @Header("Authorization") String refreshToken,
            @FieldMap Map<String, String> params
    );
}
