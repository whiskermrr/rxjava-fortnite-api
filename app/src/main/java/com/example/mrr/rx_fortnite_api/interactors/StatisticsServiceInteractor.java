package com.example.mrr.rx_fortnite_api.interactors;


import com.example.mrr.rx_fortnite_api.models.Stats;
import com.example.mrr.rx_fortnite_api.services.StatisticsService;

import java.util.List;

import io.reactivex.Single;

public class StatisticsServiceInteractor {

    StatisticsService statisticsService;

    public StatisticsServiceInteractor(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public Single<List<Stats>> getUserStats(String username, final String accessToken) {
        return statisticsService.getUserId("bearer " + accessToken, username)
                .flatMap(user ->
                    statisticsService.getUserStats("bearer " + accessToken, user.getId())
                );
    }

}