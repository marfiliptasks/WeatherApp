package com.mf.weatherapp.ui.base

import android.view.View

interface ItemClickListener<T> {
    fun onItemClicked(item: T, view: View)
}