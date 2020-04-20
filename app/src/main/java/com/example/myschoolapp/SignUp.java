package com.example.myschoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
Button signupButton;
TextInputEditText editTextEmail,editTextPassword;

    FirebaseAuth firebaseAuth;

    //ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupButton=findViewById(R.id.signup);

        editTextEmail=findViewById(R.id.emailsignup);

        editTextPassword=findViewById(R.id.passwordsignup);

        firebaseAuth=FirebaseAuth.getInstance();

       // dialog=new ProgressDialog(this);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rEmail=editTextEmail.getText().toString();

                String rPassword=editTextPassword.getText().toString();


                if(TextUtils.isEmpty(rEmail)){
                    editTextEmail.setError("Required Field");
                    return;
                }
                if(TextUtils.isEmpty(rPassword)){
                    editTextPassword.setError("Required Field");
                    return;
                }


               // dialog.setMessage("Processing");
             //   dialog.show();

                firebaseAuth.createUserWithEmailAndPassword(rEmail,rPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                          //  dialog.dismiss();

                            startActivity(new Intent(getApplicationContext(),LogInSingUp.class));
                            Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();

                            finish();
                        }
                        else{
                          //  dialog.dismiss();
                            String errormessage=task.getException().getMessage();
                            Toast.makeText(getApplicationContext(), "Fail " + errormessage, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                //Intent intent=new Intent(getApplicationContext(),LogInSingUp.class);
               // startActivity(intent);
            }
        });
    }
}
