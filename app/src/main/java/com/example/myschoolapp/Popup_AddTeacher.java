package com.example.myschoolapp;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Popup_AddTeacher {



    public void showPopupWindow(final View view) {


        //Create a View object yourself through inflater
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);

        View popupView = inflater.inflate(R.layout.popwindowfor_addteacher, null);

        //Specify the length and width through constants
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        //Make Inactive Items Outside Of PopupWindow
        boolean focusable = true;

        //Create a window with our parameters
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        //Set the location of the window on the screen
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        //Initialize the elements of our window, install the handler

        final TextInputEditText textname = popupView.findViewById(R.id.Inputname);
        final TextInputEditText textemail=popupView.findViewById(R.id.Inputemail);
        final TextInputEditText textnumber=popupView.findViewById(R.id.InputId);

        Button buttonSave = popupView.findViewById(R.id.add);
        Button buttonCancel=popupView.findViewById(R.id.cancel);


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String name=textname.getText().toString();
                // String email=textemail.getText().toString();
                // String number=textnumber.getText().toString();
                //  addStudent.applyDetails(name,email,number);
                //As an example, display the message

                Toast.makeText(view.getContext(), "Wow, popup action button", Toast.LENGTH_SHORT).show();

            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });



        //Handler for clicking on the inactive zone of the window

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //Close the window when clicked
                popupWindow.dismiss();
                return true;
            }
        });



    }


}