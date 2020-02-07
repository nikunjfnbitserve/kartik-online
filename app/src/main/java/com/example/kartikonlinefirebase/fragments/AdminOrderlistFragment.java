package com.example.kartikonlinefirebase.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.kartikonlinefirebase.R;
import com.example.kartikonlinefirebase.adapters.OrderListViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdminOrderlistFragment extends Fragment {

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


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        ButterKnife.bind(getActivity());
        initViewPager();

        return  view;

    }

    private void initViewPager() {
        ArrayList<Fragment> fragments =new ArrayList<>();
        fragments.add(new ConfirmOrderFragment());
        fragments.add(new AdminOrderlistFragment());


        OrderListViewPagerAdapter pagerAdapter = new OrderListViewPagerAdapter(getActivity().getSupportFragmentManager(),getContext(), fragments);
        vPager.setAdapter(pagerAdapter);


        tabLayout.setupWithViewPager(vPager);
        tabLayout.getTabAt(0).setText("OrderList");
        tabLayout.getTabAt(1).setText("Confirm Order");
    }

}