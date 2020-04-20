package com.example.myschoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import java.util.List;

public class PopUpStudent extends AppCompatActivity {
    private EditText inputName, inputEmail,inputId;
    Button Add,Cancel;
    private DatabaseReference databaseReference;
    User user;

    RecyclerView recyclerView;
    ArrayList<User> list;

    MyStudent adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_student);


      user=new User();
      databaseReference=FirebaseDatabase.getInstance().getReference().child("User");

        inputEmail = findViewById(R.id.Inputemail);
        inputName = findViewById(R.id.Inputname);
        inputId=findViewById(R.id.inputId);
        Add = findViewById(R.id.addsutdent);
        Cancel=findViewById(R.id.stucancel);

        recyclerView=findViewById(R.id.stuRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<User>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                    User p = dataSnapshot1.getValue(User.class);

                    list.add(p);
                }

                adapter=new MyStudent(PopUpStudent.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(PopUpStudent.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });



        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id=inputId.getText().toString();
                String Teachername=inputName.getText().toString();
                String email=inputEmail.getText().toString();

                user.setEmail(email);
                user.setName(Teachername);
                user.setRollno(id);

                databaseReference.push().setValue(user);

                Toast.makeText(PopUpStudent.this, "success!", Toast.LENGTH_SHORT).show();
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Student.class));
            }
        });
    }




}