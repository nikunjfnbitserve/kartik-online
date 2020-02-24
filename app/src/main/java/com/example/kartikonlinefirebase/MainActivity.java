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


public class MainActivity extends AppCompatActivity {

    TextView mNTv, mPhTv, mETv, adminPanel;
    Button mLoBtn;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    FirebaseUser user;
    String userID, userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNTv = (TextView) findViewById(R.id.m_n_tv);
        mETv = (TextView) findViewById(R.id.m_e_tv) ;
        mPhTv = (TextView) findViewById(R.id.m_ph_tv);
        adminPanel = (TextView) findViewById(R.id.admin_panel);
        mLoBtn = (Button) findViewById(R.id.m_lo_btn);

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

        mLoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fAuth.signOut();
                Intent intent = new Intent(getApplicationContext(), Login2FireStore.class);
                startActivity(intent);
                finish();

            }
        });

        adminPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminPanel.setEnabled(false);
                startActivity(new Intent(getApplicationContext(), Admin_Home.class));
                finish();

            }
        });
    }
}

//TODO(1): Make a common ViewPagerAdapter for existing view pagers and tablayouts
//TODO(2): Safely remove activities which are already been copied inside fragments