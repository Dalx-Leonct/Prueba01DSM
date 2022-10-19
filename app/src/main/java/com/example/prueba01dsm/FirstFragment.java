package com.example.prueba01dsm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.prueba01dsm.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private Spinner spinner;
    private Button button;
    private ListView list;
    private TextView text;
    private String nombres [] = {"Diego", "Juan"};
    private String correo [] = {"Diego@ucn.cl", "juanitoanikilator@hotmail.com"};



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spinner = (Spinner) binding.spinner;
        button = (Button) binding.button;
        list = (ListView) binding.listview;
        text = (TextView) binding.textView;
        String[] animales =
                {
                        "Perro",
                        "Gato",
                        "Hamster",
                        "Pez",

                };
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this.getContext(), R.layout.spinner_animal_mod, animales);
        spinner.setAdapter(adapter);


        ArrayAdapter <String> adaptador = new ArrayAdapter<String>(this.getContext(),R.layout.listview_mod, nombres);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                text.setText("El correo de " + list.getItemAtPosition(i)+ " es: "+ correo[i]);
            }
        });

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        binding.button.setOnClickListener((View v) ->{
            String seleccion =spinner.getSelectedItem().toString();
            switch (seleccion){
                case"Perro":{
                    Toast.makeText(this.getContext(), "Animal domestico, bueno con las personas", Toast.LENGTH_SHORT).show();
                    break;
                }
                case"Gato":{
                    Toast.makeText(this.getContext(), "Animal versatil, felino y saltarin", Toast.LENGTH_SHORT).show();
                    break;
                }
                case"Hamster":{
                    Toast.makeText(this.getContext(), "Ruedor jugueton", Toast.LENGTH_SHORT).show();
                    break;
                }
                case"Pez":{
                    Toast.makeText(this.getContext(), "Animal acuatico asustadizo", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}