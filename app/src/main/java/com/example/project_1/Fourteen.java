package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class Fourteen extends AppCompatActivity {
    CountryCodePicker ccp;
    EditText e1;
    Button b1,b2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourteen);
        e1=(EditText) findViewById(R.id.editText10);
        b1=(Button) findViewById(R.id.button8);
        b2=(Button) findViewById(R.id.button32);
        ccp=(CountryCodePicker) findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(e1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().length()!=10){
                    Toast.makeText(Fourteen.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent=new Intent(Fourteen.this,Fifteen.class);
                    intent.putExtra("mobile",ccp.getFullNumberWithPlus().trim());
                    startActivity(intent);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(Fourteen.this,MainActivity.class);
                startActivity(intent2);
                finish();
            }
        });
    }
}