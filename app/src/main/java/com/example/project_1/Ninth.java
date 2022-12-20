package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Ninth extends AppCompatActivity {
    Button b1;
    RadioButton r1,r2,r3,r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninth);
        b1=(Button) findViewById(R.id.button27);
        r1=(RadioButton) findViewById(R.id.radioButton13);
        r2=(RadioButton) findViewById(R.id.radioButton14);
        r3=(RadioButton) findViewById(R.id.radioButton15);
        r4=(RadioButton) findViewById(R.id.radioButton16);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r1.isChecked()){
                    ++Seventh.score;
                }
                Intent t=new Intent(Ninth.this,Tenth.class);
                startActivity(t);
                finish();
            }
        });
    }
}