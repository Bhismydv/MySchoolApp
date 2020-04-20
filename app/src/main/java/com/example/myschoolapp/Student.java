package com.example.myschoolapp;

import android.app.Person;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.textfield.TextInputEditText;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import java.util.ArrayList;

public class Student extends AppCompatActivity {


TextView mainTxt;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student);



        Button buttonAddStudent = findViewById(R.id.button_addStudent);

        mainTxt=findViewById(R.id.mainstu);


        buttonAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               startActivity(new Intent(Student.this,PopUpStudent.class));

            //  Popup_AddStudent popup_addStudent = new Popup_AddStudent();

              //  popup_addStudent.showPopupWindow(v);


            }
        });

        mainTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });



        /*
StudentData john=new StudentData("John","John@gmail.com","707851866");
StudentData shen=new StudentData("Shen","Shen@gmail.com","707851866");
StudentData mey=new StudentData("Mey","Mey@gmail.com","707851866");
StudentData peter=new StudentData("Peter","Peter@gmail.com","707851866");
StudentData tony=new StudentData("Tony","Tony@gmail.com","707851866");
StudentData steve=new StudentData("Steve","Steve@gmail.com","707851866");
StudentData vision=new StudentData("Vision","Vision@gmail.com","707851866");


ArrayList<StudentData> studentData=new ArrayList<>();
studentData.add(john);
        studentData.add(steve);
        studentData.add(mey);
        studentData.add(peter);
        studentData.add(vision);
        studentData.add(tony);
studentData.add(shen);

StudentAdapter adapter=new StudentAdapter(this,R.layout.list_adapter,studentData);
listView.setAdapter(adapter);


        //     listView = (ListView) findViewById(R.id.list_student);
     //  listItems = new ArrayList<String>();


     //  adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,listItems);
     //  listView.setAdapter(adapter);

      //  listItems.add("a");
       // listItems.add("b");
        //listItems.add("c");
        //listItems.add("d");
        //listItems.add("e");



         */




    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK)
            Toast.makeText(getApplicationContext(), "back press",
                    Toast.LENGTH_LONG).show();

        return false;
        // Disable back button..............
    }


}