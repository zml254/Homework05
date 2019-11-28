package com.example.homework;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private TextView user;
    private TextView password;

    private SharedPreferences live;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        user = (TextView)findViewById(R.id.user_name);
        password = (TextView)findViewById(R.id.password);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        live = getSharedPreferences("data",MODE_PRIVATE);
        Button login = (Button)findViewById(R.id.login_in);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(live.getString("user1","").equals(user.getText().toString())
                        &&live.getString("password1","")
                        .equals(password.getText().toString())){
                    Toast.makeText(LoginActivity.this,
                            "登陆成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,
                            DisplayActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this,
                            "登陆失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ImageView back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }
}
