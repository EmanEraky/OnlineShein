package com.eman.onlineshein.utils

import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


@BindingAdapter("android:ImagePath")
fun setImageUrl(view: AppCompatImageView, path: String?) {
    if (path != null)
        if (!path.equals("")) {
            Glide.with(view.getContext()).asBitmap().load(path)
                .diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().into(view)
        }
}


@BindingAdapter("android:productRate")
fun setRatingProduct(view: RatingBar, rate: Float) {
    view.rating = rate
}
