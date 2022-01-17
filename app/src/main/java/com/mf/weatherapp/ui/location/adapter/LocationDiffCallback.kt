package com.mf.weatherapp.ui.location.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mf.weatherapp.model.location.LocationModel

class LocationDiffCallback(
    private val oldList: List<LocationModel>,
    private val newList: List<LocationModel>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].name == newList[newItemPosition].name

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}