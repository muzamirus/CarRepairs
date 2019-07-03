package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button btn1=(Button)findViewById(R.id.user);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Signup.this,User.class);
                startActivity(intent);
            }
        });
        Button btn2=(Button)findViewById(R.id.mechanic);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Signup.this,Mechanic.class);
                startActivity(intent);
            }
        });
        Button btn3=(Button)findViewById(R.id.supplier);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Signup.this, Supplier.class);
                startActivity(intent);
            }
        });
    }
}
