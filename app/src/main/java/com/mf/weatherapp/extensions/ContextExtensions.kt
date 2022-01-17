package com.mf.weatherapp.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.core.content.res.use

fun Context.getInflater() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

@ColorInt
@SuppressLint("Recycle")
fun Context.themeColor(
    @AttrRes themeAttrId: Int
): Int =
    obtainStyledAttributes(intArrayOf(themeAttrId)).use {
        it.getColor(0, Color.MAGENTA)
    }
