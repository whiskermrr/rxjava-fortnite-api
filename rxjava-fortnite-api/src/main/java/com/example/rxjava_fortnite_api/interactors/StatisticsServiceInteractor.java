package com.example.rxjava_fortnite_api.interactors;


import com.example.rxjava_fortnite_api.models.stats.StatsEntity;
import com.example.rxjava_fortnite_api.services.StatisticsService;

import java.util.List;

import io.reactivex.Single;

public class StatisticsServiceInteractor {

    private StatisticsService statisticsService;

    public StatisticsServiceInteractor(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public Single<List<StatsEntity>> getUserStats(String username, final String accessToken) {
        return statisticsService.getUserId("bearer " + accessToken, username)
                .flatMap(user ->
                    statisticsService.getUserStats("bearer " + accessToken, user.getId())
                );
    }

}
