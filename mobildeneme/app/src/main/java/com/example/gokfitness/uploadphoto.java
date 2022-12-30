package com.example.gokfitness;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class uploadphoto extends AppCompatActivity {
  //  String id = getIntent().getStringExtra("UUID");
    RecyclerViewadapter recyclerViewadapter;
    RecyclerView recyclerView;
    ArrayList<String> stringArrayList;
    ImageView addphoto;
    Uri imageuri;
    ArrayList<Uri> imagelist;
    Button selectph,uploadph;
    FirebaseStorage storage;
    StorageReference storageReference;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageuri =data.getData();
        addphoto.setImageURI(imageuri);
        imagelist.add(imageuri);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadphoto);
        imagelist =new ArrayList<>();
        stringArrayList =new ArrayList<>();
        addphoto=findViewById(R.id.firebaseimage);
        selectph=findViewById(R.id.selectphoto);
        uploadph=findViewById(R.id.uploadphoto);
        recyclerView=findViewById(R.id.imagedatabase);
        recyclerViewadapter=new RecyclerViewadapter(this,stringArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewadapter);

        FirebaseStorage database = FirebaseStorage.getInstance();
        StorageReference storageRef =
                FirebaseStorage.getInstance().getReference();
        storageRef.child("Images/Users").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        stringArrayList.add(String.valueOf(uri));
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });





        selectph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(uploadphoto.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();

            }

        });


        SimpleDateFormat formatter= new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CANADA);
        Date now=new Date();
        String datename=formatter.format(now);

        storageReference = FirebaseStorage.getInstance().getReference("Images/"+"Users/"+UUID.randomUUID().toString()+"/"+datename+"/");
       // StorageReference ref = storageReference.child("Users/"+"Images/"+ UUID.randomUUID().toString());
        uploadph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    storageReference.putFile(imageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            addphoto.setImageURI(null);
                            Toast.makeText(uploadphoto.this, "Photo successfully uploaded", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                }catch (Exception ex){
                    System.out.println("select photo");
                    Toast.makeText(uploadphoto.this, "Please select photo", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}