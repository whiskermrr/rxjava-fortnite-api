package com.example.mrr.rx_fortnite_api.interactors;

import com.example.mrr.rx_fortnite_api.models.AuthenticationToken;
import com.example.mrr.rx_fortnite_api.services.AuthenticationService;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Single;
import okhttp3.ResponseBody;

public class AuthServiceInteractor {

    private AuthenticationService authenticationService;
    private String launcherToken;
    private String fortniteToken;
    private String email;
    private String password;

    public AuthServiceInteractor(AuthenticationService apiService, String email, String password, String launcherToken, String fortniteToken) {
        this.authenticationService = apiService;
        this.email = email;
        this.password = password;
        this.launcherToken = "basic " + launcherToken;
        this.fortniteToken = "basic " + fortniteToken;
    }

    public Single<AuthenticationToken> authenticate() {
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "password");
        params.put("username", email);
        params.put("password", password);
        params.put("includePerms", "true");

        return authenticationService.requestAuthenticationToken(launcherToken, params)
                .flatMap(token ->
                        requestExchangeToken(token)
                            .flatMap(responseBody -> {
                                JSONObject jsonResponse = new JSONObject(responseBody.string());
                                token.setExchange_token(jsonResponse.getString("code"));
                                return requestAccessToken(token);
                            })
                );
    }

    private Single<ResponseBody> requestExchangeToken(AuthenticationToken authenticationToken) {
        return authenticationService.requestExchangeToken("bearer " + authenticationToken.getAccess_token());
    }

    private Single<AuthenticationToken> requestAccessToken(AuthenticationToken authenticationToken) {
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "exchange_code");
        params.put("exchange_code", authenticationToken.getExchange_token());
        params.put("token_type", "eg1");
        params.put("includePerms", "true");

        return authenticationService.requestAccessToken(fortniteToken, params);
    }

    public Single<AuthenticationToken> requestRefreshToken(AuthenticationToken authenticationToken) {
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "refresh_token");
        params.put("refresh_token", authenticationToken.getRefresh_token());
        params.put("includePerms", "true");

        return authenticationService.requestRefreshToken(fortniteToken, params);
    }
}
