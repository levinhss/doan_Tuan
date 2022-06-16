package com.example.doan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class caidatnam extends AppCompatActivity {
    String a,b,c,d,e,f,g;
    Button xn, btn2, btn3;
    EditText edit1,edit2,edit3,edit4,edit5,edit6;
    int T1,T2,H1,H2,L1,L2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caidatnam);
        anhxa();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("Control_device").child("Threshold").child("Temperature_thres1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                b = dataSnapshot.getValue().toString();
                edit1.setText(b);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
        database.child("Control_device").child("Threshold").child("Temperature_thres2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                c = dataSnapshot.getValue().toString();
                edit2.setText(c);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
        database.child("Control_device").child("Threshold").child("Humidity_thres1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                d = dataSnapshot.getValue().toString();
                edit3.setText(d);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
        database.child("Control_device").child("Threshold").child("Humidity_thres2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                e = dataSnapshot.getValue().toString();
                edit4.setText(e);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
        database.child("Control_device").child("Threshold").child("Light_thres1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                f = dataSnapshot.getValue().toString();
                edit5.setText(f);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
        database.child("Control_device").child("Threshold").child("Light_thres2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                g = dataSnapshot.getValue().toString();
                edit6.setText(g);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
        database.child("Control_device").child("mode").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                a = dataSnapshot.getValue().toString();
                if (a.equals("0")) {
                    btn2.setBackgroundColor(Color.RED);
                    btn3.setBackgroundColor(Color.YELLOW);
                }
                if (a.equals("1")) {
                    btn3.setBackgroundColor(Color.RED);
                    btn2.setBackgroundColor(Color.YELLOW);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.child("Control_device").child("mode").setValue("0");
                btn2.setBackgroundColor(Color.RED);
                btn3.setBackgroundColor(Color.YELLOW);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.child("Control_device").child("mode").setValue("1");
                btn3.setBackgroundColor(Color.RED);
                btn2.setBackgroundColor(Color.YELLOW);
            }
        });
        xn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                T2= Integer.parseInt(edit1.getText().toString());
                T1= Integer.parseInt(edit2.getText().toString());
                H2= Integer.parseInt(edit3.getText().toString());
                H1= Integer.parseInt(edit4.getText().toString());
                L2= Integer.parseInt(edit5.getText().toString());
                L1= Integer.parseInt(edit6.getText().toString());
                if(T1>=0&&T1<T2&&T2<=100&&H1>=0&&H1<H2&&H2<=100&&L1>=0&&L1<L2&&L2<=100)
                {
                            database.child("Control_device").child("Threshold").child("Temperature_thres1").setValue(edit1.getText().toString());
                            database.child("Control_device").child("Threshold").child("Temperature_thres2").setValue(edit2.getText().toString());
                            database.child("Control_device").child("Threshold").child("Humidity_thres1").setValue(edit3.getText().toString());
                            database.child("Control_device").child("Threshold").child("Humidity_thres2").setValue(edit4.getText().toString());
                            database.child("Control_device").child("Threshold").child("Light_thres1").setValue(edit5.getText().toString());
                            database.child("Control_device").child("Threshold").child("Light_thres2").setValue(edit6.getText().toString());
                            Toast.makeText(getApplicationContext(), "Nhập thành công", Toast.LENGTH_LONG).show();
                }
                else if(T1>=0&&T1>=T2&&T2<=100)
                {
                    Toast.makeText(getApplicationContext(), "Nhiệt độ ngưỡng trên phải > ngưỡng dưới", Toast.LENGTH_LONG).show();
                }
                else  if(H1>=0&&H1>=H2&&H2<=100)
                {
                    Toast.makeText(getApplicationContext(), "Độ ẩm ngưỡng trên phải > ngưỡng dưới", Toast.LENGTH_LONG).show();
                }
                else if(L1>=0&&L1>=L2&&L2<=100)
                {
                    Toast.makeText(getApplicationContext(), "Ánh sáng ngưỡng trên phải > ngưỡng dưới", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Vui lòng nhập giá trị nhỏ hơn 100",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    void anhxa()
    {
        edit1 = findViewById(R.id.editTextTextPersonName6);
        edit2 = findViewById(R.id.editTextTextPersonName7);
        edit3 = findViewById(R.id.editTextTextPersonName3);
        edit4 = findViewById(R.id.editTextTextPersonName4);
        edit5 = findViewById(R.id.editTextTextPersonName5);
        edit6 = findViewById(R.id.editTextTextPersonName2);
        btn3 = findViewById(R.id.button7);
        btn2 = findViewById(R.id.button8);
        xn = findViewById(R.id.button6);
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
                Intent intent = new Intent(caidatnam.this,nhanam.class);
                startActivity(intent);
                break;
            case R.id.dien:
                Intent intent1 = new Intent(caidatnam.this,diennang.class);
                startActivity(intent1);
                break;
            case R.id.setting:
                Intent intent2 = new Intent(caidatnam.this,setting.class);
                startActivity(intent2);
                break;
            case R.id.home1:
                Intent intent3 = new Intent(caidatnam.this,trangchu.class);
                startActivity(intent3);
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}