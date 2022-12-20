package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Twelfth extends AppCompatActivity {
    TextView t1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twelfth);
        b1=(Button) findViewById(R.id.button29);
        t1=(TextView) findViewById(R.id.textView10);
        t1.setText("Your Score is:"+Seventh.score);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x=new Intent(Twelfth.this,Third.class);
                startActivity(x);
                finish();
            }
        });
    }
}