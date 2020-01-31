package com.example.kartikonlinefirebase.activities;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.kartikonlinefirebase.R;
import com.example.kartikonlinefirebase.adapters.AdminTabsViewPagerAdapter;
import com.example.kartikonlinefirebase.adapters.OrderListViewPagerAdapter;
import com.example.kartikonlinefirebase.fragments.AdminCatalogueFragment;
import com.example.kartikonlinefirebase.fragments.AdminFragment;
import com.example.kartikonlinefirebase.fragments.AdminHome;
import com.example.kartikonlinefirebase.fragments.AdminOtherFragment;
import com.example.kartikonlinefirebase.fragments.ConfirmOrderFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Admin_Home extends AppCompatActivity {


  //  @BindView(R.id.admin_ol_tab)
    //TabItem adminOlTab;
    //@BindView(R.id.admin_co_tab)
    //TabItem adminCoTab;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.v_pager_admin)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__home);
        ButterKnife.bind(this);

        initViewPager();
    }
    private void initViewPager() {
        ArrayList<Fragment> fragments =new ArrayList<>();
        fragments.add(new AdminHome());
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
