package com.example.nasaapp.di.module;


import com.example.nasaapp.network.Repository;
import com.example.nasaapp.viewmodel.NasaViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class NasaViewModelFactoryModule {

    @Provides
    public NasaViewModelFactory providesViewModelFactory(Repository repository){
        return new NasaViewModelFactory(repository);
    }
}
