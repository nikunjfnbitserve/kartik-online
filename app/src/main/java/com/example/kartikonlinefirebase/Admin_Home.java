package com.example.kartikonlinefirebase;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Admin_Home extends AppCompatActivity {

    @BindView(R.id.admin_vis_tv)
    TextView adminVisTv;
    @BindView(R.id.admin_live_tv)
    TextView adminLiveTv;
    @BindView(R.id.admin_total_tv)
    TextView adminTotalTv;
    @BindView(R.id.ad_ac_s)
    Switch adAcS;
    @BindView(R.id.ad_store_s)
    Switch adStoreS;
    @BindView(R.id.ad_cod_s)
    Switch adCodS;
  //  @BindView(R.id.admin_ol_tab)
    //TabItem adminOlTab;
    //@BindView(R.id.admin_co_tab)
    //TabItem adminCoTab;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.v_pager)
    ViewPager vPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__home);
        ButterKnife.bind(this);

        initViewPager();
    }
    private void initViewPager() {
        ArrayList<Fragment> fragments =new ArrayList<>();
        fragments.add(new ConfirmOrderFragment());
        fragments.add(new AdminFragment());


        OrderListViewPagerAdapter pagerAdapter = new OrderListViewPagerAdapter(getSupportFragmentManager(),this, fragments);
        vPager.setAdapter(pagerAdapter);


        tabLayout.setupWithViewPager(vPager);
        tabLayout.getTabAt(0).setText("OrderList");
        tabLayout.getTabAt(1).setText("Confirm Order");
    }

}
