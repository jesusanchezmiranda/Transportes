package com.jesus.clientetransportes.view;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.jesus.clientetransportes.R;
import com.jesus.clientetransportes.model.laravel.pojo.Camionero;
import com.jesus.clientetransportes.model.laravel.pojo.Paquete;
import com.jesus.clientetransportes.view.adapter.RecyclerAdapter;
import com.jesus.clientetransportes.view.adapter.RecyclerDrivers;
import com.jesus.clientetransportes.viewmodel.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class EditPackageFragment extends Fragment {

    private ViewModel viewModel;
    private EditText etDescriptionE, etPrizeE;
    private Paquete paquete = new Paquete();
    private Button btEdit, btDelete;



    public EditPackageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_package, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etDescriptionE = view.findViewById(R.id.etDescriptionE);
        etPrizeE = view.findViewById(R.id.etPrizeE);

        btEdit = view.findViewById(R.id.btEP);
        btDelete = view.findViewById(R.id.btDP);
        viewModel = new ViewModelProvider(getActivity()).get(ViewModel.class);
        paquete = viewModel.getPaquete();
        etDescriptionE.setText(paquete.getDescripcion());
        etPrizeE.setText(paquete.getPrecio()+"");


        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paquete paquet = new Paquete();
                paquet.setId(paquete.getId());
                paquet.setDescripcion(etDescriptionE.getText().toString());
                paquet.setPrecio(Float.parseFloat(etPrizeE.getText().toString()));
                paquet.setIdcamionero(paquete.getIdcamionero());
                viewModel.updatePaquete(paquete.getId(), paquet);
                Toast.makeText(getActivity(), "Update correctly", Toast.LENGTH_LONG).show();
                NavHostFragment.findNavController(EditPackageFragment.this).navigate(R.id.action_editPackageFragment_to_FirstFragment);
            }
        });


        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder alertDialog = new MaterialAlertDialogBuilder(getContext());
                alertDialog.setTitle("Delete");
                alertDialog.setMessage("Are you sure?");
                alertDialog.setCancelable(false);
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        viewModel.deletePaquete(paquete.getId());
                        Toast.makeText(getActivity(), "Delete correctly", Toast.LENGTH_LONG).show();
                        NavHostFragment.findNavController(EditPackageFragment.this).navigate(R.id.action_editPackageFragment_to_FirstFragment);
                    }
                });
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).show();
            }
        });







    }
}