package com.example.sdie3.edcan_project;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        EditText userId;
        EditText userPassword;
        Button login;
        Button signUp;
        SharedPreferences preff;
        ArrayList<memberInfo> members = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            userId = findViewById(R.id.userId);
            preff = getSharedPreferences("members", MODE_PRIVATE);
            userPassword = findViewById(R.id.userPassword);
            login = findViewById(R.id.loginButton);
            signUp = findViewById(R.id.signUpButton);
            Log.v("실행", "정상적실행");
            if (myGetSharedPreferences() != null) {
                members.addAll(myGetSharedPreferences());
            }
        }

    public void loginOnClick(View v) {
        String idText = userId.getText().toString();
        String passwordText = userPassword.getText().toString();
        int flag = 0;
        Log.v("실행", "로그인 버튼 정상적실행");
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(idText) && members.get(i).getPassword().equals(passwordText)) {
                flag = 1;
                Log.e("asdf","실행됨");
                startActivity(new Intent(MainActivity.this, MenuActivity.class));
            }
        }
        if (flag == 0) {
            Toast.makeText(this, "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    public void SignUpOnClick(View V) {
        Log.v("실행", "회원가입 버튼 정상적실행");
        startActivityForResult(new Intent(MainActivity.this, SignUpActivity.class), 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent member) {
        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {
                members.add((memberInfo) member.getSerializableExtra("member"));
                saveMemberInfo(members);
            }
        }
        super.onActivityResult(requestCode, resultCode, member);
    }

    public ArrayList<memberInfo> myGetSharedPreferences() {
        return new Gson().fromJson(preff.getString("member", ""), new TypeToken<ArrayList<memberInfo>>() {
        }.getType());
    }


    public void saveMemberInfo(ArrayList<memberInfo> M) {
        SharedPreferences.Editor editor = preff.edit();
        Gson gson = new Gson();
        editor.putString("member", gson.toJson(M));
        editor.commit();
    }
}
