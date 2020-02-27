package com.example.kartikonlinefirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import com.example.kartikonlinefirebase.activities.Login2FireStore;
import com.example.kartikonlinefirebase.adapters.AdminTabsViewPagerAdapter;
import com.example.kartikonlinefirebase.fragments.AdminCatalogueFragment;
import com.example.kartikonlinefirebase.fragments.AdminHomeFragment;
import com.example.kartikonlinefirebase.fragments.AdminOtherFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;
    TabLayout tabLayout;

    private AppBarConfiguration mAppBarConfiguration;

    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    FirebaseUser user;
    String userID, userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        userID = fAuth.getCurrentUser().getUid();

        //TODO: add navigaion drawer to this activity

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.v_pager_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Admin");
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
//        mAppBarConfiguration = new AppBarConfiguration.Builder()
//                .setDrawerLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this,R.id.container_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);

        initViewPager();

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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.admin_home_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();

        switch (itemId){

            case R.id.item_home:

                Toast.makeText(getApplicationContext(), "home clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_logout:
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login2FireStore.class);
                startActivity(intent);
                finish();

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void initViewPager() {
        ArrayList<Fragment> fragments =new ArrayList<>();
        fragments.add(new AdminHomeFragment());
        fragments.add(new AdminCatalogueFragment());
        fragments.add(new AdminOtherFragment());

        AdminTabsViewPagerAdapter adminTabs = new AdminTabsViewPagerAdapter(getSupportFragmentManager(),this, fragments);
        mViewPager.setAdapter(adminTabs);

        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setText("Home");
        tabLayout.getTabAt(1).setText("Catalogue");
        tabLayout.getTabAt(2).setText("Other");
    }
}

//TODO(1): Make a common ViewPagerAdapter for existing view pagers and tablayouts
//TODO(2): Safely remove activities which are already been copied inside fragments