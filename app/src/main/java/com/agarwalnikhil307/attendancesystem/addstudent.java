package com.agarwalnikhil307.attendancesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class addstudent extends AppCompatActivity {
    public EditText mname,muid,mclass;
    public Button button;

    public FirebaseDatabase db=FirebaseDatabase.getInstance();
    public DatabaseReference root=db.getReference().child("Users");



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);

        mname=findViewById(R.id.studentname);
        muid=findViewById(R.id.studentuid);
        mclass=findViewById(R.id.studentclass);
        button=findViewById(R.id.add);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=mname.getText().toString();
                String uid=muid.getText().toString();
                String classs=mclass.getText().toString();

                HashMap<String,String>userMap=new HashMap<>();
                userMap.put("Name",name);
                userMap.put("UID",uid);
                userMap.put("Class",classs);

                Toast.makeText(addstudent.this, "Student Added", Toast.LENGTH_SHORT).show();

                root.setValue(userMap);


            }
        });
    }
}