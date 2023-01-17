package com.example.mylibrary;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Iterator;

public class rvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);

        loginUser loginuser = (loginUser) getApplication();
        TextView time16Txt = (TextView) findViewById(R.id.time16);
        TextView time17Txt = (TextView) findViewById(R.id.time17);
        TextView time18Txt = (TextView) findViewById(R.id.time18);

        time16Txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time16Txt.setText("16 : 00 예약 불가능");
                time16Txt.setBackgroundColor(Color.parseColor("#d3d3d3"));
                time16Txt.setTextColor(Color.parseColor("#9B111E"));
                Toast.makeText(getApplicationContext(), "발권되었습니다", Toast.LENGTH_SHORT).show();
                loginuser.setSeat(2034);
            }
        });

        time17Txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time17Txt.setText("17 : 00 예약 불가능");
                time17Txt.setBackgroundColor(Color.parseColor("#d3d3d3"));
                time17Txt.setTextColor(Color.parseColor("#9B111E"));
                Toast.makeText(getApplicationContext(), "발권되었습니다", Toast.LENGTH_SHORT).show();
                loginuser.setSeat(2034);
            }
        });

        time18Txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time18Txt.setText("18 : 00 예약 불가능");
                time18Txt.setBackgroundColor(Color.parseColor("#d3d3d3"));
                time18Txt.setTextColor(Color.parseColor("#9B111E"));
                Toast.makeText(getApplicationContext(), "발권되었습니다", Toast.LENGTH_SHORT).show();
                loginuser.setSeat(2034);
            }
        });

        Button loginbutton = (Button) findViewById(R.id.exitbutton);
        loginbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), firstActivity.class);
                startActivity(intent);
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}