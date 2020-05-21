package com.example.nasaapp.di.module;

import com.example.nasaapp.network.NasaNetworkFactory;
import com.example.nasaapp.network.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Provides
    public Repository providesRepository(NasaNetworkFactory nasaNetworkFactory){
        return new Repository(nasaNetworkFactory);
    }
}
