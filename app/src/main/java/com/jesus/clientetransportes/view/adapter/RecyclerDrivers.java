package com.jesus.clientetransportes.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.jesus.clientetransportes.R;
import com.jesus.clientetransportes.model.laravel.pojo.Camionero;
import com.jesus.clientetransportes.viewmodel.ViewModel;

import java.util.List;

public class RecyclerDrivers extends RecyclerView.Adapter<RecyclerDrivers.ViewHolder> {

    private Context contexto;
    private List<Camionero> camioneros;
    private ViewModel viewModel;

    public RecyclerDrivers(Context contexto, List<Camionero> camioneros) {
        this.contexto = contexto;
        this.camioneros = camioneros;
    }

    @NonNull
    @Override
    public RecyclerDrivers.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item3, parent, false);
        viewModel = new ViewModelProvider((ViewModelStoreOwner) contexto).get(ViewModel.class);
        ViewHolder holder = new ViewHolder(vista);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //pasarle el numero de llamadas tambien

        holder.elnombre.setText(camioneros.get(position).getNombre()); //camioneros.get(position0) -> tengo el objeto camionero
        holder.elId.setText(camioneros.get(position).getId()+"");

    }


    @Override
    public int getItemCount() {
        return camioneros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView elnombre, elId;
        ConstraintLayout parentlayout;

        public ViewHolder(View itemView) {
            super(itemView);
            elId = itemView.findViewById(R.id.tvIdDriver);
            elnombre = itemView.findViewById(R.id.tvNomDriver);
            parentlayout = itemView.findViewById(R.id.parentlayout3);
        }


    }
}
