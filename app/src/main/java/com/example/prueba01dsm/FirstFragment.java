package com.example.prueba01dsm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

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


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState



    ) {


        binding = FragmentFirstBinding.inflate(inflater, container, false);
        spinner = (Spinner) binding.spinner;
        button = (Button) binding.button;
        list = (ListView) binding.listview;
        text = (TextView) binding.textView;
        String[] animales =
                {
                        "Perro",
                        "Gato",
                        "Hamster",
                        "Peces",
                        "Gaviotas",
                };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, spinner, animales)

        return binding.getRoot();



    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}