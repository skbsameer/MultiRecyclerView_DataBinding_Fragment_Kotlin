package com.example.sample1

import android.widget.TextView
import androidx.databinding.BindingAdapter
import android.R

@BindingAdapter("textDate")
fun TextView.bindDate(bindDate: CharSequence?) {
   this.text = bindDate ?: ""
}





