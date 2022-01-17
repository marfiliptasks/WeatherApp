package com.mf.weatherapp.ui.bindingAdapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.mf.domain.extensions.tryCast
import com.mf.weatherapp.ui.base.BaseAdapter
import com.mf.weatherapp.ui.location.adapter.QueryStringsAdapter

@BindingAdapter("data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, items: List<T>?) {
    items?.let {
        recyclerView.adapter.tryCast<BaseAdapter<T>> {
            setData(it)
        }
    }
}

@BindingAdapter("dropDownData")
fun setDropDownViewItems(autoCompleteView: MaterialAutoCompleteTextView, items: List<String>?) {
    items?.let {
        autoCompleteView.adapter.tryCast<QueryStringsAdapter> {
            setData(it)
        }
    }
}