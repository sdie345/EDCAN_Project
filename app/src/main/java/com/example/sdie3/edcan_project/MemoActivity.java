package com.example.sdie3.edcan_project;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MemoActivity extends AppCompatActivity {
    Button btn;
    RecyclerView recyclerView;
    ArrayList<List_item> data = new ArrayList<>();
    RecyclerViewAdapter adapter;
    SharedPreferences pref;
    Toolbar memo_ToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        btn = findViewById(R.id.to_input_button);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new RecyclerViewAdapter(data);
        adapter.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = recyclerView.getChildAdapterPosition(v);
                Toast.makeText(MemoActivity.this, data.get(position).getWork().toString() + "를 제거합니다...", Toast.LENGTH_SHORT).show();
                data.remove(data.get(position));
                savePreferences(data);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        recyclerView.setAdapter(adapter);

        pref = getSharedPreferences("pref", MODE_PRIVATE);
        if(myGetPreferences() != null)
            data.addAll(myGetPreferences());

        adapter.notifyDataSetChanged();

        memo_ToolBar = findViewById(R.id.memo_ToolBar);
        setSupportActionBar(memo_ToolBar);

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
    public void OnClick(View v) {
        startActivityForResult(new Intent(MemoActivity.this, text_input.class), 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1000){
            if(resultCode == Activity.RESULT_OK){
                this.data.add(new List_item(data.getStringExtra("key")));
                Log.v("asdf",data.getStringExtra("key").toString());
                savePreferences(this.data);
                adapter.notifyDataSetChanged();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void savePreferences(ArrayList<List_item> data) {
        SharedPreferences.Editor editor = pref.edit();
        Gson gson = new Gson();
        editor.putString("data", gson.toJson(data));
        editor.commit();
    }

    public ArrayList<List_item> myGetPreferences() {
        return new Gson().fromJson(pref.getString("data", ""), new TypeToken<List<List_item>>(){}.getType());
    }
}
