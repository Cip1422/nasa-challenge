package com.example.nasaapp;

import androidx.lifecycle.MutableLiveData;

import com.example.nasaapp.view.adapter.NasaAdapter;
import com.example.nasaapp.viewmodel.NasaViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


public class ViewModelTest {


    private String PLANET_NAME = "MARS";
    private int ADAPTER_LIST_SIZE = 10;

    @Mock
    public NasaViewModel viewModel;

    @Mock
    public NasaAdapter nasaAdapter;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        Mockito.when(nasaAdapter.getItemCount()).thenReturn(ADAPTER_LIST_SIZE);
        Mockito.when(viewModel.getImageData()).thenReturn(new MutableLiveData<>());
        Mockito.when(viewModel.getPlanet()).thenReturn(PLANET_NAME);
    }

    @Test
    public void test_Incorrect_GetPlanetName_ViewModel(){
        assertNotEquals(viewModel.getPlanet(), "jupiter");
    }

    @Test
    public void test_GetPlanetName_ViewModel(){
        assertEquals(viewModel.getPlanet(), PLANET_NAME);
    }

    @Test
    public void test_getMutableLiveData_ViewModel(){
        assertNotNull(viewModel.getImageData());
    }

    @Test
    public void verifyAdapterListSize_Correct_Size(){
        assertEquals(nasaAdapter.getItemCount(), ADAPTER_LIST_SIZE);
    }

    @Test
    public void verifyAdapterListSize_Incorrect_Size(){
        assertNotEquals(nasaAdapter.getItemCount(), 0);
    }


}