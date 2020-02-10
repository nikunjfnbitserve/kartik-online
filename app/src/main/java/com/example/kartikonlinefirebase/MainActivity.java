package com.example.kartikonlinefirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kartikonlinefirebase.activities.Admin_Home;
import com.example.kartikonlinefirebase.activities.Login2FireStore;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

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
    String userID;
    @BindView(R.id.admin_panel)
    TextView adminPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        final DocumentReference documentReference = fstore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                mNTv.setText(documentSnapshot.getString("userName"));
                mETv.setText(documentSnapshot.getString("userEmail"));
                mPhTv.setText(documentSnapshot.getString("password"));

            }
        });

        mLoBtn.setOnClickListener((View v) -> {

            fAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(), Login2FireStore.class);
            startActivity(intent);
            finish();


        });

        adminPanel.setOnClickListener((View v) -> {

            startActivity(new Intent(getApplicationContext(), Admin_Home.class));
            finish();

        });
    }
}
