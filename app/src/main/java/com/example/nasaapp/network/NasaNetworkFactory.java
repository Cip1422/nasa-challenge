package com.example.nasaapp.network;

import android.content.Context;

import com.example.nasaapp.R;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NasaNetworkFactory {
    private Context context;

    @Inject
    public NasaNetworkFactory(Context context){
        this.context = context;
    }

    public NasaService getApi() {
        return new Retrofit.Builder()
                .baseUrl(context.getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(NasaService.class);
    }
}
