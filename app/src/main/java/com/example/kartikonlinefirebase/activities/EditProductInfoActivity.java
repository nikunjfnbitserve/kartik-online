package com.example.kartikonlinefirebase.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.palette.graphics.Palette;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.kartikonlinefirebase.R;
import com.example.kartikonlinefirebase.adapters.AdminTabsViewPagerAdapter;
import com.example.kartikonlinefirebase.adapters.ProductTabsViewPagerAdapter;
import com.example.kartikonlinefirebase.fragments.AdminCatalogueFragment;
import com.example.kartikonlinefirebase.fragments.AdminHomeFragment;
import com.example.kartikonlinefirebase.fragments.AdminOtherFragment;
import com.example.kartikonlinefirebase.fragments.CatalogueItemInfoFragment;
import com.example.kartikonlinefirebase.fragments.CatalogueItemInventoryFragment;
import com.example.kartikonlinefirebase.fragments.CatalogueItemNotesFragment;
import com.example.kartikonlinefirebase.interfaces.OnMenuSaveButonClickListener;
import com.example.kartikonlinefirebase.interfaces.TextWatcherInterface;
import com.example.kartikonlinefirebase.models.Product;
import com.example.kartikonlinefirebase.utils.BitmapTransformer;
import com.example.kartikonlinefirebase.utils.TabChangedEvent;
import com.example.kartikonlinefirebase.utils.TextChangedEvent;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import io.opencensus.common.ToLongFunction;


public class EditProductInfoActivity extends AppCompatActivity {

    private static final String TAG = "EditProductInfoActivity";
    TabLayout tabLayout;
    ViewPager mViewPager;
    ImageView productImageView;
    Toolbar toolbar;
    Intent imageDataIntent;
    private static final int MAX_WIDTH = 1024;
    private static final int MAX_HEIGHT = 768;
    Bitmap photo;
    //EventBus bus = EventBus.getDefault();
    //EventBus mBus = EventBus.getDefault();
    FloatingActionButton save_prod_info_fab;
//    OnMenuSaveButonClickListener mCallback;

//    public Product product;
    ArrayList<Fragment> fragments = new ArrayList<>();
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    public void onStart() {
        super.onStart();
        //mBus.register(this);
        //bus.register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        //mBus.unregister(this);
        //bus.unregister(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product_info);



        tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.v_pager_prod);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        save_prod_info_fab = (FloatingActionButton) findViewById(R.id.save_prod_info_fab);
        collapsingToolbarLayout = findViewById(R.id.collap_toolbar_layout);
        productImageView = findViewById(R.id.iv_header);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit Product Info");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageDataIntent = getIntent();
        if(imageDataIntent != null) {
            Uri imageUri = Uri.parse(imageDataIntent.getStringExtra("imageUri"));
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                Glide.with(this).load(bitmap).transform(new BitmapTransformer(MAX_WIDTH, MAX_HEIGHT)).into(productImageView);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        mCallback = (OnMenuSaveButonClickListener) this;

//        product = new Product();
        fragments.add(new CatalogueItemInfoFragment());
        fragments.add(new CatalogueItemInventoryFragment());
        fragments.add(new CatalogueItemNotesFragment());
        initViewPager();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                //bus.post(new TabChangedEvent());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




//        Gson gson = new Gson();
//        Type type = new TypeToken<List<Student>>() {}.getType();
//        String json = gson.toJson(students, type);
//        Intent intent = new Intent(getBaseContext(), YourActivity.class);
//        intent.putExtra(YourNextActivity.ADDITIONAL_STUDENTS, json);

        try {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.prof_pic);
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @SuppressWarnings("ResourceType")
                @Override
                public void onGenerated(Palette palette) {

                    int vibrantColor = palette.getVibrantColor(R.color.colorAccent);
                    int vibrantDarkColor = palette.getDarkVibrantColor(R.color.colorPrimary);
                    collapsingToolbarLayout.setContentScrimColor(vibrantColor);
                    collapsingToolbarLayout.setStatusBarScrimColor(vibrantDarkColor);
                }
            });

        } catch (Exception e) {
            // if Bitmap fetch fails, fallback to primary colors
            Log.e(TAG, "onCreate: failed to create bitmap from background", e.fillInStackTrace());
            collapsingToolbarLayout.setContentScrimColor(
                    ContextCompat.getColor(this, R.color.colorAccent)
            );
            collapsingToolbarLayout.setStatusBarScrimColor(
                    ContextCompat.getColor(this, R.color.colorPrimary)
            );
        }

    }

    @Subscribe
    public void onEvent(TextChangedEvent event){
        save_prod_info_fab.setVisibility(View.VISIBLE);
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

        ProductTabsViewPagerAdapter productTabs = new ProductTabsViewPagerAdapter(
                getSupportFragmentManager(),this, fragments);
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
            case R.id.item_check:
//                mCallback.onMenuButonClick();
                int selectedTab = tabLayout.getSelectedTabPosition();
                ((OnMenuSaveButonClickListener) fragments.get(selectedTab)).onMenuButonClick();
                return true;

            default: return super.onOptionsItemSelected(item);
        }

    }

}
