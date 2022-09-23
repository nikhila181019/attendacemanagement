package com.agarwalnikhil307.attendancesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText emaill,passwordd;
    Button Loginbtnn;
    TextView Createbtnn;
    ProgressBar progressbar;
    FirebaseAuth fauth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emaill=findViewById(R.id.Email);
        passwordd=findViewById(R.id.Password);
        progressbar=findViewById(R.id.progressBar2);
        fauth=FirebaseAuth.getInstance();
        Loginbtnn=findViewById(R.id.button2);
        Createbtnn=findViewById(R.id.Donthaveaccount);

        Loginbtnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emaill.getText().toString().trim();
                String password=passwordd.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    emaill.setError("Email is empty");
                }
                if(TextUtils.isEmpty(password))
                {
                    passwordd.setError("Password is empty");
                }
                if(password.length()<6)
                {
                    passwordd.setError("Password Must Be Greater Than 6 Character");
                    return;
                }

                progressbar.setVisibility(View.VISIBLE);

                //authetication the user

                fauth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else
                        {
                            Toast.makeText(Login.this, "Email or Password is invalid", Toast.LENGTH_SHORT).show();
                        progressbar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });


      Createbtnn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(new Intent(getApplicationContext(),Register.class));
          }
      });
    }



}