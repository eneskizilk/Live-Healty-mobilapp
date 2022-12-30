package com.example.gokfitness;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.content.Intent.getIntent;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Gymfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Gymfragment extends Fragment {
     Button arm,chest, shoulder_back,leg,add_memory;
    Bundle arguments = getArguments();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Gymfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Gymfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Gymfragment newInstance(String param1, String param2) {
        Gymfragment fragment = new Gymfragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gymfragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        arm=(Button) view.findViewById(R.id.armbutton);
        chest=(Button) view.findViewById(R.id.chestbutton);
        shoulder_back=(Button) view.findViewById(R.id.shoulderbackbutton);
        leg=(Button) view.findViewById(R.id.legbutton);
        add_memory=(Button)view.findViewById(R.id.addmemory);
        arm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(),gridviewimage.class);
        intent.putExtra("TYPE", "arm");
        startActivity(intent);
    }
});
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),gridviewimage.class);
                intent.putExtra("TYPE", "chest");
                startActivity(intent);
            }
        });
shoulder_back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(),gridviewimage.class);
        intent.putExtra("TYPE", "shoulder");
        startActivity(intent);
    }
});
leg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(),gridviewimage.class);
        intent.putExtra("TYPE", "leg");
        startActivity(intent);
    }
});
add_memory.setOnClickListener(new View.OnClickListener() {             //Create empty activity for upload photo or something
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(),uploadphoto.class);
        startActivity(intent);
    }
});

    }
}