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



        String[] food={"FOR 100g     ", "FRUİTS:", "Pear           61cal","Quince           57cal","Strawberry       37cal","Mulberry       93cal",
                "Apple       58cal","Plum       66cal","Grapefruit       41cal","Watermelon       26cal","Muskmelon       33cal",
                "Apricot       51cal","Cherry       70cal","Lemon       27cal","Mandarin       46cal","Banana       85cal",
                "Pomegranate       63cal","Orange       49cal","Peach       38cal","Grape       67cal","FISH:",
                "Trout       168cal","Perch       93cal","Bonito       168cal","Sardine       160cal","Mackerel       159cal",
                "VEGETABLES:       ","Gumbo       36cal","Pea       84cal","Green Pepper       22cal","Red Pepper       93cal",
                "Tomato       22cal","Artichoke       53cal","Bean       32cal","Carrot       42cal","Cucumber       14cal",
                "Zucchini       19cal","Cauliflower       27cal","Celery       40cal","Lettuce       14cal","Spinach       26cal",
                "Cabbage       24cal","Mushroom       28cal","Parsley       44cal","Mint       65cal","Beetroot       43cal",
                "eggplant       25cal","Potato       76cal","Leek       52cal","Arugula       33cal","Purslane       32cal",
                "Onion       38cal","Radish       19cal","DAIRY PRODUCTS:       ","Fatty White Cheese       289cal","Feta Cheese       99cal",
                "Cheddar Cheese       404cal","Cream Cheese       349cal","Curd Cheese       90cal","Milk       61cal","Yogurt       61cal",
                "Egg       158cal","LEGUMES:       ","Kidney Beans       349cal","Pea       348cal","Black-Eyed Peas       343cal",
                "Dried Bean       340cal","Lentil       340cal","Chickpea       360cal","MEATS:       ","Beef Low-Fat       225cal",
                "Beef        301cal","Salami       450cal","Sausage       322cal","Sucuk       452cal","CANDY AND SWEETS:       ",
                "Honey       315cal","Chocolate       528cal","Ice Cream       207cal","Grape Molasses       293cal","Jam       272cal",
                "Sugar       385cal","GRAIN:","Bulgur Wheat       357cal","Wheat Bread       276cal","Rye Bread       243cal",
                "Bread       264cal","Makarna       369cal","Rice       363cal","ANOTHER:","Potato Chips       568cal",
                "Ketchup       106cal","Salca       98cal","Pickle       10cal","Black Olives       207cal","Green Olives       144cal",
                "Mayonnaise       390cal"};
        ListView listView = (ListView)view.findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,food);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);    //Click listener from listview.
    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i==2){
            Toast.makeText(getActivity(), "Pear - Protein 0,7 , Fat 0,4  , Carb 15,3", Toast.LENGTH_SHORT).show();

        }
        else if(i==3){
            Toast.makeText(getActivity(), "Quince - Protein 0,4 , Fat 0,1  , Carb 15,3", Toast.LENGTH_SHORT).show();
        }
        else if(i==4){
            Toast.makeText(getActivity(), "Strawberry - Protein 0,7 , Fat 0,4  , Carb 8,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==5){
            Toast.makeText(getActivity(), "Mulberry - Protein 9 , Fat 1,1  , Carb 19,8", Toast.LENGTH_SHORT).show();
        }
        else if(i==6){
            Toast.makeText(getActivity(), "Apple - Protein 0,2 , Fat 0,6  , Carb 14.5", Toast.LENGTH_SHORT).show();
        }
        else if(i==7){
            Toast.makeText(getActivity(), "Plum - Protein 5 , Fat 0  , Carb 17,8", Toast.LENGTH_SHORT).show();
        }
        else if(i==8){
            Toast.makeText(getActivity(), "Grapefruit - Protein 0,5 , Fat 0,1  , Carb 10,8", Toast.LENGTH_SHORT).show();
        }
        else if(i==9){
            Toast.makeText(getActivity(), "Watermelon - Protein 0,5 , Fat 0,2  , Carb 6,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==10){
            Toast.makeText(getActivity(), "Muskmelon - Protein 0,8 , Fat 0,3  , Carb 7,7", Toast.LENGTH_SHORT).show();
        }
        else if(i==11){
            Toast.makeText(getActivity(), "Apricot- Protein 1 , Fat 0,2  , Carb 12,8", Toast.LENGTH_SHORT).show();
        }
        else if(i==12){
            Toast.makeText(getActivity(), "Cherry - Protein 1,3 , Fat 0,3  , Carb 17,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==13){
            Toast.makeText(getActivity(), "Lemon - Protein 1,1 , Fat 0,3  , Carb 8,2", Toast.LENGTH_SHORT).show();
        }
        else if(i==14){
            Toast.makeText(getActivity(), "Mandarin  - Protein 8 , Fat 0,2  , Carb 11,6", Toast.LENGTH_SHORT).show();
        }else if(i==15){
            Toast.makeText(getActivity(), "Banana - Protein 1,1 , Fat 0,2  , Carb 22", Toast.LENGTH_SHORT).show();
        }
        else if(i==16){
            Toast.makeText(getActivity(), "Pomegranate - Protein 0,5 , Fat 0,3  , Carb 16", Toast.LENGTH_SHORT).show();
        }
        else if(i==17){
            Toast.makeText(getActivity(), "Orange - Protein 1 , Fat 0,2  , Carb 12,2", Toast.LENGTH_SHORT).show();
        }
        else if(i==18){
            Toast.makeText(getActivity(), "Peach - Protein 0,6 , Fat 0,1  , Carb 9,7", Toast.LENGTH_SHORT).show();
        }
        else if(i==19){
            Toast.makeText(getActivity(), "Grape - Protein 0,6 , Fat 0,3  , Carb 17,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==20){
            Toast.makeText(getActivity(), "Strawberry - Protein 0,7 , Fat 0,5  , Carb 8.4", Toast.LENGTH_SHORT).show();
        }
        else if(i==21){
            Toast.makeText(getActivity(), "Trout - Protein 18,3 , Fat 10  , Carb 0", Toast.LENGTH_SHORT).show();
        }
        else if(i==22){
            Toast.makeText(getActivity(), "Perch - Protein 19,2 , Fat 1,2  , Carb 0", Toast.LENGTH_SHORT).show();
        }
        else if(i==23){
            Toast.makeText(getActivity(), "Bonito - Protein 24 , Fat 7,3  , Carb 0", Toast.LENGTH_SHORT).show();
        }
        else if(i==24){
            Toast.makeText(getActivity(), "Sardine - Protein 19,2 , Fat 8,6  , Carb 0", Toast.LENGTH_SHORT).show();
        }
        else if(i==25){
            Toast.makeText(getActivity(), "Mackerel - Protein 21,9 , Fat 7,3  , Carb 0", Toast.LENGTH_SHORT).show();
        }else if(i==26){
            Toast.makeText(getActivity(), "Strawberry - Protein 0,7 , Fat 0,5  , Carb 8.4", Toast.LENGTH_SHORT).show();
        }
        else if(i==27){
            Toast.makeText(getActivity(), "Gumbo - Protein 2,4 , Fat 0,3  , Carb 7,6", Toast.LENGTH_SHORT).show();
        }
        else if(i==28){
            Toast.makeText(getActivity(), "Pea - Protein 6,3 , Fat 0,4  , Carb 14,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==29){
            Toast.makeText(getActivity(), "Green Pepper - Protein 1,2 , Fat 0,2  , Carb 3,8", Toast.LENGTH_SHORT).show();
        }
        else if(i==30){
            Toast.makeText(getActivity(), "Red Pepper - Protein 3,7 , Fat 2,3  , Carb 18,1", Toast.LENGTH_SHORT).show();
        }
        else if(i==31){
            Toast.makeText(getActivity(), "Tomato  - Protein 1,1 , Fat 0,2  , Carb 4,7", Toast.LENGTH_SHORT).show();
        }
        else if(i==32){
            Toast.makeText(getActivity(), "Artichoke - Protein 3 , Fat 2  , Carb 7,8", Toast.LENGTH_SHORT).show();
        }
        else if(i==33){
            Toast.makeText(getActivity(), "Bean - Protein 1,9 , Fat 0,2  , Carb 7,1", Toast.LENGTH_SHORT).show();
        }
        else if(i==34){
            Toast.makeText(getActivity(), "Carrot - Protein 1,1 , Fat 0,2  , Carb 9,7", Toast.LENGTH_SHORT).show();
        }
        else if(i==35){
            Toast.makeText(getActivity(), "Cucumber - Protein 0,6 , Fat 0,1  , Carb 3,2", Toast.LENGTH_SHORT).show();
        }
        else if(i==36){
            Toast.makeText(getActivity(), "Zucchini - Protein 1,1 , Fat 0,1  , Carb 4,2", Toast.LENGTH_SHORT).show();
        }
        else if(i==37){
            Toast.makeText(getActivity(), "Cauliflower - Protein 2,7 , Fat 0,2  , Carb 5,2", Toast.LENGTH_SHORT).show();
        }
        else if(i==38){
            Toast.makeText(getActivity(), "Celery - Protein 1,8 , Fat 0,3  , Carb 8,5", Toast.LENGTH_SHORT).show();
        }
        else if(i==39){
            Toast.makeText(getActivity(), "Lettuce - Protein 1,2 , Fat 0,2  , Carb 2,5", Toast.LENGTH_SHORT).show();
        }
        else if(i==40){
            Toast.makeText(getActivity(), "Spinach - Protein 3,2 , Fat 0,3  , Carb 4,3", Toast.LENGTH_SHORT).show();
        }
        else if(i==41){
            Toast.makeText(getActivity(), "Cabbage - Protein 1,3 , Fat 0,2  , Carb 5,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==42){
            Toast.makeText(getActivity(), "Mushroom - Protein 2,7 , Fat 0,3  , Carb 4.4", Toast.LENGTH_SHORT).show();
        }
        else if(i==43){
            Toast.makeText(getActivity(), "Parsley - Protein 3,6 , Fat 0,6  , Carb 8.5", Toast.LENGTH_SHORT).show();
        }
        else if(i==44){
            Toast.makeText(getActivity(), "Mint - Protein 4 , Fat 1,3  , Carb 7,9", Toast.LENGTH_SHORT).show();
        }
        else if(i==45){
            Toast.makeText(getActivity(), "Beetroot - Protein 1,6 , Fat 0,1  , Carb 9,9", Toast.LENGTH_SHORT).show();
        }
        else if(i==46){
            Toast.makeText(getActivity(), "Eggplant - Protein 1,2 , Fat 0,2  , Carb 5,6", Toast.LENGTH_SHORT).show();
        }
        else if(i==47){
            Toast.makeText(getActivity(), "Potato - Protein 2,1 , Fat 0,1  , Carb 17,1", Toast.LENGTH_SHORT).show();
        }
        else if(i==48){
            Toast.makeText(getActivity(), "Leek - Protein 2,2 , Fat 0,3  , Carb 11,2", Toast.LENGTH_SHORT).show();
        }
        else if(i==49){
            Toast.makeText(getActivity(), "Arugula - Protein 3 , Fat 0,6  , Carb 5,2", Toast.LENGTH_SHORT).show();
        }
        else if(i==50){
            Toast.makeText(getActivity(), "Purslane - Protein 2 , Fat 0,4  , Carb 3,8", Toast.LENGTH_SHORT).show();
        }
        else if(i==51){
            Toast.makeText(getActivity(), "Onion - Protein 1,5 , Fat 0,1  , Carb 8,7", Toast.LENGTH_SHORT).show();
        }
        else if(i==52){
            Toast.makeText(getActivity(), "Radish - Protein 0,9 , Fat 0,1  , Carb 4,2", Toast.LENGTH_SHORT).show();
        }
        else if(i==53){
            Toast.makeText(getActivity(), "Strawberry - Protein 0,7 , Fat 0,5  , Carb 8.4", Toast.LENGTH_SHORT).show();
        }
        else if(i==54){
            Toast.makeText(getActivity(), "Fatty White Cheese - Protein 22,5 , Fat 21,6  , Carb 0", Toast.LENGTH_SHORT).show();
        }
        else if(i==55){
            Toast.makeText(getActivity(), "Feta Cheese - Protein 19 , Fat 0,7  , Carb 3,8", Toast.LENGTH_SHORT).show();
        }
        else if(i==56){
            Toast.makeText(getActivity(), "Cheddar Cheese - Protein 27 , Fat 31,7  , Carb 1,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==57){
            Toast.makeText(getActivity(), "Cream Cheese - Protein 7,6 , Fat 34,9  , Carb 2,7", Toast.LENGTH_SHORT).show();
        }
        else if(i==58){
            Toast.makeText(getActivity(), "Curd Cheese - Protein 13,7 , Fat 1,9  , Carb 3,6", Toast.LENGTH_SHORT).show();
        }
        else if(i==59){
            Toast.makeText(getActivity(), "Milk - Protein 3,3 , Fat 3,3  , Carb 4,7", Toast.LENGTH_SHORT).show();
        }
        else if(i==60){
            Toast.makeText(getActivity(), "Yogurt - Protein 3,5 , Fat 3,3  , Carb 4,7", Toast.LENGTH_SHORT).show();
        }
        else if(i==61){
            Toast.makeText(getActivity(), "Egg - Protein 12,1 , Fat 11,2  , Carb 1,2", Toast.LENGTH_SHORT).show();
        }
        else if(i==62){
            Toast.makeText(getActivity(), "Strawberry - Protein 0,7 , Fat 0,5  , Carb 8,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==63){
            Toast.makeText(getActivity(), "Kidney Beans - Protein 22,9 , Fat 1,7  , Carb 63,7", Toast.LENGTH_SHORT).show();
        }
        else if(i==64){
            Toast.makeText(getActivity(), "Pea - Protein 24,2 , Fat 1  , Carb 62,7", Toast.LENGTH_SHORT).show();
        }
        else if(i==65){
            Toast.makeText(getActivity(), "Black-Eyed Peas - Protein 22,8 , Fat 1,5  , Carb 61,7", Toast.LENGTH_SHORT).show();
        }
        else if(i==66){
            Toast.makeText(getActivity(), "Dried Bean - Protein 22,3 , Fat 1,6  , Carb 61,3", Toast.LENGTH_SHORT).show();
        }
        else if(i==67){
            Toast.makeText(getActivity(), "Lentil - Protein 24,7 , Fat 1,1  , Carb 60,1", Toast.LENGTH_SHORT).show();
        }
        else if(i==68){
            Toast.makeText(getActivity(), "Chickpea - Protein 20,5 , Fat 4,8  , Carb 61", Toast.LENGTH_SHORT).show();
        }
        else if(i==69){
            Toast.makeText(getActivity(), "Strawberry - Protein 0,7 , Fat 0,5  , Carb 8,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==70){
            Toast.makeText(getActivity(), "Beef Low-Fat - Protein 19,4 , Fat 15,8  , Carb 0", Toast.LENGTH_SHORT).show();
        }
        else if(i==71){
            Toast.makeText(getActivity(), "Beef - Protein 17,4 , Fat 25  , Carb 0", Toast.LENGTH_SHORT).show();
        }
        else if(i==72){
            Toast.makeText(getActivity(), "Salami - Protein 23,8 , Fat 38,1  , Carb 1,2", Toast.LENGTH_SHORT).show();
        }
        else if(i==73){
            Toast.makeText(getActivity(), "Sausage - Protein 11,3 , Fat 29,4  , Carb 2,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==74){
            Toast.makeText(getActivity(), "Sucuk - Protein 21,4 , Fat 40,8  , Carb 0", Toast.LENGTH_SHORT).show();
        }
        else if(i==75){
            Toast.makeText(getActivity(), "Strawberry - Protein 0,7 , Fat 0,5  , Carb 8,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==76){
            Toast.makeText(getActivity(), "Honey - Protein 0,3 , Fat 0  , Carb 78,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==77){
            Toast.makeText(getActivity(), "Chocolate - Protein 4,4 , Fat 35,1  , Carb 57,9", Toast.LENGTH_SHORT).show();
        }
        else if(i==78){
            Toast.makeText(getActivity(), "Ice-cream - Protein 4,5 , Fat 10,6  , Carb 20,8", Toast.LENGTH_SHORT).show();
        }
        else if(i==79){
            Toast.makeText(getActivity(), "Grape Molasses - Protein 0,6 , Fat 0,1  , Carb 70,6", Toast.LENGTH_SHORT).show();
        }
        else if(i==80){
            Toast.makeText(getActivity(), "Jam - Protein 0,6 , Fat 0,1  , Carb 70", Toast.LENGTH_SHORT).show();
        }
        else if(i==81){
            Toast.makeText(getActivity(), "Sugar - Protein 0 , Fat 0  , Carb 70", Toast.LENGTH_SHORT).show();
        }
        else if(i==82){
            Toast.makeText(getActivity(), "Strawberry - Protein 0,7 , Fat 0,5  , Carb 8,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==83){
            Toast.makeText(getActivity(), "Bulgur Wheat - Protein 10,3 , Fat 1,2  , Carb 78,1", Toast.LENGTH_SHORT).show();
        }
        else if(i==84){
            Toast.makeText(getActivity(), "Wheat Bread - Protein 9,1 , Fat 0,8  , Carb 56,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==85){
            Toast.makeText(getActivity(), "Rye Bread - Protein 9,1 , Fat 1,1  , Carb 52,1", Toast.LENGTH_SHORT).show();
        }
        else if(i==86){
            Toast.makeText(getActivity(), "Bread - Protein 10,6 , Fat 2,1  , Carb 43,9", Toast.LENGTH_SHORT).show();
        }
        else if(i==87){
            Toast.makeText(getActivity(), "Makarna - Protein 12,5 , Fat 1,2  , Carb 75,2", Toast.LENGTH_SHORT).show();
        }
        else if(i==88){
            Toast.makeText(getActivity(), "Rice - Protein 6,7 , Fat 0,4  , Carb 80,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==89){
            Toast.makeText(getActivity(), "Strawberry - Protein 0,7 , Fat 0,5  , Carb 8,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==90){
            Toast.makeText(getActivity(), "Potato Chips - Protein 2,3 , Fat 39,8  , Carb 50", Toast.LENGTH_SHORT).show();
        }
        else if(i==91){
            Toast.makeText(getActivity(), "Ketchup - Protein 2 , Fat 0,4  , Carb 25,4", Toast.LENGTH_SHORT).show();
        }
        else if(i==92){
            Toast.makeText(getActivity(), "Salca - Protein 2,7 , Fat 0,4  , Carb 21,3", Toast.LENGTH_SHORT).show();
        }
        else if(i==93){
            Toast.makeText(getActivity(), "Pickle - Protein 0,6 , Fat 0,2  , Carb 2", Toast.LENGTH_SHORT).show();
        }
        else if(i==94){
            Toast.makeText(getActivity(), "Black Olives - Protein 1,8 , Fat 21  , Carb 1,1", Toast.LENGTH_SHORT).show();
        }
        else if(i==95){
            Toast.makeText(getActivity(), "Green Olives - Protein 1,5 , Fat 13,5  , Carb 2,8", Toast.LENGTH_SHORT).show();
        }
        else if(i==96){
            Toast.makeText(getActivity(), "Mayonnaise - Protein 0,9 , Fat 33,4  , Carb 23,9", Toast.LENGTH_SHORT).show();
        }










    }
}