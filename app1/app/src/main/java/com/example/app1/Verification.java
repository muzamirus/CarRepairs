package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Verification extends AppCompatActivity {
    private Button sendButton;
    private EditText phoneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        phoneText = findViewById(R.id.phoneText);
        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = phoneText.getText().toString().trim();
                if (number.isEmpty() || number.length() <9){
                    phoneText.setError("Valid number is required");
                    phoneText.requestFocus();
                    return;
                }
                String phoneNumber= "+256" + number;
                Intent intent=new Intent(Verification.this,Sms.class);
                intent.putExtra("phonenumber", phoneNumber);
                startActivity(intent);
                Toast.makeText(Verification.this,phoneNumber, Toast.LENGTH_SHORT).show();

            }
        });

    }
}


