package com.example.kartikonlinefirebase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.example.kartikonlinefirebase.R;
import com.example.kartikonlinefirebase.adapters.AdminTabsViewPagerAdapter;
import com.example.kartikonlinefirebase.fragments.AdminCatalogueFragment;
import com.example.kartikonlinefirebase.fragments.AdminHomeFragment;
import com.example.kartikonlinefirebase.fragments.AdminOtherFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;

public class Admin_Home extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager mViewPager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        //TODO: add navigaion drawer to this activity

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.v_pager_admin);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Admin");

        initViewPager();
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
