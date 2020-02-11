package com.example.kartikonlinefirebase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kartikonlinefirebase.MainActivity;
import com.example.kartikonlinefirebase.R;
import com.example.kartikonlinefirebase.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login2FireStore extends AppCompatActivity {

    @BindView(R.id.l_email_et)
    EditText lEmailEt;
    @BindView(R.id.l_pwd_et)
    EditText lPwdEt;
    @BindView(R.id.l_login_btn)
    Button lLoginBtn;
    @BindView(R.id.l_tv)
    TextView lTv;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userID;

    User currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fAuth= FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser()!=null) {
            userID = fAuth.getCurrentUser().getUid();
            currentUser = new User();

           final DocumentReference documentReference = fstore.collection("users").document(userID);
            Log.d("Login2FireStoreError", documentReference+"");
            documentReference.addSnapshotListener(Login2FireStore.this, new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                    Log.d("Login2FireStoreError", e+"");
                    //Log.d("Login2FireStoreActivity", documentSnapshot.getString("userEmail"));
                    currentUser.setUserEmail(documentSnapshot.getString("userEmail"));
                    currentUser.setUserName(documentSnapshot.getString("userName"));
                    currentUser.setUserPassword(documentSnapshot.getString("password"));
                    currentUser.setUserId(documentSnapshot.getString("userId"));
//                    currentUser.setOnline(documentSnapshot.getBoolean("isOnline"));
//                    currentUser.setLastActive(Long.parseLong(documentSnapshot.getString("lastActive")));

                }
            });
            Log.d("Login2FireStoreActivity", currentUser.toString());
            makeUserOnline(currentUser,documentReference);
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        setContentView(R.layout.activity_login2_fire_store);
        ButterKnife.bind(this);


        lLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=lEmailEt.getText().toString().trim();
                String password=lPwdEt.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    lEmailEt.setError("email is required");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    lPwdEt.setError("password is required");
                    return;
                }
                if(password.length()<6)
                {
                    lPwdEt.setError("password must be >=6");
                    return;
                }
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login2FireStore.this, "Login successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        }
                        else{
                            Toast.makeText(Login2FireStore.this, "Register user first", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        lTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register2FireStore.class));
            }
        });
    }

    public void makeUserOnline(User mUser, DocumentReference documentReference){


        mUser.setOnline(true);
        mUser.setLastActive(0);
        documentReference.set(mUser);
        FirebaseDatabase.getInstance().getReference("status/" + mUser.getUserId()).setValue("online");

        FirebaseDatabase.getInstance().getReference("/status/" + mUser.getUserId())
                .onDisconnect()     // Set up the disconnect hook
                .setValue("offline");

    }

    public void makeUserOffline(User mUser){

        DocumentReference query = FirebaseFirestore.getInstance().collection("users").document(mUser.getUserId());
        mUser.setOnline(false);
        mUser.setLastActive(System.currentTimeMillis());
        query.set(mUser);
        FirebaseDatabase.getInstance().getReference("status/" + mUser.getUserId()).setValue("offline");



    }

}




