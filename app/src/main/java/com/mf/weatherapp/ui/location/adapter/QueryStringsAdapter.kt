package com.mf.weatherapp.ui.location.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.mf.weatherapp.R
import com.mf.weatherapp.extensions.getInflater
import com.mf.weatherapp.ui.base.BaseAdapter
import kotlin.reflect.KFunction1

class QueryStringsAdapter(
    context: Context,
    private val resource: Int,
    objects: MutableList<String>
) :
    ArrayAdapter<String>(context, resource, objects) {

    fun setData(data: List<String>) {
        clear()
        addAll(data)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View =
        getViewWithCheck(convertView)!!.apply {
            findViewById<TextView>(R.id.query_item_query_value)?.run {
                text = getItem(position).orEmpty()
            }
        }


    private fun getViewWithCheck(convertView: View?) =
        convertView ?: context.getInflater().inflate(resource, null)

}