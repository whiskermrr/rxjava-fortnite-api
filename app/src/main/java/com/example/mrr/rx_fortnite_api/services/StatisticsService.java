package com.example.mrr.rx_fortnite_api.services;

import com.example.mrr.rx_fortnite_api.Utils.FortniteApiConstants;
import com.example.mrr.rx_fortnite_api.models.auth.Account;
import com.example.mrr.rx_fortnite_api.models.stats.StatsEntity;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StatisticsService {

    @GET(FortniteApiConstants.ACCOUNT_URL)
    Single<Account> getUserId(
            @Header("Authorization") String accessToken,
            @Query("q") String username
    );

    @GET(FortniteApiConstants.BR_STATS_URL)
    Single<List<StatsEntity>> getUserStats(
            @Header("Authorization") String accessToken,
            @Path("accountId") String accountId
    );
}
