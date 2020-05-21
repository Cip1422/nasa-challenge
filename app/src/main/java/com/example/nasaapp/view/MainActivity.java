package com.example.nasaapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.nasaapp.R;
import com.example.nasaapp.model.Item;
import com.example.nasaapp.model.NasaImage;
import com.example.nasaapp.util.ApplicationComponent;
import com.example.nasaapp.view.adapter.NasaAdapter;
import com.example.nasaapp.viewmodel.NasaViewModel;
import com.example.nasaapp.viewmodel.NasaViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private NasaAdapter nasaAdapter;

    @Inject
    public NasaViewModelFactory factory;
    private NasaViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((ApplicationComponent)getApplicationContext()).getComponent().inject(this);

        viewModel = factory.create(NasaViewModel.class);
        initViews();
        viewModel.initNetworkCall();
        viewModel.getImageData().observe(this,
                nasaImages -> updateAdapter(nasaImages));
    }
    public  void updateAdapter(List<Item> nasaImages){
        swipeRefreshLayout.setRefreshing(false);
        nasaAdapter.setDataSet(nasaImages);
    }
    private void initViews(){
        swipeRefreshLayout = findViewById(R.id.home_swiperefresh_layout);
        recyclerView = findViewById(R.id.home_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        nasaAdapter = new NasaAdapter(new ArrayList<>());
        recyclerView.setAdapter(nasaAdapter);
        swipeRefreshLayout.setOnRefreshListener(() -> viewModel.initNetworkCall());
    }
}
