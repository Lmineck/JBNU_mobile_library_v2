package com.example.mylibrary;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class firstActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginUser loginuser = (loginUser) getApplication();
        TextView mnameview = (TextView) findViewById(R.id.nameView);
        TextView mnumView = (TextView) findViewById(R.id.numView);
        TextView mclassView = (TextView) findViewById(R.id.classView);
        TextView mseatView = (TextView) findViewById(R.id.useView);
        mnameview.setText(loginuser.getName());
        mnumView.setText(loginuser.getID());
        mclassView.setText(loginuser.getClasses());
        if(loginuser.getSeat() == 0)
        {
            mseatView.setText("이용중인 좌석이 없습니다");
        }
        else
        {
            if(loginuser.getSeat() > 1000)
            {
                mseatView.setText("예약중 : 제 " + loginuser.getSeat()/1000 + "열람실, " + loginuser.getSeat()%100 + "번 자리");
            }
            else{
                mseatView.setText("제 " + loginuser.getSeat()/100 + "열람실, " + loginuser.getSeat()%100 + "번 자리");
            }
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button loginbutton = (Button) findViewById(R.id.button2);
        loginbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), seatmActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}