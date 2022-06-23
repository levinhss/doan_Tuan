package com.example.doan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class caidatdien extends AppCompatActivity {
    ImageView img;
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7;
    float thangnay,tdthangnay,cd1,cd2,cd3,cd4,cd5,cd6,cd7,tien,ttruoc,Sdien;
    TextView diennang,tiendien1,tdt,tienthue,s11 ,s12,s13,s14,s15,s16,t11,t12,t13,t14,t15,t16;
    Button xn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caidatdien);
        anhxa();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("diennang").child("bieugia").child("bac1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cd1 =  Float.parseFloat(dataSnapshot.getValue().toString());
                ed1.setText(dataSnapshot.getValue().toString());
                tinhtiendien();
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("diennang").child("bieugia").child("bac2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cd2 =  Integer.parseInt(dataSnapshot.getValue().toString());
                ed2.setText(dataSnapshot.getValue().toString());
                tinhtiendien();
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("diennang").child("bieugia").child("bac3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cd3 =  Integer.parseInt(dataSnapshot.getValue().toString());
                ed3.setText(dataSnapshot.getValue().toString());tinhtiendien();
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("diennang").child("bieugia").child("bac4").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cd4 =  Integer.parseInt(dataSnapshot.getValue().toString());
                ed4.setText(dataSnapshot.getValue().toString());tinhtiendien();
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("diennang").child("bieugia").child("bac5").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cd5 =  Integer.parseInt(dataSnapshot.getValue().toString());
                ed5.setText(dataSnapshot.getValue().toString());tinhtiendien();
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("diennang").child("bieugia").child("bac6").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cd6 =  Integer.parseInt(dataSnapshot.getValue().toString());
                ed6.setText(dataSnapshot.getValue().toString());tinhtiendien();
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("diennang").child("bieugia").child("thue").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cd7 =  Integer.parseInt(dataSnapshot.getValue().toString());
                ed7.setText(dataSnapshot.getValue().toString());tinhtiendien();
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("Control_device").child("cs").child("csThangtruoc").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ttruoc =  Integer.parseInt(dataSnapshot.getValue().toString());

            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("Electrical").child("energy").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Sdien = Float.valueOf(dataSnapshot.getValue().toString());
                thangnay = Sdien -ttruoc;
                diennang.setText(String.format("%.1f",thangnay));
                tinhtiendien();
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        xn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.child("diennang").child("bieugia").child("bac1").setValue(ed1.getText().toString());
                database.child("diennang").child("bieugia").child("bac2").setValue(ed2.getText().toString());
                database.child("diennang").child("bieugia").child("bac3").setValue(ed3.getText().toString());
                database.child("diennang").child("bieugia").child("bac4").setValue(ed4.getText().toString());
                database.child("diennang").child("bieugia").child("bac5").setValue(ed5.getText().toString());
                database.child("diennang").child("bieugia").child("bac6").setValue(ed6.getText().toString());
                database.child("diennang").child("bieugia").child("thue").setValue(ed7.getText().toString());
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(caidatdien.this,reset.class);
                startActivity(intent);
            }
        });
        xn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.child("diennang").child("bieugia").child("bac1").setValue(ed1.getText().toString());
                database.child("diennang").child("bieugia").child("bac2").setValue(ed2.getText().toString());
                database.child("diennang").child("bieugia").child("bac3").setValue(ed3.getText().toString());
                database.child("diennang").child("bieugia").child("bac4").setValue(ed4.getText().toString());
                database.child("diennang").child("bieugia").child("bac5").setValue(ed5.getText().toString());
                database.child("diennang").child("bieugia").child("bac6").setValue(ed6.getText().toString());
                database.child("diennang").child("bieugia").child("thue").setValue(ed7.getText().toString());
            }
        });
    }
    void tinhtiendien()
    {
        if(thangnay<=50)
        {
            tdthangnay=thangnay*cd1;
            s11.setText(String.valueOf(thangnay));
            t11.setText(String.valueOf(thangnay*cd1));
            s12.setText("0");
            t12.setText("0");
            s13.setText("0");
            t13.setText("0");
            s14.setText("0");
            t14.setText("0");
            s15.setText("0");
            t15.setText("0");
            s16.setText("0");
            t16.setText("0");
        }
        else if (thangnay<=100)
        {
            s11.setText("50");
            t11.setText(String.valueOf(50.0*cd1));
            s12.setText(String.format("%.1f",(thangnay-50)));
            t12.setText(String.format("%.1f",(thangnay-50)*cd2));
            s13.setText("0");
            t13.setText("0");
            s14.setText("0");
            t14.setText("0");
            s15.setText("0");
            t15.setText("0");
            s16.setText("0");
            t16.setText("0");
            tdthangnay=50*cd1+(thangnay-50)*cd2;

        }
        else if (thangnay<=200)
        {
            s11.setText("50");
            t11.setText(String.valueOf(50.0*cd1));
            s12.setText("50");
            t12.setText(String.format("%.1f",(50.0*cd2)));
            s13.setText(String.format("%.1f",(thangnay-100)));
            t13.setText(String.format("%.1f",(thangnay-100)*cd3));
            s14.setText("0");
            t14.setText("0");
            s15.setText("0");
            t15.setText("0");
            s16.setText("0");
            t16.setText("0");
            tdthangnay=50*cd1+50*cd2+(thangnay-100)*cd3;
        }
        else if (thangnay<=300)
        {
            s11.setText("50");
            t11.setText(String.valueOf(50.0*cd1));
            s12.setText("50");
            t12.setText(String.format("%.1f",(50.0*cd2)));
            s13.setText("100");
            t13.setText(String.format("%.1f",(100*cd3)));
            s14.setText(String.format("%.1f",(thangnay-200)));
            t14.setText(String.format("%.1f",(thangnay-200)*cd4));
            s15.setText("0");
            t15.setText("0");
            s16.setText("0");
            t16.setText("0");
            tdthangnay=50*cd1+50*cd2+100*cd3+(thangnay-200)*cd4;
        }
        else if(thangnay<=400)
        {
            s11.setText("50");
            t11.setText(String.valueOf(50.0*cd1));
            s12.setText("50");
            t12.setText(String.format("%.1f",(50.0*cd2)));
            s13.setText("100");
            t13.setText(String.format("%.1f",(100*cd3)));
            s14.setText("100");
            t14.setText(String.format("%.1f",(100*cd4)));
            s15.setText(String.format("%.1f",thangnay-300));
            t15.setText(String.format("%.1f",(thangnay-300)*cd5));
            s16.setText("0");
            t16.setText("0");
            tdthangnay=50*cd1+50*cd2+100*cd3+100*cd4+(thangnay-300)*cd5;
        }
        else if(thangnay>400)
        {
            s11.setText("50");
            t11.setText(String.valueOf(50.0*cd1));
            s12.setText("50");
            t12.setText(String.format("%.1f",(50.0*cd2)));
            s13.setText("100");
            t13.setText(String.format("%.1f",(100*cd3)));
            s14.setText("100");
            t14.setText(String.format("%.1f",(100*cd4)));
            s15.setText("100");
            t15.setText(String.format("%.1f",(100*cd5)));
            s16.setText(String.format("%.1f",(thangnay-400)));
            t16.setText(String.format("%.1f",(thangnay-400)*cd6));
            tdthangnay=50*cd1+50*cd2+100*cd3+100*cd4+100*cd5+(thangnay-400)*cd6;
        }
      //  tiendien1.setText(String.valueOf(tdthangnay));
        tiendien1.setText(String.format("%.1f",tdthangnay));
      //  tienthue.setText(String.valueOf(tdthangnay*(cd7/100)));
        tienthue.setText(String.format("%.1f",tdthangnay*(cd7/100)));
        tien = tdthangnay + tdthangnay*(cd7/100);
      //  tdt.setText(String.valueOf(tien));
        tdt.setText(String.format("%.1f",tdthangnay + tdthangnay*(cd7/100)));
    }
    void anhxa()
    {
        diennang=findViewById(R.id.ssl);
        tiendien1 = findViewById(R.id.st);
        tdt = findViewById(R.id.tongtien);
        tienthue = findViewById(R.id.thue);
        ed1=findViewById(R.id.editTextNumber);
        ed2=findViewById(R.id.editTextNumber2);
        ed3=findViewById(R.id.editTextNumber3);
        ed4=findViewById(R.id.editTextNumber4);
        ed5=findViewById(R.id.editTextNumber5);
        ed6=findViewById(R.id.editTextNumber6);
        ed7=findViewById(R.id.editTextNumber7);
        s11 = findViewById(R.id.sl1);
        s12 = findViewById(R.id.sl2);
        s13 = findViewById(R.id.sl3);
        s14 = findViewById(R.id.sl4);
        s15 = findViewById(R.id.sl5);
        s16 = findViewById(R.id.sl6);
        t11=findViewById(R.id.tt1);
        t12=findViewById(R.id.tt2);
        t13=findViewById(R.id.tt3);
        t14=findViewById(R.id.tt4);
        t15=findViewById(R.id.tt5);
        t16=findViewById(R.id.tt6);
        xn=findViewById(R.id.button16);
        img = findViewById(R.id.reset);
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
                Intent intent = new Intent(caidatdien.this,nhanam.class);
                startActivity(intent);
                break;
            case R.id.dien:
                Intent intent1 = new Intent(caidatdien.this,diennang.class);
                startActivity(intent1);
                break;
            case R.id.setting:
                Intent intent2 = new Intent(caidatdien.this,setting.class);
                startActivity(intent2);
                break;
            case R.id.home1:
                Intent intent3 = new Intent(caidatdien.this,trangchu.class);
                startActivity(intent3);
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}