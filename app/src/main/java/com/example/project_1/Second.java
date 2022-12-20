package com.example.project_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Second extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    Button b1,b2;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        e1=(EditText) findViewById(R.id.editText3);
        e2=(EditText) findViewById(R.id.editText4);
        e3=(EditText) findViewById(R.id.editText5);
        e4=(EditText) findViewById(R.id.editText6);
        e5=(EditText) findViewById(R.id.editText7);
        b1=(Button) findViewById(R.id.button4);
        b2=(Button) findViewById(R.id.button5);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l=new Intent(Second.this,MainActivity.class);
                startActivity(l);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e4.getText().toString();
                String s5=e5.getText().toString();
                if(s1.isEmpty()){
                    e1.setError("Enter Valid Username");
                }
                else if(s2.isEmpty()){
                    e2.setError("Enter Valid Password");
                }
                else{
                    firebaseAuth.createUserWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Second.this, "Registered!", Toast.LENGTH_SHORT).show();
                                Intent k=new Intent(Second.this,MainActivity.class);
                                startActivity(k);
                                finish();
                            }
                            else{
                                Toast.makeText(Second.this, "Error!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    databaseReference=firebaseDatabase.getReference("Users");
                    Users users=new Users(s3,s4,s5);
                    databaseReference.child(s5).setValue(users);
                    Toast.makeText(Second.this, "Database Updated", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}