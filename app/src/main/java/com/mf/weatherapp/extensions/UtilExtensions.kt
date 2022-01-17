package com.mf.weatherapp.extensions

import android.content.Context
import androidx.core.content.ContextCompat
import com.mf.weatherapp.R
import com.mf.weatherapp.ui.base.BaseState
import retrofit2.HttpException
import java.io.IOException

fun BaseState.pickColor(context: Context) =
    ContextCompat.getColor(context, if(isLoadingData) R.color.blue else R.color.red)

fun BaseState.getText(context: Context) = context.getString(if(isLoadingData) R.string.loading_data else error.getText())

fun Throwable?.getText() = when(this){
    is IOException -> R.string.connection_error
    is HttpException -> R.string.other_error
    else -> R.string.other_error
}