package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Tenth extends AppCompatActivity {
    Button b1;
    RadioButton r1,r2,r3,r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth);
        b1=(Button) findViewById(R.id.button28);
        r1=(RadioButton) findViewById(R.id.radioButton17);
        r2=(RadioButton) findViewById(R.id.radioButton18);
        r3=(RadioButton) findViewById(R.id.radioButton19);
        r4=(RadioButton) findViewById(R.id.radioButton20);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r2.isChecked()){
                    ++Seventh.score;
                }
                Intent u=new Intent(Tenth.this,Eleventh.class);
                startActivity(u);
                finish();
            }
        });
    }
}