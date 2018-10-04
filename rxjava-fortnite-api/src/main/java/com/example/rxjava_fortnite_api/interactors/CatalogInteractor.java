package com.example.rxjava_fortnite_api.interactors;

import com.example.rxjava_fortnite_api.models.catalog.Catalog;
import com.example.rxjava_fortnite_api.services.CatalogService;

import io.reactivex.Single;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class CatalogInteractor {

    private CatalogService catalogService;

    public CatalogInteractor(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    public Single<Catalog> getCatalog(final String accessToken) {
        return catalogService.getCatalog("bearer " + accessToken);
    }
}
