package com.example.kartikonlinefirebase;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kartikonlinefirebase.activities.Admin_Home;
import com.example.kartikonlinefirebase.activities.Login2FireStore;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.example.kartikonlinefirebase.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.m_n_tv)
    TextView mNTv;
    @BindView(R.id.m_e_tv)
    TextView mETv;
    @BindView(R.id.m_ph_tv)
    TextView mPhTv;
    @BindView(R.id.m_lo_btn)
    Button mLoBtn;

    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    FirebaseUser user;
    String userID;
    String userName;
    @BindView(R.id.admin_panel)
    TextView adminPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        userID = fAuth.getCurrentUser().getUid();

//        DocumentReference documentReference = fstore.collection("users").document(userID);
//
//
//        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
//                .setDisplayName(userName)
//                .build();
//
//        user.updateProfile(profileUpdates)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            Log.d("Register2FireStore", "User profile updated.");
//                        }
//                    }
//                });

        if(user != null){

            mNTv.setText(user.getDisplayName());
            mETv.setText(user.getEmail());



//            DocumentReference documentReference = fstore.collection("users").document(userID);
//            documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//                @Override
//                public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
//
//
//
//                }
//            });

        }



        mLoBtn.setOnClickListener((View v) -> {

            fAuth.signOut();
            Intent intent = new Intent(getApplicationContext(), Login2FireStore.class);
            startActivity(intent);
            finish();


        });

        adminPanel.setOnClickListener((View v) -> {
            adminPanel.setEnabled(false);

            startActivity(new Intent(getApplicationContext(), Admin_Home.class));
            finish();

        });
    }
}
