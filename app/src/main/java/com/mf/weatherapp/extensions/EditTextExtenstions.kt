package com.mf.weatherapp.extensions

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText


fun EditText.afterTextChanged(afterTextChanged: (Result<String>) -> Unit) {
    var previousValue: String? = null
    val pattern = Regex("^([a-zA-Z\\u0080-\\u024F]+(?:. |-| |'))*[a-zA-Z\\u0080-\\u024F]*\$")

    addTextChangedListener(object : TextWatcher {

        override fun afterTextChanged(editable: Editable?) {
            editable?.trim()?.toString()?.let {
                if (it != previousValue) {
                    it.publishIfMatches()
                }
            }
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            previousValue = s.trim().toString()
        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

        fun CharSequence.publishIfMatches() =
            if (pattern.matches(this)) {
                afterTextChanged.invoke(Result.success(toString()))
            } else {
                afterTextChanged.invoke(Result.failure(IllegalArgumentException()))
            }
    })
}




