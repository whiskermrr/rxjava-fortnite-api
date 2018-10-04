package com.example.rxjava_fortnite_api.mappers;

import com.example.rxjava_fortnite_api.models.stats.BattleRoyaleStats;
import com.example.rxjava_fortnite_api.models.stats.StatsEntity;
import com.example.rxjava_fortnite_api.models.stats.StatsModel;

import java.util.List;

import io.reactivex.Single;

public class StatsEntityDataMapper {

    public static Single<BattleRoyaleStats> transform(List<StatsEntity> statsList) {
        BattleRoyaleStats battleRoyaleStats = new BattleRoyaleStats();

        battleRoyaleStats.setSolo(transform(battleRoyaleStats.getSolo(), statsList));
        battleRoyaleStats.setDuo(transform(battleRoyaleStats.getDuo(), statsList));
        battleRoyaleStats.setSquad(transform(battleRoyaleStats.getSquad(), statsList));
        battleRoyaleStats.setLifeTime(transform(battleRoyaleStats.getLifeTime(), statsList));

        return Single.just(battleRoyaleStats);
    }

    private static StatsModel transform(StatsModel statsModel, List<StatsEntity> statsList) {

        for(StatsEntity stats : statsList) {

            if(stats.getName().contains(statsModel.getMode())) {
                if(stats.getName().contains("score_"))
                    statsModel.setScore(statsModel.getScore() + stats.getValue());
                else if(stats.getName().contains("matchesplayed_"))
                    statsModel.setMatches(statsModel.getMatches() + stats.getValue());
                else if(stats.getName().contains("minutesplayed_"))
                    statsModel.setTime(statsModel.getTime() + stats.getValue());
                else if(stats.getName().contains("kills_"))
                    statsModel.setKills(statsModel.getKills() + stats.getValue());
                else if(stats.getName().contains("placetop1_"))
                    statsModel.setWins(statsModel.getWins() + stats.getValue());
                else if(stats.getName().contains("placetop3_"))
                    statsModel.setTop3(statsModel.getTop3() + stats.getValue());
                else if(stats.getName().contains("placetop5_"))
                    statsModel.setTop5(statsModel.getTop5() + stats.getValue());
                else if(stats.getName().contains("placetop6_"))
                    statsModel.setTop6(statsModel.getTop6() + stats.getValue());
                else if(stats.getName().contains("placetop10_"))
                    statsModel.setTop10(statsModel.getTop10() + stats.getValue());
                else if(stats.getName().contains("placetop12_"))
                    statsModel.setTop12(statsModel.getTop12() + stats.getValue());
                else if(stats.getName().contains("placetop25_"))
                    statsModel.setTop25(statsModel.getTop25() + stats.getValue());
            }
        }
        statsModel.setWinPercentage( (float) statsModel.getWins() / statsModel.getMatches() * 100);
        statsModel.setKDRatio( (float) statsModel.getKills() / (statsModel.getMatches() - statsModel.getWins()));
        statsModel.setKillsPerMatch( (float) statsModel.getKills() / statsModel.getMatches());
        statsModel.setScorePerMatch( (float) statsModel.getScore() / statsModel.getMatches());

        return statsModel;
    }
}
