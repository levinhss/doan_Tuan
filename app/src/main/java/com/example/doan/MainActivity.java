package com.example.doan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button dangnhap;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password = findViewById(R.id.editTextTextPersonName);
        dangnhap = findViewById(R.id.button);
        dangnhap.setOnClickListener(view -> dangnhapmk(password.getText().toString()));
    }
    private void dangnhapmk(String mk)
    {
        if(mk.equals("123456"))
        {
            Intent intent = new Intent(MainActivity.this,trangchu.class);
            startActivity(intent);
        }
        else if (mk.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Vui lòng nhập password",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Sai Password, vui lòng nhập lại",Toast.LENGTH_LONG).show();
        }
    }
}