package com.example.nasaapp.di.component;

import com.example.nasaapp.di.module.ApplicationModule;
import com.example.nasaapp.di.module.NasaNetworkFactoryModule;
import com.example.nasaapp.di.module.NasaViewModelFactoryModule;
import com.example.nasaapp.di.module.RepositoryModule;
import com.example.nasaapp.view.MainActivity;

import dagger.Component;

@Component(modules = {NasaNetworkFactoryModule.class, NasaViewModelFactoryModule.class,
        RepositoryModule.class, ApplicationModule.class})
public interface NasaComponent {
    void inject(MainActivity activity);
}
