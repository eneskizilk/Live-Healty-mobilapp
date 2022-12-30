package com.example.gokfitness;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeightFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeightFragment extends Fragment {
 TextView breakfasttext,breakfastcal,lunchfasttext,lunchfastcal,dinnerfasttext,dinnerfastcal,movetext;
 int s=0;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WeightFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeightFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeightFragment newInstance(String param1, String param2) {
        WeightFragment fragment = new WeightFragment();
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
        return inflater.inflate(R.layout.fragment_weight, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        breakfasttext=(TextView) view.findViewById(R.id.breakfasttext);
        breakfastcal=(TextView) view.findViewById(R.id.breakfastcal);

        lunchfastcal=(TextView) view.findViewById(R.id.lunchcal);
        lunchfasttext=(TextView) view.findViewById(R.id.lunchfasttext);

        dinnerfasttext=(TextView) view.findViewById(R.id.dinnerfasttext);
        dinnerfastcal=(TextView) view.findViewById(R.id.dinnercal);

        movetext=(TextView)view.findViewById(R.id.movestext);

        String[] breakfas = new String[]{              //breakfast
                "","Pear","Quince","Strawberry","Mulberry","Apple","Plum","Grapefruit","Watermelon","Muskmelon",
                "Apricot","Cherry","Lemon","Mandarin","Banana","Pomegranate","Orange","Peach","Grape",
                "Trout","Perch","Bonito","Sardine","Mackerel","Gumbo","Pea","Green Pepper","Red Pepper",
                "Tomato","Artichoke","Bean","Carrot","Cucumber","Zucchini","Cauliflower","Celery","Lettuce","Spinach",
                "Cabbage","Mushroom","Parsley","Mint","Beetroot","eggplant","Potato","Leek","Arugula","Purslane",
                "Onion","Radish","Fatty White Cheese","Feta Cheese","Cheddar Cheese","Cream Cheese","Curd Cheese","Milk","Yogurt",
                "Egg","Kidney Beans","Pea","Black-Eyed Peas","Dried Bean","Lentil","Chickpea","Beef Low-Fat",
                "Beef","Salami","Sausage","Sucuk","Honey","Chocolate","Ice Cream","Grape Molasses","Jam",
                "Sugar","Bulgur Wheat","Wheat Bread","Rye Bread","Bread","Makarna","Rice","Potato Chips",
                "Ketchup","Salca","Pickle","Black Olives","Green Olives","Mayonnaise"

        };

        int[] breakfascal= new int[]{                //Breakfast cal
                0,61,57,37,93,58,66,41,26,33,51,70,27,46,85,63,49,38,67,168,93,168,160,159,36,84,22,93,22,53,32,42,14,19,27,40,
                14,26,24,28,44,65,43,25,76,52,33,32,38,19,289,99,404,349,90,61,61,158,349,348,343,340,340,360,225,301,450,322,
                452,315,528,207,293,272,385,357,276,243,264,369,363,568,106,98,10,207,144,390
        };

        String[] lunchfas = new String[]{              //Lunch
                "","Pear","Quince","Strawberry","Mulberry","Apple","Plum","Grapefruit","Watermelon","Muskmelon",
                "Apricot","Cherry","Lemon","Mandarin","Banana","Pomegranate","Orange","Peach","Grape",
                "Trout","Perch","Bonito","Sardine","Mackerel","Gumbo","Pea","Green Pepper","Red Pepper",
                "Tomato","Artichoke","Bean","Carrot","Cucumber","Zucchini","Cauliflower","Celery","Lettuce","Spinach",
                "Cabbage","Mushroom","Parsley","Mint","Beetroot","eggplant","Potato","Leek","Arugula","Purslane",
                "Onion","Radish","Fatty White Cheese","Feta Cheese","Cheddar Cheese","Cream Cheese","Curd Cheese","Milk","Yogurt",
                "Egg","Kidney Beans","Pea","Black-Eyed Peas","Dried Bean","Lentil","Chickpea","Beef Low-Fat",
                "Beef","Salami","Sausage","Sucuk","Honey","Chocolate","Ice Cream","Grape Molasses","Jam",
                "Sugar","Bulgur Wheat","Wheat Bread","Rye Bread","Bread","Makarna","Rice","Potato Chips",
                "Ketchup","Salca","Pickle","Black Olives","Green Olives","Mayonnaise"
        };

        int[] lunchfascal= new int[]{                //Lunch cal
                0,61,57,37,93,58,66,41,26,33,51,70,27,46,85,63,49,38,67,168,93,168,160,159,36,84,22,93,22,53,32,42,14,19,27,40,
                14,26,24,28,44,65,43,25,76,52,33,32,38,19,289,99,404,349,90,61,61,158,349,348,343,340,340,360,225,301,450,322,
                452,315,528,207,293,272,385,357,276,243,264,369,363,568,106,98,10,207,144,390
        };

        String[] dinnerfas = new String[]{              //Dinner
                "","Pear","Quince","Strawberry","Mulberry","Apple","Plum","Grapefruit","Watermelon","Muskmelon",
                "Apricot","Cherry","Lemon","Mandarin","Banana","Pomegranate","Orange","Peach","Grape",
                "Trout","Perch","Bonito","Sardine","Mackerel","Gumbo","Pea","Green Pepper","Red Pepper",
                "Tomato","Artichoke","Bean","Carrot","Cucumber","Zucchini","Cauliflower","Celery","Lettuce","Spinach",
                "Cabbage","Mushroom","Parsley","Mint","Beetroot","eggplant","Potato","Leek","Arugula","Purslane",
                "Onion","Radish","Fatty White Cheese","Feta Cheese","Cheddar Cheese","Cream Cheese","Curd Cheese","Milk","Yogurt",
                "Egg","Kidney Beans","Pea","Black-Eyed Peas","Dried Bean","Lentil","Chickpea","Beef Low-Fat",
                "Beef","Salami","Sausage","Sucuk","Honey","Chocolate","Ice Cream","Grape Molasses","Jam",
                "Sugar","Bulgur Wheat","Wheat Bread","Rye Bread","Bread","Makarna","Rice","Potato Chips",
                "Ketchup","Salca","Pickle","Black Olives","Green Olives","Mayonnaise"
        };

        int[] dinnerfascal= new int[]{                //Dinner cal
                0,61,57,37,93,58,66,41,26,33,51,70,27,46,85,63,49,38,67,168,93,168,160,159,36,84,22,93,22,53,32,42,14,19,27,40,
                14,26,24,28,44,65,43,25,76,52,33,32,38,19,289,99,404,349,90,61,61,158,349,348,343,340,340,360,225,301,450,322,
                452,315,528,207,293,272,385,357,276,243,264,369,363,568,106,98,10,207,144,390
        };

        String[] movespi = new String[]{              //Move
                "","DUMBEL CURL", "CONCENTRATİON CURL","TRICEPS DIPS","DUMBBELL KICKBACK","BENCH DIPS","BENCH PRESS","PEC DECK FLY",
                "INCLINE BARBELL BENCH PRESS","DUMBBELL PULLOVER","DUMBBELL FLY","DUMBBELL SHOULDER PRESS","DUMBBELL LATERAL RAISE",
                "LAT PULLDOWN","DUMBBELL ROW","DUMBBELL ROW","SEATED CABLE ROW","SQUAT","LEG PRESS","LEG EXTENSION","SEATED LEG CURL",
                "DEADLIFT",
        };
        /*
        * Spinner declare here
        * */

        /*
         * moves spinner
         * */
        Spinner movespin=(Spinner) view.findViewById(R.id.movesspin);
        ArrayAdapter<String> moveadapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, movespi);
        movespin.setAdapter(moveadapter);
        movespin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String movetextt=movetext.getText().toString();

                movetext.setText(movetextt+","+adapterView.getItemAtPosition(i));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        /*
         * Lunch spinner
         * */
        Spinner lunchspinner=(Spinner) view.findViewById(R.id.lunchspin);
        ArrayAdapter<String> lunchadapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, lunchfas);
        lunchspinner.setAdapter(lunchadapter);
        lunchspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String lucnhfast=lunchfasttext.getText().toString();
                String lunchcal=lunchfastcal.getText().toString();

                lunchfasttext.setText(lucnhfast+","+adapterView.getItemAtPosition(i));
                lunchfastcal.setText(lunchcal+"+"+lunchfascal[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        /*
        * Dinner spinner
        * */

        Spinner dinnerspin=(Spinner) view.findViewById(R.id.dinnerspin);
        ArrayAdapter<String> dinneradapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, dinnerfas);
        dinnerspin.setAdapter(dinneradapter);
        dinnerspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String dinnerfasttextt=dinnerfasttext.getText().toString();
                String dinnercal=dinnerfastcal.getText().toString();

                dinnerfasttext.setText(dinnerfasttextt+","+adapterView.getItemAtPosition(i));
                dinnerfastcal.setText(dinnercal+"+"+dinnerfascal[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        /*
         * Breakfast spinner
         * */

        Spinner breakfastspinner=(Spinner) view.findViewById(R.id.breakfastspin);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, breakfas);
        breakfastspinner.setAdapter(adapter);
        breakfastspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String breakfasttextst=breakfasttext.getText().toString();
                String breakfasttextcal=breakfastcal.getText().toString();

                breakfasttext.setText(breakfasttextst+","+adapterView.getItemAtPosition(i));
                breakfastcal.setText(breakfasttextcal+"+"+breakfascal[i]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}