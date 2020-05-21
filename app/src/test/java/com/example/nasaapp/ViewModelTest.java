package com.example.nasaapp;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.example.nasaapp.model.Item;
import com.example.nasaapp.network.NasaNetworkFactory;
import com.example.nasaapp.network.Repository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

public class ViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    Repository repository;
    @Mock
    NasaNetworkFactory nasaNetworkFactory;
    @Mock
    List<Item> nasaItems;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        repository = new Repository(nasaNetworkFactory);
    }

    @Test
    public void verifyListOfSchoolsExists(){
        repository.getImagesFromObservable("earth");
        Mockito.doReturn(nasaItems);
    }

}
