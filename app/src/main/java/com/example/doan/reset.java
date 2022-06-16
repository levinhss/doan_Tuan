package com.example.doan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class reset extends AppCompatActivity {
ImageView rst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        anhxa();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        rst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.child("Control_device").child("RstE").setValue("1");
                database.child("Control_device").child("cs").child("csHomqua").setValue("0");
                database.child("Control_device").child("cs").child("csHomtruoc").setValue("0");
                database.child("Control_device").child("cs").child("csThangroi").setValue("0");
                database.child("Control_device").child("cs").child("csThangtruoc").setValue("0");
                Toast.makeText(getApplicationContext(), "Thành công", Toast.LENGTH_LONG).show();
            }
        });
    }
    void anhxa()
    {
        rst = findViewById(R.id.imageView15);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nam:
                Intent intent = new Intent(reset.this,nhanam.class);
                startActivity(intent);
                break;
            case R.id.dien:
                Intent intent1 = new Intent(reset.this,diennang.class);
                startActivity(intent1);
                break;
            case R.id.setting:
                Intent intent2 = new Intent(reset.this,setting.class);
                startActivity(intent2);
                break;
            case R.id.home1:
                Intent intent3 = new Intent(reset.this,trangchu.class);
                startActivity(intent3);
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}