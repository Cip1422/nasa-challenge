package com.example.nasaapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nasaapp.model.Item;
import com.example.nasaapp.network.Repository;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class NasaViewModel extends ViewModel {
    private Repository repository;
    MutableLiveData<List<Item>> imageData = new MutableLiveData<>();
    private CompositeDisposable nasaCompositeDisposable;
    private int iterator = 0;
    private int previous = -1;

    @Inject
    public NasaViewModel(Repository repository) {
        this.repository = repository;
        nasaCompositeDisposable = new CompositeDisposable();
    }

    public void initNetworkCall() {
        nasaCompositeDisposable.clear();
        setImageData();
    }

    private void setImageData() {
        nasaCompositeDisposable.add(repository.getImagesFromObservable(getPlanet()).subscribe(list -> {
            imageData.setValue(list);
        }));
    }

    public LiveData<List<Item>> getImageData() {
        return this.imageData;
    }

    private String getPlanet(){
        String[] planets = new String[]{"mercury", "venus","mars", "jupiter","saturn", "uranus", "neptune"};
        Random random = new Random();
        iterator = random.nextInt(7);
        //check to make sure we aren't getting the exact same search results twice
        if (previous != iterator) {
            previous = iterator;
        }
        else  {
            return "earth";
        }
        return planets[iterator];
    }
}
