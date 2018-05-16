package com.example.sdie3.edcan_project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

/**
 * Created by sdie3 on 2018-05-03.
 */

public class SignUpActivity extends AppCompatActivity {
    EditText sId;
    EditText sName;
    EditText pw;
    EditText rePw;
    SharedPreferences pref;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        sName = findViewById(R.id.signName);
        sId = findViewById(R.id.signId);
        pw = findViewById(R.id.signPw);
        rePw = findViewById(R.id.signRePw);
        pref = getSharedPreferences("pref", MODE_PRIVATE);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Drawable arrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material);
        arrow.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(arrow);
}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
    public void signUpOnClick(View V) {
        Log.v("비밀번호 확인", "비밀번호 : " + pw.getText().toString() + " 비밀번호 확인 : "
                + rePw.getText().toString() + "결과 : " + (pw.getText().toString() != rePw.getText().toString())); // 로그 찍는거
        if (!(pw.getText().toString().equals(rePw.getText().toString()))) {
            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            rePw.setText("");
        } else {
            memberInfo newMember = new memberInfo(sName.getText().toString(), sId.getText().toString(), pw.getText().toString());
            Toast.makeText(this, sName.getText().toString() + "님, 정상적으로 회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
            Intent back_intent = getIntent();
            back_intent.putExtra("member", newMember);
            setResult(Activity.RESULT_OK, back_intent);
            finish();
        }
    }
}
