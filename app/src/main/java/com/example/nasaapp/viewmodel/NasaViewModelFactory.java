package com.example.nasaapp.viewmodel;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.nasaapp.network.Repository;
import javax.inject.Inject;

public class NasaViewModelFactory implements ViewModelProvider.Factory  {
    private Repository repository;

    @Inject
    public NasaViewModelFactory(Repository repository){
        this.repository=repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        NasaViewModel viewModel = new NasaViewModel(repository);
        return(T)viewModel;
    }
}
