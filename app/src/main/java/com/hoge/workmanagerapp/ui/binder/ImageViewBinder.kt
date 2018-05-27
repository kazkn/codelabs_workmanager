package com.hoge.workmanagerapp.ui.binder

import android.databinding.BindingAdapter
import android.graphics.Bitmap
import android.widget.ImageView

@BindingAdapter("bind:imageBitmap")
fun loadImage(iv: ImageView, bitmap: Bitmap) {
    iv.setImageBitmap(bitmap)
}