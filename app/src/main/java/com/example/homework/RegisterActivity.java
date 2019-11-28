package com.example.homework;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText password;

    private EditText username;

    boolean judgement;

    String content1;

    String content2;

    SharedPreferences.Editor user;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        user = getSharedPreferences("data",MODE_PRIVATE).edit();
        username = (EditText)findViewById(R.id.user_name);
        password = (EditText)findViewById(R.id.password);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏输入的字符串
        content1 = username.getText().toString();
        content2 = password.getText().toString();
        judgement = judge(content1,content2);
        ImageView back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
        Button register = (Button)findViewById(R.id.button1);
        register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(judgement){
                    Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    user.putString("user"+1,username.getText().toString());
                    user.putString("password"+1,password.getText().toString());
                    user.apply();
                    finish();
                }
                else{
                    Toast.makeText(RegisterActivity.this,
                            "用户名必须有4-12位，密码必须在8-16位之间", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean judge(String content1,String content2){
        if(/*content1.length()>=4&&content1.length()<=12&&content2.length()>=8&&content2.length()<=16*/true){
            return true;
        }
        return false;
    }
}
