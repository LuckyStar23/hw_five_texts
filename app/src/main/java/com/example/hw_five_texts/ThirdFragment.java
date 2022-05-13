package com.example.hw_five_texts;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ThirdFragment extends Fragment {
    private TextView value;
    public static final String KEY_FOR_BUNDLE = "key.String";
    private Button plus;

    private String sum ;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        value = view.findViewById(R.id.third_text);

        if (getArguments()!=null) {
            String val = getArguments().getString(MainFragment.KEY_FOR_BUNDLE);
            value.setText(String.valueOf(val));
        }
        plus = view.findViewById(R.id.btn_click3);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //*if (sum == 10) {
                Bundle bundle = new Bundle();
                bundle.putString(KEY_FOR_BUNDLE, value.getText().toString());

                FourthFragment forFragment= new FourthFragment();
                forFragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, forFragment).addToBackStack(null).commit();


                //*}else {
                //*sum++;
                value.setText(String.valueOf(sum));

            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
