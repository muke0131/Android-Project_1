package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Eleventh extends AppCompatActivity {
    Button b1;
    RadioButton r1,r2,r3,r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleventh);
        b1=(Button) findViewById(R.id.button25);
        r1=(RadioButton) findViewById(R.id.radioButton5);
        r2=(RadioButton) findViewById(R.id.radioButton6);
        r3=(RadioButton) findViewById(R.id.radioButton7);
        r4=(RadioButton) findViewById(R.id.radioButton8);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r1.isChecked()){
                    ++Seventh.score;
                }
                Intent w=new Intent(Eleventh.this,Twelfth.class);
                startActivity(w);
                finish();
            }
        });
    }
}