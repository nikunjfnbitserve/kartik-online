package com.example.kartikonlinefirebase.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
import com.example.kartikonlinefirebase.models.Product;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.ArrayList;

import io.opencensus.common.ToLongFunction;


public class EditProductInfoActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager mViewPager;
    Toolbar toolbar;

    public Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product_info);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.v_pager_prod);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit Product Info");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        product = new Product();
        initViewPager();

//        Gson gson = new Gson();
//        Type type = new TypeToken<List<Student>>() {}.getType();
//        String json = gson.toJson(students, type);
//        Intent intent = new Intent(getBaseContext(), YourActivity.class);
//        intent.putExtra(YourNextActivity.ADDITIONAL_STUDENTS, json);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "product saved", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

    public boolean onSupportNavigateUp() {
        //Toast.makeText(this, "item saved", Toast.LENGTH_SHORT).show();
        onBackPressed();
        return true;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_info_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_check: return false;

            default: return super.onOptionsItemSelected(item);
        }

    }

    public interface onMenuSaveButonClickListener{
        public void onMenuButonClick();
    }
}
