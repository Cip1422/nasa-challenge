package com.example.nasaapp;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.nasaapp.model.Item;
import com.example.nasaapp.network.NasaNetworkFactory;
import com.example.nasaapp.network.Repository;
import com.example.nasaapp.viewmodel.NasaViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.reactivex.Flowable;

@RunWith(Parameterized.class)
public class ViewModelTest {
    private static final int NUM_REPEATS = 20;

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    private NasaViewModel viewModel;
    @Mock
    Repository repository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        viewModel = new NasaViewModel(repository);
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        Collection<Object[]> out = new ArrayList<>();
        for (int i = 0; i < NUM_REPEATS; i++) {
            out.add(new Object[0]);
        }
        return out;
    }

    @Test
    public void VerifyNoTwoPlanets(){
       String testPlanet1 = viewModel.getPlanet();
       String testPlanet2 = viewModel.getPlanet();
       System.out.println(testPlanet1 + " " + testPlanet2);
       assert !testPlanet1.equals(testPlanet2);
    }
}
