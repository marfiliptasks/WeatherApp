package com.mf.weatherapp.ui.location.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mf.weatherapp.databinding.LocationItemBinding
import com.mf.weatherapp.model.location.LocationModel
import com.mf.weatherapp.ui.base.BaseAdapter
import com.mf.weatherapp.ui.base.ItemClickListener
import kotlin.properties.Delegates

class LocationAdapter(
    private val itemClickListener: ItemClickListener<LocationModel>,
) : BaseAdapter<LocationModel>() {

    override var items: List<LocationModel> by Delegates.observable(listOf()) { _, oldValue, newValue ->
        DiffUtil.calculateDiff(LocationDiffCallback(oldValue, newValue)).run {
            dispatchUpdatesTo(this@LocationAdapter)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LocationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolder){
            holder.bind(items[position])
        }
    }

    override fun setData(data: List<LocationModel>) {
        this.items = data
    }

    inner class ViewHolder(private val binding: LocationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LocationModel) {
            with(binding){
                this.item = item
                card = locationItemCard
                onClickListener = itemClickListener
                executePendingBindings()
            }
        }
    }
}