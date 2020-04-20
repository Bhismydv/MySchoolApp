package com.example.myschoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class PopUpSubject extends AppCompatActivity {

    EditText inputsubject,inputteacherId,inputdesc;

    Button buttonAddSubject,buttonCancel;

    DatabaseReference databaseRef;
    Study study;

    RecyclerView recyclerView;

    ArrayList<Study> list;

    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_subject);


        databaseRef= FirebaseDatabase.getInstance().getReference().child("Study");
        study=new Study();

        inputdesc=findViewById(R.id.inputdescription);

        inputsubject=findViewById(R.id.inputsubject);

        inputteacherId=findViewById(R.id.inputidteacher);

        buttonAddSubject=findViewById(R.id.addSubject);

        buttonCancel=findViewById(R.id.subcancel);

        recyclerView=findViewById(R.id.subjRecycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<Study>();


        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
    Study p=dataSnapshot1.getValue(Study.class);

    list.add(p);

}
adapter=new MyAdapter(PopUpSubject.this,list);
recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                String errormessage=databaseError.getMessage();

                Log.d("Error",errormessage);
                Toast.makeText(PopUpSubject.this, "Something is wrong", Toast.LENGTH_SHORT).show();

            }
        });


        buttonAddSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String teacherId=inputteacherId.getText().toString();
                String subject=inputsubject.getText().toString();
                String desc=inputdesc.getText().toString();

                study.setDesc(desc);
                study.setSubject(subject);
                study.setTeacherid(teacherId);

                databaseRef.push().setValue(study);


                Toast.makeText(PopUpSubject.this, "success!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Subjects.class));
            }
        });
    }
}
