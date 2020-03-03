package com.example.kartikonlinefirebase.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;
import com.example.kartikonlinefirebase.R;
import com.example.kartikonlinefirebase.activities.EditProductInfoActivity;
import com.example.kartikonlinefirebase.interfaces.OnMenuSaveButonClickListener;
import com.example.kartikonlinefirebase.models.Product;
import com.example.kartikonlinefirebase.utils.Config;
import com.example.kartikonlinefirebase.viewmodels.CatalogueProductViewModel;
import com.example.kartikonlinefirebase.viewmodels.ProductViewModel;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import static com.example.kartikonlinefirebase.utils.Config.mStaticProduct;

public class CatalogueItemInfoFragment extends Fragment implements OnMenuSaveButonClickListener {

    private List<Product> productList;
    EditProductInfoActivity editProductInfoActivity;

    AutoCompleteTextView cnQtyDropdown, setQtyDropdown, sizeSelectDropdown,
            colorSelectDropdown, catSelectDropdown, genderDropdown;



    private EditText productNameText, productPriceText, productDiscountPriceText,
            productCartonQuantityText, productSetQuantityText,
            productSizeText, productSizeSelectionText, productColorText,
            productColorSelectionText, productCatagoryText, productSortTagsText,
            productGenderText,productSoleNameText, productDescriptionText ;

    private CatalogueProductViewModel catalogueProductViewModel;
    private ProductViewModel productViewModel;


    public CatalogueItemInfoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        catalogueProductViewModel = ViewModelProviders.of(requireActivity()).get(CatalogueProductViewModel.class);
        productViewModel = ViewModelProviders.of(requireActivity()).get(ProductViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_catalogue_item_info, container, false);

        genderDropdown = view.findViewById(R.id.gender_dropdown);
        productNameText = view.findViewById(R.id.et_item_name);
        productPriceText = view.findViewById(R.id.et_item_price);
        productDiscountPriceText = view.findViewById(R.id.et_item_disc_price);
        productSizeText = (EditText) view.findViewById(R.id.et_item_size);
        productColorText = (EditText) view.findViewById(R.id.et_item_color);
        productSortTagsText = (EditText) view.findViewById(R.id.et_item_sort_tags);
        productSoleNameText = (EditText) view.findViewById(R.id.et_item_sole_name);
        productDescriptionText = (EditText) view.findViewById(R.id.et_item_desc);

        String[] GENDERS = new String[] {"Men", "Women", "Kids"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        getContext(),
                        R.layout.support_simple_spinner_dropdown_item,
                        GENDERS);


        genderDropdown.setAdapter(adapter);

        //setHasOptionsMenu(true);

        editProductInfoActivity = (EditProductInfoActivity) getActivity();

        if(Config.mStaticProductList.size() == 0){
            productList = new ArrayList<>();

        } else {
            productList = Config.getmStaticProductList();
            Log.e("static product list", "prev prod " +productList.isEmpty());
        }

        //TODO: get data from firebase for already existing items in a catalogue
        //TODO: set this data in respective Views if the user has come from an already created catalogue
        //TODO: create a spinner for categories
        //TODO: populate spinner array from firebase realtimedatabase
        //TODO: in AdminOtherFragment create categories to add to firebase realtimedatabase


//        productCartonQuantityText = (EditText) view.findViewById(R.id.et_item_cn_qty);
//        productSetQuantityText = (EditText) view.findViewById(R.id.et_item_set_qty);
//
//        productSizeSelectionText = (EditText) view.findViewById(R.id.et_item_size_sel);
//
//        productColorSelectionText = (EditText) view.findViewById(R.id.et_item_color_sel);
//        productCatagoryText = (EditText) view.findViewById(R.id.et_item_cat);
//
//        productGenderText = (EditText) view.findViewById(R.id.et_item_gender);





