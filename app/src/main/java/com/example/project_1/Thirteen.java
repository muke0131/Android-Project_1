package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Thirteen extends AppCompatActivity {
    Button b1;
    ImageButton ib1, ib2, ib3, ib4;
    WifiManager wm;
    BluetoothAdapter ba;
    CameraManager cm;
    Vibrator v1;
//    private boolean wifi = false;
    private boolean c = false;

    @SuppressLint({"MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirteen);
        b1 = (Button) findViewById(R.id.button34);
        ib1 = (ImageButton) findViewById(R.id.imageButton8);
        ib2 = (ImageButton) findViewById(R.id.imageButton7);
        ib3 = (ImageButton) findViewById(R.id.imageButton6);
        ib4 = (ImageButton) findViewById(R.id.imageButton5);
        wm = (WifiManager)this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        ba = BluetoothAdapter.getDefaultAdapter();
        cm = (CameraManager) getSystemService(CAMERA_SERVICE);
        v1 = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y = new Intent(Thirteen.this, Third.class);
                startActivity(y);
                finish();
            }
        });
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!wm.isWifiEnabled()) {
                    wm.setWifiEnabled(true);
                    ib1.setImageResource(R.drawable.c);
                } else {
                    wm.setWifiEnabled(false);
                    ib1.setImageResource(R.drawable.f);
                }
            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (ActivityCompat.checkSelfPermission(Thirteen.this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                        if (!ba.isEnabled()) {
                            ba.enable();
                            ib2.setImageResource(R.drawable.d);
                        }
                        else{
                            ba.disable();
                            ib2.setImageResource(R.drawable.e);
                        }
                        return;
                    }
            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c==false){
                    try{
                        String id=cm.getCameraIdList()[0];
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            cm.setTorchMode(id,true);
                            c=true;
                            ib3.setImageResource(R.drawable.b);
                        }
                    }
                    catch (CameraAccessException e){

                    }
                }
                else{
                    try{
                        String id=cm.getCameraIdList()[0];
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            cm.setTorchMode(id,false);
                            c=false;
                            ib3.setImageResource(R.drawable.a);
                        }
                    }
                    catch (CameraAccessException e){

                    }
                }
            }
        });
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>26){
                    v1.vibrate(VibrationEffect.createOneShot(150,10));
                }
                else{
                    v1.vibrate(150);
                }
            }
        });
    }
}