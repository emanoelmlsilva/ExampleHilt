package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;

import android.os.Bundle;

import com.example.myapplication.adapter.IceCreamAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import javax.inject.Inject;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    FloatingActionButton btnAdd;

    @Inject
    CreateIceCreamFragment createIceCreamFragment;

    @Inject
    IceCreamAdapter iceCreamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(view -> {
            opeFragment();
        });

        recyclerView = findViewById(R.id.recyclerIceCream);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        recyclerView.setAdapter(iceCreamAdapter);

    }

    private void opeFragment(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.content_main, createIceCreamFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}