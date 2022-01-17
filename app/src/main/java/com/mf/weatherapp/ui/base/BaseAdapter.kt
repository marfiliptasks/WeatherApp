package com.mf.weatherapp.ui.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    abstract fun setData(data: List<T>)
    protected abstract val items: List<T>
    override fun getItemCount(): Int = items.count()
}