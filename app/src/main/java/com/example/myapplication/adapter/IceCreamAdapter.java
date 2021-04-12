package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.database.IceCreamDAOEntity;
import com.example.myapplication.database.IceCreamDataStore;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.scopes.ActivityScoped;

@ActivityScoped
public class IceCreamAdapter extends RecyclerView.Adapter<IceCreamAdapter.MyViewHolder> {

    List<IceCreamDAOEntity> iceCreamDAOEntityList;
    IceCreamDataStore iceCreamDataStore;

    @Inject
    public IceCreamAdapter(IceCreamDataStore iceCreamDataStore) {
        this.iceCreamDataStore = iceCreamDataStore;
        iceCreamDAOEntityList = iceCreamDataStore.getListIceCream();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ice_cream_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        IceCreamDAOEntity iceCreamDAOEntity = iceCreamDAOEntityList.get(position);
        holder.txtFlavor.setText(iceCreamDAOEntity.getFlavorOne() +" com "+ iceCreamDAOEntity.getFlavorTow() + " e cobertura de " + iceCreamDAOEntity.getSyrup());
        holder.txtPrice.setText("R$ "+ iceCreamDAOEntity.getPrice());
        holder.txtVolume.setText(iceCreamDAOEntity.getML());

        holder.btnDelete.setOnClickListener(view -> {
            iceCreamDataStore.deleteIceCream(iceCreamDAOEntity);
            updateList();
        });
    }

    public void updateList(){
        this.iceCreamDAOEntityList = this.iceCreamDataStore.getListIceCream();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return iceCreamDAOEntityList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtFlavor, txtVolume, txtPrice;
        Button btnDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtFlavor = itemView.findViewById(R.id.txtFlavor);
            txtVolume = itemView.findViewById(R.id.txtVolume);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }

    }
}
