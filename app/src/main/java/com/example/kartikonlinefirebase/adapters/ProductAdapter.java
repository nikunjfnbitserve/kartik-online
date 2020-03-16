/**
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 package com.example.kartikonlinefirebase.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kartikonlinefirebase.R;
import com.example.kartikonlinefirebase.models.Product;
import com.google.firebase.firestore.Query;


/**
 * RecyclerView adapter for a bunch of Ratings.
 */
public class ProductAdapter extends FirestoreAdapter<ProductAdapter.ViewHolder> {

    public ProductAdapter(Query query) {
        super(query);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.products_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getSnapshot(position).toObject(Product.class));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView productImageView;
        ProgressBar progressBar;
        TextView productTitleTextView, productPriceTextView, productDiscountPriceTextView;
        TextView productSizeTextView, genderTextView, soleNameTextView, colorTextView, productDescriptionTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            productImageView = itemView.findViewById(R.id.iv_prod_image);
            progressBar = itemView.findViewById(R.id.pb_image_upload);
            productTitleTextView = itemView.findViewById(R.id.tv_prod_title);
            productPriceTextView = itemView.findViewById(R.id.tv_prod_price);
            productDiscountPriceTextView = itemView.findViewById(R.id.tv_prod_disc_price);
            productSizeTextView = itemView.findViewById(R.id.tv_prod_size);
            genderTextView = itemView.findViewById(R.id.tv_prod_gender);
            soleNameTextView = itemView.findViewById(R.id.tv_prod_sole_name);
            colorTextView = itemView.findViewById(R.id.tv_prod_color);
            productDescriptionTextView = itemView.findViewById(R.id.tv_prod_desc);
        }

        public void bind(Product product) {
            if(productImageView.getDrawable() != null){
                progressBar.setVisibility(View.GONE);
            }
            //productImageView.setImageBitmap(product.getImages().get());
            productTitleTextView.setText(product.getProductName());
            productPriceTextView.setText(product.getPrice());
            productDiscountPriceTextView.setText(product.getDiscountPrice() + "");
            productSizeTextView.setText(product.getSize());
            genderTextView.setText(product.getType());
            soleNameTextView.setText(product.getSoleName());
            colorTextView.setText(product.getColor());
            productDescriptionTextView.setText(product.getDescription());
        }
    }

}
