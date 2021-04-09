package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import dagger.hilt.android.AndroidEntryPoint;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.adapter.IceCreamAdapter;
import com.example.myapplication.database.IceCreamDAOEntity;
import com.example.myapplication.database.IceCreamDataStore;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import javax.inject.Inject;

@AndroidEntryPoint
public class CreateIceCreamFragment extends Fragment {

    Button btnClose, btnSalve;
    FloatingActionButton btnUpdate;

    TextView txtFlavorInsert, txtVolumeInsert, txtPriceInsert;
    IceCreamDAOEntity createIceCream = null;

    @Inject
    IceCreamAdapter iceCreamAdapter;

    @Inject
    IceCreamDataStore iceCreamDataStore;

    @Inject
    public CreateIceCreamFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_creat_ice_cream, container, false);

        btnClose = root.findViewById(R.id.btnClose);
        btnUpdate = root.findViewById(R.id.btnUpdate);
        btnSalve = root.findViewById(R.id.btnSalve);

        txtFlavorInsert = root.findViewById(R.id.txtFlavorInsert);
        txtVolumeInsert = root.findViewById(R.id.txtVolumeInsert);
        txtPriceInsert = root.findViewById(R.id.txtPriceInsert);

        btnClose.setOnClickListener(view -> {
            getFragmentManager().popBackStack();
        });

        btnUpdate.setOnClickListener(view -> {
            createIceCream();
        });
        
        btnSalve.setOnClickListener(view -> {
            if(createIceCream != null){
                iceCreamDataStore.insertIceCream(createIceCream);
                iceCreamAdapter.updateList();
                getFragmentManager().popBackStack();
            }
        });
        return root;
    }

    public void createIceCream(){
        createIceCream = iceCreamDataStore.createIceCream();
        txtFlavorInsert.setText(createIceCream.getFlavorOne() +" com "+ createIceCream.getFlavorTow() + " e cobertura de " + createIceCream.getSyrup());
        txtPriceInsert.setText("R$ " + createIceCream.getPrice());
        txtVolumeInsert.setText(createIceCream.getML()+"ML");
    }
    
}