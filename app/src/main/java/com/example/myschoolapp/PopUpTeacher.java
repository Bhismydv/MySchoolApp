package com.example.myschoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;

public class PopUpTeacher extends AppCompatActivity {

    EditText inputname,inputemail,inputid;
    Button buttonAddTeacher,buttonCancel;

    DatabaseReference reference;
    Member member;

    RecyclerView recyclerView;
    ArrayList<Member> list;

    MyTeacher adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_teacher);

        member=new Member();
        reference= FirebaseDatabase.getInstance().getReference().child("Member");


        inputemail=findViewById(R.id.inputemail);
        inputid=findViewById(R.id.inputId);
        inputname=findViewById(R.id.inputname);

        buttonAddTeacher=findViewById(R.id.addTeacher);

        buttonCancel=findViewById(R.id.teacancel);

        recyclerView=findViewById(R.id.teacher_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<Member>();



        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                   Member p=dataSnapshot1.getValue(Member.class);

                    list.add(p);

                }
                adapter=new MyTeacher(PopUpTeacher.this,list);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(PopUpTeacher.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });

        buttonAddTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String teachername=inputname.getText().toString();
                String teacheremail=inputemail.getText().toString();
               String teacherid=inputid.getText().toString();

                member.setName(teachername);
                member.setEmail(teacheremail);
                member.setId(teacherid);

                reference.push().setValue(member);


                Toast.makeText(PopUpTeacher.this, "Success!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Teachers.class));
            }
        });


    }
}
