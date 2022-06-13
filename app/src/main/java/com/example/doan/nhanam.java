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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class nhanam extends AppCompatActivity {
    TextView as,nd,da,cd;
    Button btn1, btn2, btn3, btn4;
    String a,b,c,d;
    boolean mode;
    ImageView img1, img2,img3,img4;
    boolean bom=false;
    boolean fan2=false;
    boolean fan1=false;
    boolean den=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhanam);
        anhxa();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("Control_device").child("Fan1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.getValue().toString().equals("1")) {
                    img1.setImageResource(R.drawable.ic_fanon);
                    fan1 = true;
                }
                if (dataSnapshot.getValue().toString().equals("0")) {
                    fan1 = false;
                    img1.setImageResource(R.drawable.ic_fanoff);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
        database.child("Control_device").child("Fan2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.getValue().toString().equals("1")) {
                    img2.setImageResource(R.drawable.ic_fanon);
                    fan2 = true;
                }
                if (dataSnapshot.getValue().toString().equals("0")) {
                    fan2 = false;
                    img2.setImageResource(R.drawable.ic_fanoff);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
        database.child("Control_device").child("Lamp").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.getValue().toString().equals("1")) {
                    img3.setImageResource(R.drawable.ic_on);
                    den = true;
                }
                if (dataSnapshot.getValue().toString().equals("0")) {
                    den = false;
                    img3.setImageResource(R.drawable.ic_off);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
        database.child("Control_device").child("Bump").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.getValue().toString().equals("1")) {
                    img4.setImageResource(R.drawable.ic_mottoron);
                    bom = true;
                }
                if (dataSnapshot.getValue().toString().equals("0")) {
                    bom = false;
                    img4.setImageResource(R.drawable.ic_motoroff);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
        database.child("NhaNam_Sensors").child("Light").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                as.setText(dataSnapshot.getValue().toString()+"%");
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("NhaNam_Sensors").child("Humidity").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                da.setText(dataSnapshot.getValue().toString()+"%");
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("NhaNam_Sensors").child("Temperature").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                nd.setText(dataSnapshot.getValue().toString());
            }
            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
        database.child("Control_device").child("mode").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue().toString().equals("0")) {
                    cd.setText("Tự Động");
                    mode=true;
                }
                if (dataSnapshot.getValue().toString().equals("1")) {
                    cd.setText("Thủ Công");
                    mode=false;
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mode==false) {
                    fan1 = !fan1;
                    if (fan1 == false) {
                        img1.setImageResource(R.drawable.ic_motoroff);
                        database.child("Control_device").child("Fan1").setValue("0");
                    } else {
                        img1.setImageResource(R.drawable.ic_mottoron);
                        database.child("Control_device").child("Fan1").setValue("1");
                    }
                }
                if(mode==true) {
                    Toast.makeText(getApplicationContext(),"Không được, vui lòng thay đổi chế độ",Toast.LENGTH_LONG).show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mode==false) {
                    fan2 = !fan2;
                    if (fan2 == false) {
                        img2.setImageResource(R.drawable.ic_motoroff);
                        database.child("Control_device").child("Fan2").setValue("0");
                    } else {
                        img2.setImageResource(R.drawable.ic_mottoron);
                        database.child("Control_device").child("Fan2").setValue("1");
                    }
                }
                if(mode==true) {
                    Toast.makeText(getApplicationContext(),"Không được, vui lòng thay đổi chế độ",Toast.LENGTH_LONG).show();
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mode==false) {
                    den = !den;
                    if (den == false) {
                        img3.setImageResource(R.drawable.ic_off);
                        database.child("Control_device").child("Lamp").setValue("0");
                    } else {
                        img3.setImageResource(R.drawable.ic_on);
                        database.child("Control_device").child("Lamp").setValue("1");
                    }
                }
                if(mode==true) {
                    Toast.makeText(getApplicationContext(),"Không được, vui lòng thay đổi chế độ",Toast.LENGTH_LONG).show();
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mode==false) {
                    bom = !bom;
                    if (bom == false) {
                        img4.setImageResource(R.drawable.ic_motoroff);
                        database.child("Control_device").child("Bump").setValue("0");
                    } else {
                        img4.setImageResource(R.drawable.ic_mottoron);
                        database.child("Control_device").child("Bump").setValue("1");
                    }
                }
                if(mode==true) {
                    Toast.makeText(getApplicationContext(),"Không được, vui lòng thay đổi chế độ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    void anhxa()
    {
        btn1 = findViewById(R.id.button4);
        btn2 = findViewById(R.id.button3);
        btn3 = findViewById(R.id.button2);
        btn4 = findViewById(R.id.button5);
        as = findViewById(R.id.textView10);
        da = findViewById(R.id.textView11);
        nd = findViewById(R.id.textView15);
        cd = findViewById(R.id.textView16);
        img1 = findViewById(R.id.imageView6);
        img2 = findViewById(R.id.imageView7);
        img3 = findViewById(R.id.imageView8);
        img4 = findViewById(R.id.imageView9);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.dien:
                Intent intent1 = new Intent(nhanam.this,diennang.class);
                startActivity(intent1);
                break;
            case R.id.setting:
                Intent intent2 = new Intent(nhanam.this,setting.class);
                startActivity(intent2);
                break;
            case R.id.home1:
                Intent intent3 = new Intent(nhanam.this,trangchu.class);
                startActivity(intent3);
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}