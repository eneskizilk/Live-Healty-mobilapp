package com.example.gokfitness;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodFragment extends Fragment implements AdapterView.OnItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FoodFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodFragment newInstance(String param1, String param2) {
        FoodFragment fragment = new FoodFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View contentView=inflater.inflate(R.layout.fragment_food, container, false);
        ListView listView = contentView.findViewById(R.id.listview);
        return contentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        String[] food={"Egg           30","Watermelon           50","Lemon       50"};
        ListView listView = (ListView)view.findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,food);
       listView.setAdapter(adapter);
      listView.setOnItemClickListener(this);    //Click listener from listview.
    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
          if(i==0){
              Toast.makeText(getActivity(), "Egg 30 carbon 15 protein vs", Toast.LENGTH_SHORT).show();

          }
          else if(i==1){
              Toast.makeText(getActivity(), "Watermelon 60 carbon 20 protein vs", Toast.LENGTH_SHORT).show();
          }
    }
}