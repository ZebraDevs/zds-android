package com.zebra.zdsDemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.fragment.app.Fragment;

import com.zebra.zdsDemo.R;
import com.zebra.zds.ZdsButton;
import com.zebra.zds.ZdsSelectInput;

import java.util.LinkedList;
import java.util.Objects;

public class SelectInputFragment extends Fragment {
    LinkedList<String> items = new LinkedList<>();

    public SelectInputFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        items.clear();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        items.add("Item 4");

        ZdsSelectInput selectInput = requireView().findViewById(R.id.zebra_select_input);
        selectInput.setPlaceholder("Placeholder");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), R.layout.select_input_item, items);
        Objects.requireNonNull(selectInput.getTextInputEditText()).setAdapter(adapter);

        ZdsSelectInput selectInputSharp = getView().findViewById(R.id.zebra_select_input_sharp);
        selectInputSharp.setPlaceholder("Placeholder");

        ArrayAdapter<String> adapterSharp = new ArrayAdapter<>(requireContext(), R.layout.select_input_item, items);
        Objects.requireNonNull(selectInputSharp.getTextInputEditText()).setAdapter(adapterSharp);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_select_input, container, false);

        ZdsSelectInput selectInput = root.findViewById(R.id.zebra_select_input);
        ZdsSelectInput selectInputSharp = root.findViewById(R.id.zebra_select_input_sharp);

        ZdsButton btnSetError = root.findViewById(R.id.buttonSetError);
        ZdsButton btnClearError = root.findViewById(R.id.buttonClearError);

        btnSetError.setOnClickListener(v -> {
            selectInput.setError("Error");
            selectInputSharp.setError("Error");
        });
        btnClearError.setOnClickListener(v -> {
            selectInput.setError(null);
            selectInputSharp.setError(null);
        });

        return root;
    }
}