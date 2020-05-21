package com.example.nasaapp.util;

import android.app.Application;

import com.example.nasaapp.di.component.DaggerNasaComponent;
import com.example.nasaapp.di.component.NasaComponent;
import com.example.nasaapp.di.module.ApplicationModule;
import com.example.nasaapp.di.module.NasaNetworkFactoryModule;
import com.example.nasaapp.di.module.NasaViewModelFactoryModule;
import com.example.nasaapp.di.module.RepositoryModule;

public class ApplicationComponent extends Application {
    private static NasaComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerNasaComponent.builder()
                .nasaViewModelFactoryModule(new NasaViewModelFactoryModule())
                .nasaNetworkFactoryModule(new NasaNetworkFactoryModule())
                .repositoryModule(new RepositoryModule())
                .applicationModule(new ApplicationModule(this))
                .build();
    }
    public static NasaComponent getComponent() {
        return component;
    }
}
