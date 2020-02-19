package com.example.kartikonlinefirebase.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.kartikonlinefirebase.R;
import com.example.kartikonlinefirebase.adapters.AdminTabsViewPagerAdapter;
import com.example.kartikonlinefirebase.adapters.ProductTabsViewPagerAdapter;
import com.example.kartikonlinefirebase.fragments.AdminCatalogueFragment;
import com.example.kartikonlinefirebase.fragments.AdminHomeFragment;
import com.example.kartikonlinefirebase.fragments.AdminOtherFragment;
import com.example.kartikonlinefirebase.fragments.CatalogueItemInfoFragment;
import com.example.kartikonlinefirebase.fragments.CatalogueItemInventoryFragment;
import com.example.kartikonlinefirebase.fragments.CatalogueItemNotesFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditProductInfoActivity extends AppCompatActivity {

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.v_pager_prod)
    ViewPager mViewPager;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product_info);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit Product Info");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViewPager();

//        Gson gson = new Gson();
//        Type type = new TypeToken<List<Student>>() {}.getType();
//        String json = gson.toJson(students, type);
//        Intent intent = new Intent(getBaseContext(), YourActivity.class);
//        intent.putExtra(YourNextActivity.ADDITIONAL_STUDENTS, json);

    }



    private void initViewPager() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new CatalogueItemInfoFragment());
        fragments.add(new CatalogueItemInventoryFragment());
        fragments.add(new CatalogueItemNotesFragment());


        ProductTabsViewPagerAdapter productTabs = new ProductTabsViewPagerAdapter(getSupportFragmentManager(),this, fragments);
        mViewPager.setAdapter(productTabs);


        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setText("Product Info");
        tabLayout.getTabAt(1).setText("Inventory");
        tabLayout.getTabAt(2).setText("Notes");
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "item saved", Toast.LENGTH_LONG).show();
        super.onBackPressed();
    }
}