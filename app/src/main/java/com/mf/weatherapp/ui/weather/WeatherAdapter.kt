package com.mf.weatherapp.ui.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mf.weatherapp.databinding.WeatherItemBinding
import com.mf.weatherapp.model.weather.WeatherInfoModel
import com.mf.weatherapp.ui.base.BaseAdapter

class WeatherAdapter(override val items: List<WeatherInfoModel>) : BaseAdapter<WeatherInfoModel>() {
    override fun setData(data: List<WeatherInfoModel>) {
        with(items as MutableList) {
            clear()
            addAll(data)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAdapter.ViewHolder =
        ViewHolder(WeatherItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(items[position])
        }
    }

    inner class ViewHolder(private val binding: WeatherItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WeatherInfoModel) {
            with(binding) {
                this.item = item
                executePendingBindings()
            }
        }
    }
}