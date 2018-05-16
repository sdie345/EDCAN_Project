package com.example.sdie3.edcan_project;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.sdie3.edcan_project.R;

/**
 * Created by sdie3 on 2018-05-02.
 */

public class MenuActivity extends AppCompatActivity {
    Button toMemoBtn;
    Button toCulBtn;
    android.support.v7.widget.Toolbar menu_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        toMemoBtn = findViewById(R.id.toMemo);
        toCulBtn = findViewById(R.id.toCul);
        menu_toolbar = findViewById(R.id.menu_toolbar);
        setSupportActionBar(menu_toolbar);

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
    public void toMemoOnClick(View v) {
        startActivity(new Intent(MenuActivity.this, MemoActivity.class));
    }
    public void toCulOnClick(View v) {
        startActivity(new Intent(MenuActivity.this, CalculatorActivity.class));
    }
}
