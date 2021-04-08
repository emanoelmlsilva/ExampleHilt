package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import dagger.hilt.android.AndroidEntryPoint;

import android.os.Bundle;

import com.example.myapplication.database.IceCreamDAO;
import com.example.myapplication.database.IceCreamDAOEntity;
import com.example.myapplication.database.IceCreamDataStore;

import java.util.List;

import javax.inject.Inject;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}