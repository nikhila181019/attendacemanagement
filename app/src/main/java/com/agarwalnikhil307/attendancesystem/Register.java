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

public class Register extends AppCompatActivity {
    EditText namee,emaill,passwordd,phonee;
    Button Registerbtn;
    TextView loginbtn;
    FirebaseAuth fauth;
    ProgressBar progressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       namee=findViewById(R.id.Name);
       emaill=findViewById(R.id.EmailAddress);
       passwordd=findViewById(R.id.editPassword);
       phonee=findViewById(R.id.Phone);
       Registerbtn=findViewById(R.id.button3);
       loginbtn=findViewById(R.id.AlreadyReg);

       fauth=FirebaseAuth.getInstance();
       progressbar=findViewById(R.id.progressBar);

       if(fauth.getCurrentUser() !=null)
       {
           startActivity(new Intent(getApplicationContext(),Login.class));
           finish();
       }

       Registerbtn.setOnClickListener(new View.OnClickListener() {
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
// REGISTER THE USER IN FIREBASE
               fauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful() ){
                           Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                      startActivity(new Intent(getApplicationContext(),Login.class));
                       }
                       else
                       {
                           Toast.makeText(Register.this, "Error!", Toast.LENGTH_SHORT).show();
                           progressbar.setVisibility(View.GONE);

                       }
                   }
               });
           }
       });
         loginbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(getApplicationContext(),Login.class));
             finish();
             }
         });

    }
}