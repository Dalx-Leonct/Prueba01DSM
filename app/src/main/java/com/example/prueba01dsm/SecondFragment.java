package com.example.prueba01dsm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.prueba01dsm.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private EditText txt_correo;
    private EditText txt_nombre;
    private EditText txt_search;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txt_correo = (EditText) binding.txtCorreo;
        txt_nombre = (EditText)  binding.txtNombre;
        txt_search= (EditText) binding.txtSearch;

        SharedPreferences preferences = getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
        String correo = preferences.getString("correo", "");
        String nombre = preferences.getString("nombre", "");
        txt_correo.setText(correo);
        txt_nombre.setText(nombre);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
                guardar();

            }
        });

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscar();

            }
        });

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Audio();

            }
        });

        binding.buttonNavegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Web();

            }
        });


       binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_thirdFragment);
            }
        });


    }

    public void save(){
        SharedPreferences pref = getActivity().getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor edt = pref.edit();
        edt.putString("correo", txt_correo.getText().toString());
        edt.putString("nombre", txt_nombre.getText().toString());
        edt.commit();
    }

    public void guardar(){
        String correo = txt_correo.getText().toString();
        String nombre = txt_nombre.getText().toString();
        SharedPreferences preferences = getActivity().getSharedPreferences("Agenda",Context.MODE_PRIVATE);
        SharedPreferences.Editor edicion = preferences.edit();
        edicion.putString(correo, nombre);
        edicion.commit();
        Toast.makeText(getActivity(), "Datos guardados", Toast.LENGTH_SHORT).show();
    }

    public void buscar(){

        String correo = txt_correo.getText().toString();
        SharedPreferences preferences = getActivity().getSharedPreferences("Agenda", Context.MODE_PRIVATE);
        String nombre = preferences.getString(correo,"");

        if (nombre.length()==0){
            Toast.makeText(getActivity(), "No existe registro", Toast.LENGTH_SHORT).show();
        }else{
            txt_nombre.setText(nombre);
        }
    }

    public void Audio(){
        MediaPlayer mp = MediaPlayer.create(this.getContext(), R.raw.sound);
        mp.start();
    }

    public void Web(){
        Intent i = new Intent(this.getContext(), MainActivity2.class);
        i.putExtra("web",txt_search.getText().toString());
        startActivity(i);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}










