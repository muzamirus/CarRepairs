package com.example.carrepair;

<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

//import com.firebase.ui.auth.provider.PhoneProvider;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
=======
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Sms extends AppCompatActivity  {
>>>>>>> c76aadfd6e59ea6c3149f38587cc630b896b8285

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Sms extends AppCompatActivity {
private String verificationId;
private FirebaseAuth mAuth;
private ProgressBar progressBar;
private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
<<<<<<< HEAD
        progressBar =findViewById(R.id.progressbar);
        FirebaseApp.initializeApp(this);
        mAuth=FirebaseAuth.getInstance();
        editText=findViewById(R.id.editTextCode);

        String phonenumber = getIntent().getStringExtra("phonenumber");
    sendVerificationCode(phonenumber);
    findViewById(R.id.nextsms).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String code =editText.getText().toString().trim();
            if (code.isEmpty() || code.length()<6){
                editText.setError("Enter code..");
                editText.requestFocus();
                return;
            }
            progressBar.setVisibility(View.VISIBLE);
            verifyCode(code);
        }
    });
    }
    private void verifyCode(String code){
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificationId, code);
        signInWithCredential(credential);
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
    mAuth.signInWithCredential(credential)
            .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Intent intent =new Intent(Sms.this,Signup.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                    }
                    else{
                        Toast.makeText(Sms.this,task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
    }

    private  void sendVerificationCode(String number){
        progressBar.setVisibility(View.VISIBLE);
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallBack
        );
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
    mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationId = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if (code != null){
                editText.setText(code);
                verifyCode(code);
            }

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(Sms.this, e.getMessage(), Toast.LENGTH_LONG).show();

        }
    };
}
=======
    }}

>>>>>>> c76aadfd6e59ea6c3149f38587cc630b896b8285
