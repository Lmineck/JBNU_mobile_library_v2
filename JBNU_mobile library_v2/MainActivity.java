package com.example.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        EditText idEditText = (EditText) findViewById(R.id.loginText);
        EditText pwEditText = (EditText) findViewById(R.id.passwordText);

        DataAdapter mDbHelper = new DataAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        userList = mDbHelper.getTableData();

        Button loginbutton = (Button) findViewById(R.id.loginButton);
        loginbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                int collect = 0;
                Iterator<User> iterator = userList.iterator();
                while (iterator.hasNext()) {
                    User user = iterator.next();
                    if(idEditText.getText().toString().equals(user.getID()) && pwEditText.getText().toString().equals(user.getPwd()))
                    {
                        loginUser loginuser = (loginUser) getApplication();
                        loginuser.setId(user.getID());
                        loginuser.setPwd(user.getPwd());
                        loginuser.setName(user.getName());
                        loginuser.setClass(user.getClasses());
                        loginuser.setSeat(user.getSeat());
                        Intent intent = new Intent(getApplicationContext(), firstActivity.class);
                        startActivity(intent);
                        collect = 1;
                    }
                }
                if(collect == 0) Toast.makeText(getApplicationContext(), "학번, 비밀번호가 틀립니다", Toast.LENGTH_SHORT).show();
            }
        });
    }
}