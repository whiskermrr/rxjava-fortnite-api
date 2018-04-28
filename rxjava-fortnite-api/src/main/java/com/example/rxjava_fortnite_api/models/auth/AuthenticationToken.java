package com.example.rxjava_fortnite_api.models.auth;

public class AuthenticationToken {

    private String access_token;
    private String refresh_token;
    private String expires_at;
    private String refresh_expires_at;
    private String exchange_token;

    public AuthenticationToken() {

    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(String expires_at) {
        this.expires_at = expires_at;
    }

    public String getRefresh_expires_at() {
        return refresh_expires_at;
    }

    public void setRefresh_expires_at(String refresh_expires_at) {
        this.refresh_expires_at = refresh_expires_at;
    }

    public String getExchange_token() {
        return exchange_token;
    }

    public void setExchange_token(String exchange_token) {
        this.exchange_token = exchange_token;
    }

    public String toString() {
        return "access_token: " + access_token + "\n" +
                "refresh_token: " + refresh_token;
    }
}
