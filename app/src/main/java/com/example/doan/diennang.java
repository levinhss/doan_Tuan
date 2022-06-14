package com.example.doan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class diennang extends AppCompatActivity {
 TextView dienap, dongdien, congsuat, tanso, Sdien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diennang);
        anhxa();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("Electrical").child("voltage").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dienap.setText(dataSnapshot.getValue().toString()+" V");
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        database.child("Electrical").child("current").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dongdien.setText(dataSnapshot.getValue().toString()+" A");
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        database.child("Electrical").child("power").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                congsuat.setText(dataSnapshot.getValue().toString()+" W");
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        database.child("Electrical").child("frequency").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tanso.setText(dataSnapshot.getValue().toString()+" Hz");
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        database.child("Electrical").child("energy").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Sdien.setText(dataSnapshot.getValue().toString()+" Kwh");
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }
    void anhxa()
    {
        dienap = findViewById(R.id.textView46);
        dongdien =findViewById(R.id.textView26);
        congsuat = findViewById(R.id.textView39);
        tanso = findViewById(R.id.textView28);
        Sdien = findViewById(R.id.textView45);
//        edit6 = findViewById(R.id.editTextTextPersonName2);
//        btn3 = findViewById(R.id.button7);
//        btn2 = findViewById(R.id.button8);
//        xn = findViewById(R.id.button6);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.dien:
                Intent intent1 = new Intent(diennang.this,diennang.class);
                startActivity(intent1);
                break;
            case R.id.setting:
                Intent intent2 = new Intent(diennang.this,setting.class);
                startActivity(intent2);
                break;
            case R.id.home1:
                Intent intent3 = new Intent(diennang.this,trangchu.class);
                startActivity(intent3);
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}