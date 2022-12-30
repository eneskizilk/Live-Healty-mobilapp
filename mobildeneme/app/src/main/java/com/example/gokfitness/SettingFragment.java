package com.example.gokfitness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingFragment extends Fragment {
    Button exit,update;
    String ide;
    Spinner spinnergender;
    EditText name,password,birth;
    ArrayAdapter<String> adaptergender;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingFragment newInstance(String param1, String param2) {
        SettingFragment fragment = new SettingFragment();
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
    //On data change null
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_setting, container, false);
        Bundle data = getArguments();

        if (data != null) {
            ide =data.getString("ID");
            System.out.println(ide);
        }
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        /*
         * Burda dene
         *
         *  */
        super.onViewCreated(view, savedInstanceState);
        String[] sexsp = new String[]{              //breakfast
                "Male", "Female"
        };
        Button exit=(Button) view.findViewById(R.id.Exit);
        update=(Button)view.findViewById(R.id.Update);
        name=(EditText)view.findViewById(R.id.UserName);
        password=(EditText)view.findViewById(R.id.editTextTextPassword2);
        spinnergender=(Spinner)view.findViewById(R.id.sexspinner);


        ArrayAdapter<String> genderspin = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, sexsp
        );
        spinnergender.setAdapter(genderspin);


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.exit(0);

            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sex=spinnergender.getSelectedItem().toString();
                String editname=name.getText().toString();
                String editpassword=password.getText().toString();
                if(editname.isEmpty() || editpassword.isEmpty()){
                    System.out.println("Please fill empty field");
                }
                else{
                    FirebaseDatabase database = FirebaseDatabase.getInstance("https://fitnessgok-default-rtdb.europe-west1.firebasedatabase.app/");
                    DatabaseReference myRef = database.getReference("Users");
                    UUID uuid = UUID.fromString(UUID.randomUUID().toString());
                    UserUpdate usup=new UserUpdate(uuid,editname,editpassword,sex);
                    myRef.child(String.valueOf(uuid)).setValue(usup);

                }
            }
        });


    }
}