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
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by sdie3 on 2018-04-10.
 */

public class text_input extends AppCompatActivity {
    Button delete;
    Button submmit;
    EditText inputText;
    Toolbar input_ToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_input);
        delete = findViewById(R.id.delete_Button);
        submmit = findViewById(R.id.summit_Button);
        inputText = findViewById(R.id.input_Text);
        input_ToolBar = findViewById(R.id.input_ToolBar);
        setSupportActionBar(input_ToolBar);

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

    public void delete_Button_OnClick(View v) {
        inputText.setText("");
    }

    public void sumit_Button_OnClick(View v) {
        Intent back_intent = getIntent();
        back_intent.putExtra("key", inputText.getText().toString());
        setResult(Activity.RESULT_OK, back_intent);
        finish();
    }
}
