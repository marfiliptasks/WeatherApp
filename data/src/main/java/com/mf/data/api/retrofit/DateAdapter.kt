package com.mf.data.api.retrofit

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import java.util.*
import kotlin.math.roundToLong

class DateAdapter : JsonAdapter<Date>() {
    private companion object {
        const val TO_MILLS_MULTIPLIER = 1000
    }

    override fun fromJson(reader: JsonReader): Date =
        Date(getDateValue(reader.readJsonValue()))


    private fun getDateValue(value: Any?): Long =
        if (value is String) {
            value.toLong()
        } else {
            (value as Double * TO_MILLS_MULTIPLIER).roundToLong()
        }

    override fun toJson(writer: JsonWriter, value: Date?) {
        value?.run {
            writer.value(time.toString())
        }
    }
}