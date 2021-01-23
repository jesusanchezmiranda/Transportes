package com.jesus.clientetransportes.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.jesus.clientetransportes.R;
import com.jesus.clientetransportes.model.laravel.pojo.Camionero;
import com.jesus.clientetransportes.viewmodel.ViewModel;

public class InsertFragment extends Fragment {

    private EditText etURL, etName, etPhone, etSalary, etPop;
    private Button btInsert;
    private ViewModel viewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insert, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etURL = view.findViewById(R.id.eturl);
        etName = view.findViewById(R.id.etName);
        etPhone = view.findViewById(R.id.etPhone);
        etSalary = view.findViewById(R.id.etSalary);
        etPop = view.findViewById(R.id.etPopulation);
        btInsert = view.findViewById(R.id.btInsertC);

        viewModel = new ViewModelProvider(getActivity()).get(ViewModel.class);

        Camionero camionero = new Camionero();

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etURL.getText().toString().isEmpty() || etName.getText().toString().isEmpty() || etPhone.getText().toString().isEmpty() || etSalary.getText().toString().isEmpty() || etPop.getText().toString().isEmpty() ){
                    Toast.makeText(getActivity(), "Fill all the gaps", Toast.LENGTH_LONG).show();
                }else{
                    camionero.setFoto(etURL.getText().toString());
                    camionero.setNombre(etName.getText().toString());
                    camionero.setTelefono(etPhone.getText().toString());
                    camionero.setSalario(Float.parseFloat(etSalary.getText().toString()));
                    camionero.setPoblacion(etPop.getText().toString());
                    viewModel.insertCamionero(camionero);
                    Toast.makeText(getActivity(), "Insert correctly", Toast.LENGTH_LONG).show();
                    NavHostFragment.findNavController(InsertFragment.this).navigate(R.id.action_InsertFragment_to_FirstFragment);
                }

            }
        });


    }
}