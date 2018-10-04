package com.example.rxjava_fortnite_api.services;

import com.example.rxjava_fortnite_api.Utils.FortniteApiConstants;
import com.example.rxjava_fortnite_api.models.catalog.Catalog;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface CatalogService {

    @GET(FortniteApiConstants.CATALOG_URL)
    Single<Catalog> getCatalog(
            @Header("Authorization") String accessToken
    );
}
