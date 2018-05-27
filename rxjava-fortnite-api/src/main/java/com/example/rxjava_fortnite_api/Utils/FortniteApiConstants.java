package com.example.rxjava_fortnite_api.Utils;

public class FortniteApiConstants {

    // OAuth urls
    public static final String AUTH_TOKEN_URL = "https://account-public-service-prod03.ol.epicgames.com/account/api/oauth/token";
    public static final String AUTH_EXCHANGE_URL = "https://account-public-service-prod03.ol.epicgames.com/account/api/oauth/exchange";

    // User urls
    public static final String ACCOUNT_URL = "https://persona-public-service-prod06.ol.epicgames.com/persona/api/public/account/lookup";

    // StatsEntity urls
    public static final String BR_STATS_URL = "https://fortnite-public-service-prod11.ol.epicgames.com/fortnite/api/stats/accountId/{accountId}/bulk/window/alltime";

    // catalog urls
    public static final String CATALOG_URL = "https://fortnite-public-service-prod11.ol.epicgames.com/fortnite/api/storefront/v2/catalog";

    // blog urls
    public static final String BLOG_URL = "https://www.epicgames.com/fortnite/api/blog/getPosts";

    public static final String PATCH_NOTE_BASE_URL = "https://www.epicgames.com/fortnite/en-US";

    // blog category
    public static final String PATCH_NOTES = "patch notes";
    public static final String ANNOUNCEMENTS = "announcements";
    public static final String EVENTS = "events";
    public static final String COMMUNITY = "community";
}
