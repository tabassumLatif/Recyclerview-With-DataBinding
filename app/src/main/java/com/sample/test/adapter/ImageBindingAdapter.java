package com.sample.test.adapter;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.sample.test.R;
import com.squareup.picasso.Picasso;

public class ImageBindingAdapter {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        if (url != null) {
            if (!url.equals("")) {
                try {
                    Picasso.with(imageView.getContext()).load(url).placeholder(R.mipmap.ic_launcher).into(imageView);
                } catch (NullPointerException e) {
                    Log.d("", "image exception " + e);
                }
            }
        }
    }
}