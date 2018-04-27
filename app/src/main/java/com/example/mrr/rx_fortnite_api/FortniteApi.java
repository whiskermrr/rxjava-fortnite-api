package com.example.mrr.rx_fortnite_api;

import android.util.Log;

import com.example.mrr.rx_fortnite_api.interactors.AuthServiceInteractor;
import com.example.mrr.rx_fortnite_api.interactors.StatisticsServiceInteractor;
import com.example.mrr.rx_fortnite_api.mappers.StatsEntityDataMapper;
import com.example.mrr.rx_fortnite_api.models.AuthenticationToken;
import com.example.mrr.rx_fortnite_api.models.BattleRoyaleStats;
import com.example.mrr.rx_fortnite_api.services.AuthenticationService;
import com.example.mrr.rx_fortnite_api.services.StatisticsService;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class FortniteApi {

    private AuthServiceInteractor authServiceInteractor;
    private StatisticsServiceInteractor statisticsServiceInteractor;
    private AuthenticationToken authenticationToken;
    private CompositeDisposable disposables;

    public FortniteApi(Retrofit retrofit, String email, String password, String launcherToken, String fortniteToken) {
        disposables = new CompositeDisposable();
        authServiceInteractor = new AuthServiceInteractor(
                retrofit.create(AuthenticationService.class),
                email,
                password,
                launcherToken,
                fortniteToken
        );
        statisticsServiceInteractor = new StatisticsServiceInteractor(retrofit.create(StatisticsService.class));
    }

    public void authenticate() {
        authServiceInteractor.authenticate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<AuthenticationToken>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onSuccess(AuthenticationToken token) {
                        authenticationToken = token;
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.v("ON AUTH ERROR", e.getMessage());
                    }
                });
    }

    public Single<BattleRoyaleStats> getUserBattleRoyaleStats(String username) {
        if(authenticationToken == null) {
            return authServiceInteractor.authenticate()
                    .flatMap(token ->
                            statisticsServiceInteractor.getUserStats(username, token.getAccess_token())
                                    .flatMap(StatsEntityDataMapper::transform)
                    );
        }
        return  statisticsServiceInteractor.getUserStats(username, authenticationToken.getAccess_token())
                .flatMap(StatsEntityDataMapper::transform);
    }

    public Single<AuthenticationToken> requestRefreshToken() {
        return authServiceInteractor.requestRefreshToken(authenticationToken);
    }
}
