package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Third extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        b1=(Button) findViewById(R.id.button3);
        b2=(Button) findViewById(R.id.button6);
        b3=(Button) findViewById(R.id.button7);
        b4=(Button) findViewById(R.id.button9);
        b5=(Button) findViewById(R.id.button8);
        b6=(Button) findViewById(R.id.button10);
        firebaseAuth=FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(Third.this,Fourth.class);
                startActivity(a);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b=new Intent(Third.this,Fifth.class);
                startActivity(b);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c=new Intent(Third.this,Sixth.class);
                startActivity(c);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d=new Intent(Third.this,Seventh.class);
                startActivity(d);
                finish();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e=new Intent(Third.this,Thirteen.class);
                startActivity(e);
                finish();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Intent f=new Intent(Third.this,MainActivity.class);
                startActivity(f);
                finish();
            }
        });
    }

}