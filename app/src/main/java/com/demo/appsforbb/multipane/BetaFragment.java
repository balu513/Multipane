package com.demo.appsforbb.multipane;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BetaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail, null);
        TextView tv = (TextView) view.findViewById(R.id.textview);
        Bundle bundle = getArguments();
        tv.setText(bundle.getString("data"));
        return view;
    }
}
