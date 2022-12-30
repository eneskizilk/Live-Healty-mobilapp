package com.example.gokfitness;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonalFragment extends Fragment {
    LineGraphSeries<DataPoint> series;
    EditText start,current,goal;
    Button calculate;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PersonalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PersonalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonalFragment newInstance(String param1, String param2) {
        PersonalFragment fragment = new PersonalFragment();
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
        return inflater.inflate(R.layout.fragment_personal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GraphView graph=(GraphView) view.findViewById(R.id.graph);
        EditText start=(EditText) view.findViewById(R.id.Start);
        EditText current=(EditText) view.findViewById(R.id.Current);
        EditText goal=(EditText) view.findViewById(R.id.Goal);
        Button calculate=(Button) view.findViewById(R.id.Calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int start1=Integer.parseInt(start.getText().toString());
                    int current1=Integer.parseInt(current.getText().toString());
                    int goal1=Integer.parseInt(goal.getText().toString());
                    System.out.println(start1);

                    LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                            new DataPoint(0, start1),
                            new DataPoint(1, current1),
                            new DataPoint(2, goal1),

                    });
                    graph.addSeries(series);
                }catch (Exception ex){
                  System.out.println("boşlukları doldur");
                }
                

             /*   series = new LineGraphSeries<DataPoint>();
                series.appendData(new DataPoint(1,1),true,500);
                series.appendData(new DataPoint(2,2),true,500);
                series.appendData(new DataPoint(3,3),true,500);   */

            }
        });

    }
}