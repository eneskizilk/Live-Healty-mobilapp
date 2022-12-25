package com.example.gokfitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

public class Signup extends AppCompatActivity {
   Button Register,back;
   EditText username,password,confirmpass;
    FirebaseDatabase firebaseDatabase;
   static int cheack =0;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Register=findViewById(R.id.Register);
        back=findViewById(R.id.Back);

        username=findViewById(R.id.usernameedit);
        password=findViewById(R.id.PasswordReq);
        confirmpass=findViewById(R.id.ConfirmPassword);
back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Signup.this,MainActivity.class);
        startActivity(intent);
    }
});
Register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String name=username.getText().toString();
        String pass1=password.getText().toString();
        String pass2=confirmpass.getText().toString();
        if(name.isEmpty() ||pass1.isEmpty() ||pass2.isEmpty()){
            Toast.makeText(Signup.this, "Please fill empty field", Toast.LENGTH_SHORT).show();
        }
        if(pass1.contentEquals(pass2)){
            FirebaseDatabase database = FirebaseDatabase.getInstance("https://fitnessgok-default-rtdb.europe-west1.firebasedatabase.app/");
            DatabaseReference myRef = database.getReference("Users");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot ds : snapshot.getChildren()) {
                        User us = new User();
                        us = ds.getValue(User.class);
                        if(us.getUsername().contentEquals(name)){
                            cheack=1;

                            System.out.println("burassıııı");
                            break;
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            if(cheack==0){
                UUID uuid = UUID.fromString(UUID.randomUUID().toString());
                User user=new User(uuid,name,pass1);

                myRef.child(String.valueOf(uuid)).setValue(user);
                Toast.makeText(Signup.this, "created account "+user.getUsername(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Signup.this,UserUIMain.class);
                intent.putExtra("UUID", uuid);
                startActivity(intent);
            }
            else if(cheack==1){
                Toast.makeText(Signup.this, "account already exist please try again", Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(Signup.this, "Passwords are not equal", Toast.LENGTH_SHORT).show();
        }
    }
});
    }
}