package com.example.nasaapp.di.module;

import android.content.Context;

import com.example.nasaapp.network.NasaNetworkFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class NasaNetworkFactoryModule {
    @Provides
    public NasaNetworkFactory providesNetwork(Context context){
        return new NasaNetworkFactory(context);
    }
}
