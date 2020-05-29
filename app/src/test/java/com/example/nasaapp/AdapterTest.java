package com.example.nasaapp;

import com.example.nasaapp.view.adapter.NasaAdapter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AdapterTest {
    private int ADAPTER_LIST_SIZE = 10;

    @Mock
    public NasaAdapter nasaAdapter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(nasaAdapter.getItemCount()).thenReturn(ADAPTER_LIST_SIZE);
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
