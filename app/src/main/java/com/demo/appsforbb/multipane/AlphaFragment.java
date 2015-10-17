package com.demo.appsforbb.multipane;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AlphaFragment extends Fragment {

    private ListView listView;
    private ArrayList<String> list;
    private View view;
    private boolean isLand;
    private String clickedItem;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.listfrag, null);
        Bundle bundle = getArguments();
        isLand = bundle.getBoolean("isLand");
        setListView();
        return view;
    }

    private void setListView() {
        list = new ArrayList<String>();
        listView = (ListView) view.findViewById(R.id.listView);
        for (int i = 1; i <= 100; i++)
            list.add(i + "");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickedItem = list.get(position) + "";
                Bundle bundle = new Bundle();
                bundle.putString("data", clickedItem);
                if (!isLand) {
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    ((MainActivity)getActivity()).replaceFragment(new BetaFragment(),bundle);
                }
            }
        });

    }

}
