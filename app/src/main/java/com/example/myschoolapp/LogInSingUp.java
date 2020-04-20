package com.example.myschoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.animation.Animator;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInSingUp extends AppCompatActivity {

    FirebaseAuth auth;
   // ProgressDialog progressDialog;

TextInputEditText editTextEmail;
TextInputEditText editTextPassword;

    private ImageView bookIconImageView;

    private TextView bookITextView,textSignup;

    private ProgressBar loadingProgressBar;

    private ConstraintLayout rootView, afterAnimationView;

    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.login_signup);
     //   progressDialog=new ProgressDialog(getApplicationContext());

        auth=FirebaseAuth.getInstance();



        initView();

        new CountDownTimer(2000,1000){
            @Override
            public void onTick(long millisUntilFinished) {

            }


            @Override
            public void onFinish() {
                bookITextView.setVisibility(View.GONE);

                loadingProgressBar.setVisibility(View.GONE);

                rootView.setBackgroundColor(ContextCompat.getColor(LogInSingUp.this,R.color.colorSplashText1));

                bookIconImageView.setImageResource(R.drawable.school_logo);
                startAnimation();
            }
        }.start();


    }

    private void initView() {

        bookIconImageView=findViewById(R.id.bookIconImageView);
        bookITextView=findViewById(R.id.bookITextView);
        loadingProgressBar=findViewById(R.id.loadingProgressBar);
        rootView=findViewById(R.id.rootView);
        signIn=findViewById(R.id.signin);
        textSignup=findViewById(R.id.signuptxt);
        editTextEmail=findViewById(R.id.emaillogin);
        editTextPassword=findViewById(R.id.passwordlogin);



        afterAnimationView=findViewById(R.id.afterAnimationView);
    }

    private void startAnimation() {
        ViewPropertyAnimator viewPropertyAnimator = bookIconImageView.animate();
        viewPropertyAnimator.x(50f);
        viewPropertyAnimator.y(100f);
        viewPropertyAnimator.setDuration(1000);
        viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                afterAnimationView.setVisibility(View.VISIBLE);
                bookIconImageView.setVisibility(View.INVISIBLE);

//afterAnimationView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mEmail=editTextEmail.getText().toString();
                String mPassword=editTextPassword.getText().toString();

                if(mEmail.isEmpty()){
                    editTextEmail.setError("Required Field");
                    return;
                }
                if(mPassword.isEmpty()){
                    editTextPassword.setError("Required Field");
                    return;
                }
             //   progressDialog.setMessage("Processing");
//                progressDialog.show();


                auth.signInWithEmailAndPassword(mEmail,mPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                           // progressDialog.dismiss();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            Toast.makeText(getApplicationContext(), "Log in Complete", Toast.LENGTH_SHORT).show();
                            finish();

                        }
                        else{
                           // progressDialog.dismiss();
                            String errormessage=task.getException().getMessage();
                            Toast.makeText(getApplicationContext(), "UserName OR Password Wrong!  " +errormessage , Toast.LENGTH_LONG).show();
                        }
                    }
                });
            //    startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });


        textSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser student=auth.getCurrentUser();


        if (student !=null){

            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
    }
}
