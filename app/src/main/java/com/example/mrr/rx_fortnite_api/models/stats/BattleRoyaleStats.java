package com.example.mrr.rx_fortnite_api.models.stats;

public class BattleRoyaleStats {

    private StatsModel solo;
    private StatsModel duo;
    private StatsModel squad;
    private StatsModel lifeTime;

    public BattleRoyaleStats() {
        solo = new StatsModel("_p2");
        duo = new StatsModel("_p10");
        squad = new StatsModel("_p9");
        lifeTime = new StatsModel("_p");
    }

    public StatsModel getSolo() {
        return solo;
    }

    public void setSolo(StatsModel solo) {
        this.solo = solo;
    }

    public StatsModel getDuo() {
        return duo;
    }

    public void setDuo(StatsModel duo) {
        this.duo = duo;
    }

    public StatsModel getSquad() {
        return squad;
    }

    public void setSquad(StatsModel squad) {
        this.squad = squad;
    }

    public StatsModel getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(StatsModel lifeTime) {
        this.lifeTime = lifeTime;
    }
}
