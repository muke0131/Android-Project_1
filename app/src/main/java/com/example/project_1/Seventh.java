package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Seventh extends AppCompatActivity {
    Button b1,b2;
    RadioButton r1,r2,r3,r4;
    static int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);
        b1=(Button) findViewById(R.id.button24);
        b2=(Button) findViewById(R.id.button23);
        r1=(RadioButton) findViewById(R.id.radioButton);
        r2=(RadioButton) findViewById(R.id.radioButton2);
        r3=(RadioButton) findViewById(R.id.radioButton3);
        r4=(RadioButton) findViewById(R.id.radioButton4);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(Seventh.this,Third.class);
                startActivity(r);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score=0;
                if(r4.isChecked()){
                    ++score;
                }
                Intent q=new Intent(Seventh.this,Eighth.class);
                startActivity(q);
                finish();
            }
        });
    }
}