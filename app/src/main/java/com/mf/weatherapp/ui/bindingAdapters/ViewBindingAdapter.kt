package com.mf.weatherapp.ui.bindingAdapters

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.snackbar.Snackbar
import com.mf.weatherapp.extensions.getText
import com.mf.weatherapp.ui.base.BaseState

@BindingAdapter("state")
fun setState(view: View, state: BaseState?) {
    state?.run {
        if (isLoadingData || error != null) {
            Snackbar.make(view, state.getText(view.context), Snackbar.LENGTH_SHORT).show()
        }
    }
}

@BindingAdapter(value = ["value", "shouldSetColor"])
fun setColor(view: TextView, value: String, shouldSetColor: Boolean) {
    if (shouldSetColor) {
        view.setTextColor(value.toDouble().getTextColor())
    }
}

private fun Double.getTextColor(): Int = when {
    this < 10.0 -> Color.BLUE
    this in 10.0..20.0 -> Color.BLACK
    else -> Color.RED
}
