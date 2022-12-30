package com.example.gokfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class gridviewimage extends AppCompatActivity {
    GridView gridview;
    String[] ArmMove={"DUMBEL CURL","DUMBEL CURL","CONCENTRATİON CURL","CONCENTRATİON CURL","TRICEPS DIPS",
            "TRICEPS DIPS","DUMBBELL KICKBACK","DUMBBELL KICKBACK","BENCH DIPS","BENCH DIPS"};
    int[] armimages={R.drawable.dumbellcurl,R.drawable.dumbellcurl2,R.drawable.concertioncurl1,
            R.drawable.concernationcurl2,R.drawable.dips,R.drawable.dips2,R.drawable.kickback1,
            R.drawable.kickback2,R.drawable.benchdips1,R.drawable.benchdips2};
    String[] chestmove={"BENCH PRESS","BENCH PRESS","PEC DECK FLY","PEC DECK FLY","INCLINE BARBELL BENCH PRESS"
            ,"INCLINE BARBELL BENCH PRESS","DUMBBELL PULLOVER","DUMBBELL PULLOVER","DUMBBELL FLY","DUMBBELL FLY"};
    int[] chestimages={R.drawable.benchpress1,R.drawable.benchpress2,R.drawable.pectoralfly1,R.drawable.pectoralfly2
            ,R.drawable.incline1,R.drawable.incline2,R.drawable.pullover,R.drawable.pullover2,R.drawable.dfly1,R.drawable.dfly2};

    String[] shouldermove={"DUMBBELL SHOULDER PRESS","DUMBBELL SHOULDER PRESS","DUMBBELL LATERAL RAISE"
            ,"DUMBBELL LATERAL RAISE","LAT PULLDOWN","LAT PULLDOWN","DUMBBELL ROW","DUMBBELL ROW","SEATED CABLE ROW","SEATED CABLE ROW"};
    int[] shoulderimages={R.drawable.shoulder1,R.drawable.shoulder2,R.drawable.lateralrise1,R.drawable.lateralrise2
            ,R.drawable.latpulldown1,R.drawable.latpulldown2,R.drawable.row1,R.drawable.row2,R.drawable.cablerow1,R.drawable.cablerow2};

    String[] legmove={"SQUAT","SQUAT","LEG PRESS","LEG PRESS","LEG EXTENSION","LEG EXTENSION","SEATED LEG CURL",
            "SEATED LEG CURL","DEADLIFT","DEADLIFT"};
    int[] legimages={R.drawable.squad1,R.drawable.squad2,R.drawable.legpress1,R.drawable.legpress2,R.drawable.legex1
            ,R.drawable.legex2,R.drawable.legcurl1,R.drawable.legcurl2,R.drawable.deadlift1,R.drawable.deadlift2};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridviewimage);
        gridview=findViewById(R.id.gridviewid);
        String type = getIntent().getStringExtra("TYPE");
        Customadapter customadapter=new Customadapter(type);
        gridview.setAdapter(customadapter);

    }

    private class Customadapter extends BaseAdapter {
        String tip;

        public Customadapter(String type) {
            tip=type;
        }

        @Override
        public int getCount() {
            if(tip.contentEquals("arm")){
                return armimages.length;
            }
            else if(tip.contentEquals("chest")){
                return chestimages.length;
            }
            else if(tip.contentEquals("shoulder")){
                return shoulderimages.length;
            }
            else if(tip.contentEquals("leg")){
                return legimages.length;
            }
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1=getLayoutInflater().inflate(R.layout.row_data,null);
            TextView name=view1.findViewById(R.id.movetext);
            ImageView image=view1.findViewById(R.id.moveimage);
            if(tip.contentEquals("arm")){
                name.setText(ArmMove[i]);
                image.setImageResource(armimages[i]);
                return view1;
            }
            else if(tip.contentEquals("chest")){
                name.setText(chestmove[i]);
                image.setImageResource(chestimages[i]);
                return view1;
            }
            else if(tip.contentEquals("shoulder")){
                name.setText(shouldermove[i]);
                image.setImageResource(shoulderimages[i]);
                return view1;
            }
            else if(tip.contentEquals("leg")){
                name.setText(legmove[i]);
                image.setImageResource(legimages[i]);
                return view1;
            }


            return view1;

        }
    }
}