package com.example.sdie3.edcan_project;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sdie3 on 2018-05-05.
 */

public class CalculatorActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button btnEqual;
    Button btnBackSpace;
    Button btnPlus;
    Button btnMinus;
    Button btnMul;
    Button btnDiv;
    TextView exp;
    TextView result;
    String term1 = "";
    String term2 = "";
    android.support.v7.widget.Toolbar calToolBar;
    int temp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnEqual = findViewById(R.id.btnEqual);
        btnBackSpace = findViewById(R.id.btnBackSpace);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        exp = findViewById(R.id.exp);
        result = findViewById(R.id.result);
        calToolBar = findViewById(R.id.calToolBar);
        setSupportActionBar(calToolBar);

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
    public void Btn1OnClick(View V) {
        term1 += "1";
        result.setText(term1);
    }
    public void Btn2OnClick(View V) {
        term1 += "2";
        result.setText(term1);
    }
    public void Btn3OnClick(View V) {
        term1 += "3";
        result.setText(term1);
    }
    public void Btn4OnClick(View V) {
        term1 += "4";
        result.setText(term1);
    }
    public void Btn5OnClick(View V) {
        term1 += "5";
        result.setText(term1);
    }
    public void Btn6OnClick(View V) {
        term1 += "6";
        result.setText(term1);
    }
    public void Btn7OnClick(View V) {
        term1 += "7";
        result.setText(term1);
    }
    public void Btn8OnClick(View V) {
        term1 += "8";
        result.setText(term1);
    }
    public void Btn9OnClick(View V) {
        term1 += "9";
        result.setText(term1);
    }
    public void Btn0OnClick(View V) {
        if (!(term1.equals("")))
            term1 += "0";
        result.setText(term1);
    }
    public void BtnBackSpaceOnClick(View V) {
        if (!(term1.equals(""))) {
            term1 = term1.substring(0, term1.length() - 1);
            result.setText(term1);
        }
    }
    public void BtnEqualOnClick(View V) {
        if (!(term1.equals(""))) {
            doCul();
        }
    }
    public void BtnPlusOnClick(View V) {
        if (term2.equals("") && !(term1.equals(""))) {
            term2 = term1 + " +";
            term1 = "";
            exp.setText(term2);
            result.setText(term1);
        }
        else if (!(term2.equals("")) && !(term1.equals(""))) {
            doCul();
            term2 = Integer.toString(temp) + " +";
            term1 = "";
            exp.setText(term2);
            result.setText(term1);
        }
    }
    public void BtnMinusOnClick(View V) {
        if (term2.equals("") && !(term1.equals(""))) {
            term2 = term1 + " -";
            term1 = "";
            exp.setText(term2);
            result.setText(term1);
        }
        else if (!(term2.equals("")) && !(term1.equals(""))) {
            doCul();
            term2 = Integer.toString(temp) + " -";
            term1 = "";
            exp.setText(term2);
            result.setText(term1);
        }
    }
    public void BtnMulOnClick(View V) {
        if (term2.equals("") && !(term1.equals(""))) {
            term2 = term1 + " ×";
            term1 = "";
            exp.setText(term2);
            result.setText(term1);
        }
        else if (!(term2.equals("")) && !(term1.equals(""))) {
            doCul();
            term2 = Integer.toString(temp) + " ×";
            term1 = "";
            exp.setText(term2);
            result.setText(term1);
        }
    }
    public void BtnDivOnClick(View V) {
        if (term2.equals("") && !(term1.equals(""))) {
            term2 = term1 + " ÷";
            term1 = "";
            exp.setText(term2);
            result.setText(term1);
        }
        else if (!(term2.equals("")) && !(term1.equals(""))) {
            doCul();
            term2 = Integer.toString(temp) + " ÷";
            term1 = "";
            exp.setText(term2);
            result.setText(term1);
        }
    }
    public void doCul() {
        switch (term2.substring(term2.length() - 1, term2.length())) {
            case "+" :
                temp = Integer.parseInt(term2.substring(0, term2.length() - 2)) + Integer.parseInt(term1);
                term2 = "";
                term1 = Integer.toString(temp);
                exp.setText(term2);
                result.setText(term1);
                break;
            case "-" :
                temp = Integer.parseInt(term2.substring(0, term2.length() - 2)) - Integer.parseInt(term1);
                term2 = "";
                term1 = Integer.toString(temp);
                exp.setText(term2);
                result.setText(term1);
                break;
            case "×" :
                temp = Integer.parseInt(term2.substring(0, term2.length() - 2)) * Integer.parseInt(term1);
                term2 = "";
                term1 = Integer.toString(temp);
                exp.setText(term2);
                result.setText(term1);
                break;
            case "÷" :
                temp = Integer.parseInt(term2.substring(0, term2.length() - 2)) / Integer.parseInt(term1);
                term2 = "";
                term1 = Integer.toString(temp);
                exp.setText(term2);
                result.setText(term1);
                break;
        }
    }

}
