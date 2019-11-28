package com.example.homework;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        TextView textView = findViewById(R.id.register);
        textView.setOnClickListener(this);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.button2:case R.id.button3:case R.id.button4:
                Intent login_user = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(login_user);
                break;
            case R.id.register:
                Intent register = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(register);
            default:
                break;
        }
    }
}
