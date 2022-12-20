package com.example.project_1;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Fifteen extends AppCompatActivity {
    EditText e1;
    Button b1,b2;
    String phone;
    String otp;
    FirebaseAuth firebaseAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifteen);
        phone=getIntent().getStringExtra("mobile".toString());
        e1=(EditText) findViewById(R.id.editText11);
        b1=(Button) findViewById(R.id.button30);
        b2=(Button) findViewById(R.id.button33);
        firebaseAuth=FirebaseAuth.getInstance();
        genotp();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(Fifteen.this,Fourteen.class);
                startActivity(intent2);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().isEmpty()){
                    Toast.makeText(Fifteen.this, "Blank Field!", Toast.LENGTH_SHORT).show();
                }
                else if(e1.getText().toString().length()!=6){
                    Toast.makeText(Fifteen.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                }
                else {
                    PhoneAuthCredential credential=PhoneAuthProvider.getCredential(otp,e1.getText().toString());
                    signInWithPhoneAuthCredential(credential);
                }
            }
        });
    }
    private void genotp()
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otp=s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(Fifteen.this, "Wrong OTP", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Fifteen.this, "Database Updated", Toast.LENGTH_SHORT).show();
                    Intent intent2=new Intent(Fifteen.this,Third.class);
                    startActivity(intent2);
                    finish();
                }
                else {
                    Toast.makeText(Fifteen.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}