package com.example.mrr.rx_fortnite_api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rxjava_fortnite_api.FortniteApi;
import com.example.rxjava_fortnite_api.Utils.FortniteApiConstants;
import com.example.rxjava_fortnite_api.models.blogs.Blog;
import com.example.rxjava_fortnite_api.models.blogs.BlogHolder;
import com.example.rxjava_fortnite_api.models.stats.BattleRoyaleStats;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    Button bSearch;
    Button bShowResult;
    EditText etUsername;
    TextView tText;

    FortniteApi fortniteApi;
    Retrofit retrofit;

    CompositeDisposable disposables;

    BattleRoyaleStats battleRoyaleStats;
    List<BlogHolder> blogHolderList;
    private int offset = 0;
    private int postsPerPage = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        bSearch = findViewById(R.id.bSearch);
        bShowResult = findViewById(R.id.bShowResult);
        tText = findViewById(R.id.tText);
        blogHolderList = new ArrayList<>();
        disposables = new CompositeDisposable();

        bSearch.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               refreshToken();
           }
       });

        bShowResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Blog> blogs = new ArrayList<>();
                StringBuilder stringBuilder = new StringBuilder();

                for(BlogHolder holder : blogHolderList) {
                    blogs.addAll(holder.getBlogList());
                }

                for(Blog blog : blogs) {
                    stringBuilder.append(blog.getTitle());
                    stringBuilder.append("\n");
                }

                String result = stringBuilder.toString();
                tText.setText(result);
            }
        });

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message ->
                Log.v("LOGGING INTERCEPTOR", message))
                .setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();


        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
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

    @Override
    protected void onStop() {
        super.onStop();
        disposables.clear();
    }

    private void refreshToken() {
        fortniteApi.requestRefreshToken();
    }

    private void getBlogs() {
        disposables.add(
                fortniteApi.getBlogs(FortniteApiConstants.PATCH_NOTES, postsPerPage, offset, "en-US")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(holder -> {
                                    blogHolderList.add(holder);
                                },
                                throwable -> {
                                    Log.v("BLOGS", throwable.getMessage());
                                })
        );
        offset += postsPerPage;
    }
}
