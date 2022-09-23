package com.agarwalnikhil307.attendancesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void loginnn(View view) {
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);

    }

    public void registerr(View view) {
        Intent intent=new Intent(this,Register.class);
        startActivity(intent);

    }
}