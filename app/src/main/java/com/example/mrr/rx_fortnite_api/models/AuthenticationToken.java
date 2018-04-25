package com.example.mrr.rx_fortnite_api.models;

public class AuthenticationToken {

    private String access_token;
    private String refresh_token;
    private String expires_at;
    private String refresh_expires_at;
    private String exchange_token;

    public AuthenticationToken(String access_token, String refresh_token, String expires_at, String refresh_expires_at) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.expires_at = expires_at;
        this.refresh_expires_at = refresh_expires_at;
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
