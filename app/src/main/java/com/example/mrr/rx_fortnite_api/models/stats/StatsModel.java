package com.example.mrr.rx_fortnite_api.models.stats;

public class StatsModel {

    private String mode;
    private Integer score;
    private Integer matches;
    private Integer time;
    private Integer kills;
    private Integer wins;
    private Integer top3;
    private Integer top5;
    private Integer top6;
    private Integer top10;
    private Integer top12;
    private Integer top25;


    public StatsModel(String mode) {
        this.mode = mode;

        score = 0;
        matches = 0;
        time = 0;
        kills = 0;
        wins = 0;
        top3 = 0;
        top5 = 0;
        top6 = 0;
        top10 = 0;
        top12 = 0;
        top25 = 0;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getTop3() {
        return top3;
    }

    public void setTop3(Integer top3) {
        this.top3 = top3;
    }

    public Integer getTop5() {
        return top5;
    }

    public void setTop5(Integer top5) {
        this.top5 = top5;
    }

    public Integer getTop6() {
        return top6;
    }

    public void setTop6(Integer top6) {
        this.top6 = top6;
    }

    public Integer getTop10() {
        return top10;
    }

    public void setTop10(Integer top10) {
        this.top10 = top10;
    }

    public Integer getTop12() {
        return top12;
    }

    public void setTop12(Integer top12) {
        this.top12 = top12;
    }

    public Integer getTop25() {
        return top25;
    }

    public void setTop25(Integer top25) {
        this.top25 = top25;
    }
}
