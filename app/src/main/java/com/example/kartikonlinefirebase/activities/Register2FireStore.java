package com.example.kartikonlinefirebase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kartikonlinefirebase.MainActivity;
import com.example.kartikonlinefirebase.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Register2FireStore extends AppCompatActivity {

    @BindView(R.id.r_un_et)
    EditText rUnEt;
    @BindView(R.id.r_email_et)
    EditText rEmailEt;
    @BindView(R.id.r_ph_et)
    EditText rPhEt;
    @BindView(R.id.r_pwd_et)
    EditText rPwdEt;
    @BindView(R.id.r_reg_btn)
    Button rRegBtn;
    FirebaseAuth  fAuth;
    FirebaseFirestore fstore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2_fire_store);
        ButterKnife.bind(this);

        fAuth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        if(fAuth.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
        rRegBtn.setOnClickListener((View v) -> {

            final String email=rEmailEt.getText().toString().trim();
            final String password=rPwdEt.getText().toString().trim();
            final String name=rUnEt.getText().toString().trim();
            final String phone=rPhEt.getText().toString().trim();

            if(TextUtils.isEmpty(email)){
                rEmailEt.setError("email is required");
                return;
            }

            if(TextUtils.isEmpty(password)){
                rPwdEt.setError("password is required");
                return;
            }
            if(password.length()<6)
            {
                rPwdEt.setError("Password must be >= 6 character ");
                return;
            }

            fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener((Task<AuthResult> task) -> {

                if(task.isSuccessful()) {
                    Toast.makeText(Register2FireStore.this, "User Created .", Toast.LENGTH_SHORT).show();
                    userID=fAuth.getCurrentUser().getUid();
                    DocumentReference documentReference=fstore.collection("users").document(userID);
                    HashMap<String,Object> user= new HashMap<>();
                    user.put("name",name);
                    user.put("e_mail",email);
                    user.put("ph",phone);
                    documentReference.set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            Toast.makeText(Register2FireStore.this, "User Created", Toast.LENGTH_SHORT).show();

                        }
                    });
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                }
                else {

                    Toast.makeText(Register2FireStore.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }

        });

        });

    }
}