        return view;
    }

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()){
//            case R.id.item_check:
//                setItemFromItemForm();
//                Toast.makeText(getActivity(), "item info saved", Toast.LENGTH_SHORT).show();
//                Log.e("CatalogueInfo", "item info saved " + mStaticProduct.getProductName());
//                return true;
//
//
//            default: break;
//        }
//
//        return false;
//    }

    public void setItemFromItemForm() {

        if (TextUtils.isEmpty(productNameText.getText())) {
            productNameText.setError("item Name can't be empty");
        } else if (TextUtils.isEmpty(productPriceText.getText())) {
            productPriceText.setError("price can't be empty");
        } else if (TextUtils.isEmpty(productDiscountPriceText.getText())) {
            productDiscountPriceText.setError("price can't be empty");
        } else if (TextUtils.isEmpty(productCartonQuantityText.getText())) {
            productCartonQuantityText.setError("quantity can't be empty");
        } else if (TextUtils.isEmpty(productSetQuantityText.getText())) {
            productSetQuantityText.setError("quantity can't be empty");
        } else if (TextUtils.isEmpty(productSizeText.getText())) {
            productSizeText.setError("size can't be empty");
        } else if (TextUtils.isEmpty(productSizeSelectionText.getText())) {
            productSizeSelectionText.setError("size selection can't be empty");
        } else if(TextUtils.isEmpty(productColorText.getText())){
            productColorText.setError("color can't be empty");
        } else if(TextUtils.isEmpty(productColorSelectionText.getText())){
            productColorSelectionText.setError("color selection cant be empty");
        } else if(TextUtils.isEmpty(productCatagoryText.getText())) {
            productCatagoryText.setError("category can't be empty");
        } else if(TextUtils.isEmpty(productSortTagsText.getText())){
            productSortTagsText.setError("sort tags can't be empty");
        } else if(TextUtils.isEmpty(productGenderText.getText())){
            productGenderText.setError("gender can't be empty");
        } else if(TextUtils.isEmpty(productSoleNameText.getText())){
            productSoleNameText.setError("sole name cant be empty");
        } else if(TextUtils.isEmpty(productDescriptionText.getText())){
            productDescriptionText.setError("description can't be empty");
        } else {
            try {
                productViewModel.setProductName(productNameText.getText().toString());
                productViewModel.setPrice(Integer.parseInt(productPriceText.getText().toString()));
                productViewModel.setDiscountPrice(Double.parseDouble(productDiscountPriceText.getText().toString()));
                productViewModel.setCartonQuanity(Integer.parseInt(productCartonQuantityText.getText().toString()));
                productViewModel.setSetQuantity(Integer.parseInt(productSetQuantityText.getText().toString()));
                productViewModel.setSize(productSizeText.getText().toString());
                productViewModel.setSizeSelection(productSizeSelectionText.getText().toString());
                productViewModel.setColor(productColorText.getText().toString());
                productViewModel.setColorSelection(productColorSelectionText.getText().toString());
                productViewModel.setSortTags(productSortTagsText.getText().toString());
                productViewModel.setType(productGenderText.getText().toString());
                productViewModel.setSoleName(productSoleNameText.getText().toString());
                productViewModel.setDescription(productDescriptionText.getText().toString());
                productViewModel.setCategoryName(productCatagoryText.getText().toString());
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Fill all the details correctly", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
            Logger.e("CatalogueItemInfo " + productViewModel.getProductName().getValue());
            Logger.e("CatalogueItemInfo " + productViewModel.getNotes().getValue());

            mStaticProduct.setProductName(productViewModel.getProductName().getValue());
            mStaticProduct.setPrice(productViewModel.getPrice().getValue());
            mStaticProduct.setDiscountPrice(productViewModel.getDiscountPrice().getValue());
            mStaticProduct.setCartonQuanity(productViewModel.getCartonQuanity().getValue());
            mStaticProduct.setSetQuantity(productViewModel.getSetQuantity().getValue());
            mStaticProduct.setSize(productViewModel.getSize().getValue());
            mStaticProduct.setSizeSelection(productViewModel.getSizeSelection().getValue());
            mStaticProduct.setColor(productViewModel.getColor().getValue());
            mStaticProduct.setColorSelection(productViewModel.getColorSelection().getValue());
            mStaticProduct.setSortTags(productViewModel.getSortTags().getValue());
            mStaticProduct.setType(productViewModel.getType().getValue());
            mStaticProduct.setSoleName(productViewModel.getSoleName().getValue());
            mStaticProduct.setDescription(productViewModel.getDescription().getValue());
            mStaticProduct.setCategoryName(productViewModel.getCategoryName().getValue());

//        productList.add(product);
//
//        Config.setmStaticProduct(product);
//        Config.setmStaticProductList(productList);

        }
    }
    boolean myIsDigitsOnly(String str) {
        if(str.isEmpty()) {
            return false;
        } else {
            return TextUtils.isDigitsOnly(str);
        }
    }


    @Override
    public void onMenuButonClick() {
        setItemFromItemForm();
    }
}
