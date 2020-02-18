package com.example.kartikonlinefirebase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Register2FireStore extends AppCompatActivity {

    @BindView(R.id.r_un_et)
    EditText rUserNameEt;
    @BindView(R.id.r_email_et)
    EditText rEmailEt;
    @BindView(R.id.r_pass_et)
    EditText rPassEt;
    @BindView(R.id.r_cn_pwd_et)
    EditText rConfirmPassEt;
    @BindView(R.id.r_reg_btn)
    Button rRegBtn;
    FirebaseAuth  fAuth;
    FirebaseUser currentUser;
    FirebaseFirestore fstore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2_fire_store);
        ButterKnife.bind(this);

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        currentUser = fAuth.getCurrentUser();

        if(currentUser != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        rPassEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.length() < 6){
                    rPassEt.setError(" Password must be greater than 6 characters");
                    //rRegBtn.setClickable(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        rRegBtn.setOnClickListener((View v) -> {

            String email = rEmailEt.getText().toString().trim();
            String name = rUserNameEt.getText().toString().trim();
            String password = rPassEt.getText().toString().trim();
            String confirmPassword = rConfirmPassEt.getText().toString().trim();



            if(TextUtils.isEmpty(name)){
                rUserNameEt.setError("user name is required");
            }
            else if(TextUtils.isEmpty(email)){
                rEmailEt.setError("email is required");
            }
            else if(TextUtils.isEmpty(password)){
                rPassEt.setError("password is required");
            }
            else if(TextUtils.isEmpty(confirmPassword)){
                rConfirmPassEt.setError("confirm your password");
            }
            else if(!password.equals(confirmPassword)){
                rConfirmPassEt.setError("pass dont match");

            }
            else {

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener((Task<AuthResult> task) -> {

                    if (task.isSuccessful()) {
                        Toast.makeText(Register2FireStore.this, "User Created in Auth .", Toast.LENGTH_SHORT).show();


                        userID = fAuth.getCurrentUser().getUid();
                        DocumentReference documentReference = fstore.collection("users").document(userID);
                        HashMap<String, Object> user = new HashMap<>();
                        user.put("userName", name);
                        user.put("userEmail", email);
                        user.put("password", password);
                        //user.put("lastActive", )
                        documentReference.set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(Task<Void> task) {

                                Toast.makeText(Register2FireStore.this, "User set in user table ", Toast.LENGTH_SHORT).show();

                            }
                        });

                        startActivity(new Intent(getApplicationContext(), Admin_Home.class));
                        finish();

                    } else {

                        Toast.makeText(Register2FireStore.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }

                });
            }

        });

    }
}
