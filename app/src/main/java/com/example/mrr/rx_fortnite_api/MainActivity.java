package com.example.mrr.rx_fortnite_api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrr.rx_fortnite_api.models.Stats;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button bSearch;
    EditText etUsername;
    TextView tText;

    FortniteApi fortniteApi;
    Retrofit retrofit;

    List<Stats> userStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        bSearch = findViewById(R.id.bSearch);
        tText = findViewById(R.id.tText);

        bSearch.setOnClickListener(view ->
                fortniteApi.getUserBattleRoyalStats(etUsername.getText().toString())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(stats -> {
                                    userStats = stats;
                                },
                                throwable -> {
                                    if(throwable instanceof HttpException) {
                                        if(((HttpException) throwable).response().code() == 404) {
                                            Toast.makeText(MainActivity.this, "User Not Found.", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    else {
                                        Log.v("ON SEARCH ERROR", throwable.getMessage());
                                    }
                                })
        );


        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://account-public-service-prod03.ol.epicgames.com/")
                .build();

        fortniteApi = new FortniteApi(
                retrofit,
                getResources().getString(R.string.epic_games_email),
                getResources().getString(R.string.epic_games_password),
                getResources().getString(R.string.launcher_token),
                getResources().getString(R.string.fortnite_token)
        );

        fortniteApi.authenticate();
    }
}
