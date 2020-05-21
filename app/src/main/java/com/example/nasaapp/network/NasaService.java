package com.example.nasaapp.network;

import com.example.nasaapp.model.NasaImage;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaService {
    @GET("/search")
    Flowable<NasaImage> getImages(@Query("q")String planet);
}
