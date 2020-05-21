package com.example.nasaapp.di.module;

import android.content.Context;

import com.example.nasaapp.util.ApplicationComponent;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private ApplicationComponent context;

    public ApplicationModule(ApplicationComponent context){
        this.context = context;
    }
    @Provides
    public Context providesApplicationContext(){
        return context.getApplicationContext();
    }
}
