package com.example.nasaapp.network;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;

import com.example.nasaapp.model.Item;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

public class Repository {
    private NasaService service;

    @Inject
    public Repository(NasaNetworkFactory nasaNetworkFactory){
        service = nasaNetworkFactory.getApi();
    }

    public Flowable<List<Item>> getImagesFromObservable(String planet) {
                return service.getImages(planet)
                        .doOnError(throwable -> Log.d(TAG, throwable.getMessage()))
                        .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(nasaImage -> nasaImage.getCollection().getItems());
    }
}
