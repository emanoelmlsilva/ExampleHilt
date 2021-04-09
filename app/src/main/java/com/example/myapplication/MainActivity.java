package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;

import android.os.Bundle;

import com.example.myapplication.adapter.IceCreamAdapter;

import javax.inject.Inject;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Inject
    IceCreamAdapter iceCreamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerIceCream);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        recyclerView.setAdapter(iceCreamAdapter);
    }
}