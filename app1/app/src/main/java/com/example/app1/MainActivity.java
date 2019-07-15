package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
Button btn;
ImageView img;
CheckBox ck1, ck2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.next);
        img=(ImageView) findViewById(R.id.img);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Verification.class);
                startActivity(intent);
            }
        });
        ck1 = (CheckBox) findViewById(R.id.agree);
        ck2=(CheckBox) findViewById(R.id.disagree);
        if (!ck1.isChecked()) {
            ck1.setChecked(true);
        }
        else if (!ck2.isChecked()){
            ck2.setChecked(true);
        }
    }
}
