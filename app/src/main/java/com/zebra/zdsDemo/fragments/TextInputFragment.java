package com.zebra.zdsDemo.fragments;

import static android.text.InputType.TYPE_CLASS_TEXT;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.zebra.zdsDemo.R;
import com.zebra.zds.ZdsButton;
import com.zebra.zds.ZdsTextInput;

import java.util.Objects;

public class TextInputFragment extends Fragment {

    public TextInputFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_text_input, container, false);

        ZdsTextInput input = root.findViewById(R.id.zebra_text_input);
        input.setHint("Hint");
        Objects.requireNonNull(input.getTextInputEditText()).setInputType(TYPE_CLASS_TEXT);
        input.getTextInputEditText().setMaxLines(1);


        ZdsTextInput inputDense = root.findViewById(R.id.zebra_text_input_dense);
        inputDense.setHint("Connected left view");

        ImageView image = new ImageView(getContext());
        image.setImageResource(R.drawable.ic_chevron_right_sharp);
        image.setPadding(24, 0, 24, 0);
        image.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.zebra_hint)));

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        image.setLayoutParams(params);
        inputDense.connectViewLeft(image);
        inputDense.setPlaceholder("Placeholder");
        Objects.requireNonNull(inputDense.getTextInputEditText()).setInputType(TYPE_CLASS_TEXT);
        inputDense.getTextInputEditText().setMaxLines(1);

        ZdsTextInput inputSharp = root.findViewById(R.id.zebra_text_input_sharp);
        inputSharp.setHint("Sharp style text area");
        Objects.requireNonNull(inputSharp.getTextInputEditText()).setGravity(Gravity.TOP);
        inputSharp.getTextInputEditText().setMinLines(4);

        ZdsButton btnSetError = root.findViewById(R.id.buttonSetError);
        ZdsButton btnClearError = root.findViewById(R.id.buttonClearError);

        btnSetError.setOnClickListener(v -> {
            input.setError("Error");
            inputSharp.setError("Error");
            inputDense.setError("Error");
        });
        btnClearError.setOnClickListener(v -> {
            input.setError(null);
            inputSharp.setError(null);
            inputDense.setError(null);
        });

        return root;
    }
}