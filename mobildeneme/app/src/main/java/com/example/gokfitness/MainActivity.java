package com.example.gokfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

public class MainActivity extends AppCompatActivity {
    Button login,signup;
    EditText username,password;
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://fitnessgok-default-rtdb.europe-west1.firebasedatabase.app/");
    DatabaseReference myRef = database.getReference("Users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      login=findViewById(R.id.LoginButton);
      signup=findViewById(R.id.Signup);

      username=findViewById(R.id.Username);
      password=findViewById(R.id.editTextTextPassword);





      signup.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(MainActivity.this,Signup.class);
              startActivity(intent);
          }
      });
      login.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String usernametext=username.getText().toString();
              String passwordtext=password.getText().toString();
               if(usernametext.isEmpty() || passwordtext.isEmpty()){
                   Toast.makeText(MainActivity.this, "Please fill empty field", Toast.LENGTH_SHORT).show();
               }
               else{
                   myRef.addValueEventListener(new ValueEventListener() {
                       @Override
                       public void onDataChange(DataSnapshot dataSnapshot) {
                           List<User> list = new ArrayList<>();
                           boolean check =true;
                           for(DataSnapshot ds : dataSnapshot.getChildren()) {
                               User us =new User();

                               us=ds.getValue(User.class);
                            if(us.getUsername().contentEquals(usernametext) && us.getPassword().contentEquals(passwordtext)){
                                 check=false;
                                Intent intent = new Intent(MainActivity.this,UserUIMain.class);
                                intent.putExtra("UUID", us.getId());
                                startActivity(intent);
                            }
                           }
                           if(check==true){
                               Toast.makeText(MainActivity.this, "Users are not found please try again", Toast.LENGTH_SHORT).show();
                           }


                       }

                       @Override
                       public void onCancelled(DatabaseError error) {
                           // Failed to read value
                           Log.w(TAG, "Failed to read value.", error.toException());
                       }
                   });
               }
          }
      });
    }
}