package com.example.nasaapp;

import com.example.nasaapp.network.Repository;
import com.example.nasaapp.viewmodel.NasaViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.Collection;


@RunWith(Parameterized.class)
public class ViewModelTest {
    private static final int NUM_REPEATS = 20;

    private NasaViewModel viewModel;
    @Mock
    Repository repository;

    @Before
    public void setup(){
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
