package com.example.mylibrary;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Iterator;

public class book2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book2);
        loginUser loginuser = (loginUser) getApplication();

        Button emptySeatbutton = (Button) findViewById(R.id.emptySeat);
        emptySeatbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //대화상자 생성//
                AlertDialog.Builder builder = new AlertDialog.Builder(book2Activity.this);

                builder.setTitle("자리 발권");            //setTitle -> 제목설정
                builder.setMessage("24번 자리를 발권하시겠습니까?");         //setMessage -> 내용입력
                builder.setIcon(R.mipmap.ic_launcher);    //setIcon -> 아이콘 설정

                //  setPositiveButton -> "OK"버튼  //
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(book2Activity.this, "발권 되었습니다.", Toast.LENGTH_SHORT).show();
                        loginuser.setSeat(224);
                        Intent intent = new Intent(getApplicationContext(), firstActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

                //  setNegativeButton -> "Cancel" 버튼  //
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(book2Activity.this, "취소 되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();      //대화상자(dialog)화면 출력
            }
        });

        Button fullSeatbutton = (Button) findViewById(R.id.fullSeat);
        fullSeatbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), rvActivity.class);
                startActivity(intent);
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}