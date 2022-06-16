package com.example.doan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class diennang extends AppCompatActivity {
 TextView dienap, dongdien, congsuat, tanso, Sdien,hq,hn,thangn,thangt,td1;
   // int cd1,cd2,cd3,cd4,cd5,cd6,cd7,tien;
   float cd1,cd2,cd3,cd4,cd5,cd6,cd7,tdthangnay;
    EditText ed1;
    Button xn;
    int homqua, homnay, thangroi, thangnay,cshomtruoc,csthangroi,cshomqua,csthangtruoc,enr;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diennang);
        anhxa();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        database.child("diennang").child("bieugia").child("bac1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cd1 =  Integer.parseInt(dataSnapshot.getValue().toString());
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("diennang").child("bieugia").child("bac2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cd2 =  Integer.parseInt(dataSnapshot.getValue().toString());
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("diennang").child("bieugia").child("bac3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cd3 =  Integer.parseInt(dataSnapshot.getValue().toString());
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("diennang").child("bieugia").child("bac4").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cd4 =  Integer.parseInt(dataSnapshot.getValue().toString());
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("diennang").child("bieugia").child("bac5").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cd5 =  Integer.parseInt(dataSnapshot.getValue().toString());
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("diennang").child("bieugia").child("bac6").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cd6 =  Integer.parseInt(dataSnapshot.getValue().toString());
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("diennang").child("bieugia").child("thue").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cd7 =  Integer.parseInt(dataSnapshot.getValue().toString());
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        database.child("Control_device").child("cs").child("ngaychot").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ed1.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
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
        database.child("Control_device").child("cs").child("csHomtruoc").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cshomtruoc =  Integer.parseInt(dataSnapshot.getValue().toString());
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        database.child("Control_device").child("cs").child("csHomqua").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cshomqua =  Integer.parseInt(dataSnapshot.getValue().toString());
                homqua = cshomqua -cshomtruoc;
                hq.setText(String.valueOf(homqua)+" Kwh");
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        database.child("Control_device").child("cs").child("csThangtruoc").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                csthangtruoc =  Integer.parseInt(dataSnapshot.getValue().toString());
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        database.child("Control_device").child("cs").child("csThangroi").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                csthangroi =  Integer.parseInt(dataSnapshot.getValue().toString());
                thangroi = csthangroi - csthangtruoc;
                thangt.setText(String.valueOf(thangroi)+" Kwh");
                if(thangroi <=50)
                {
                    tdthangnay=thangroi*cd1;
                }
                else if (thangroi <=100)
                {
                    tdthangnay=50*cd1+(thangroi -50)*cd2;
                }
                else if (thangroi<=200)
                {
                    tdthangnay=50*cd1+50*cd2+(thangroi-100)*cd3;
                }
                else if (thangroi<=300)
                {
                    tdthangnay=50*cd1+50*cd2+100*cd3+(thangroi -200)*cd4;
                }
                else if(thangroi<=400)
                {
                    tdthangnay=50*cd1+50*cd2+100*cd3+100*cd4+(thangroi -300)*cd5;
                }
                else if(thangroi>400)
                {
                    tdthangnay=50*cd1+50*cd2+100*cd3+100*cd4+100*cd5+(thangroi -400)*cd6;
                }
               // td1.setText(String.valueOf(tdthangnay + tdthangnay*(cd7/100))+ " VNĐ");
                td1.setText(String.format("%.1f",tdthangnay + tdthangnay*(cd7/100)));
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
                enr = Integer.parseInt(dataSnapshot.getValue().toString());
                hn.setText(String.valueOf(enr-cshomqua)+" Kwh");
                thangn.setText(String.valueOf(enr-csthangroi)+" Kwh");

            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        xn.setOnClickListener(view -> caidat(ed1.getText().toString()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }
    private void caidat(String cd)
    {
        if(Integer.parseInt(cd)>=0&&Integer.parseInt(cd)<=31)
        {
            database.child("Control_device").child("cs").child("ngaychot").setValue(cd);
            Toast.makeText(getApplicationContext(),"Nhập thành công",Toast.LENGTH_LONG).show();
        }
        else if (cd.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Vui lòng nhập lại",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Vui lòng nhập giá trị nhỏ hơn 31",Toast.LENGTH_LONG).show();
        }
    }
    void anhxa()
    {
        dienap = findViewById(R.id.textView46);
        dongdien =findViewById(R.id.textView26);
        congsuat = findViewById(R.id.textView39);
        tanso = findViewById(R.id.textView28);
        Sdien = findViewById(R.id.textView45);
        ed1 = findViewById(R.id.chotdiennang);
        xn = findViewById(R.id.button10);
        hq = findViewById(R.id.textView33);
        hn =findViewById(R.id.textView35);
        thangt = findViewById(R.id.textView43);
        thangn = findViewById(R.id.textView44);
        td1= findViewById(R.id.textView29);
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