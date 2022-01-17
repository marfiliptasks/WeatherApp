package com.mf.domain.dateUtils

import java.util.Calendar

fun getStartOfDay(): Calendar =
    Calendar.getInstance().apply {
        set(Calendar.MILLISECOND, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.HOUR_OF_DAY, 0)
    }

fun getEndOfDay(): Calendar =
    Calendar.getInstance().apply {
        set(Calendar.MILLISECOND, 9999)
        set(Calendar.SECOND, 59)
        set(Calendar.MINUTE, 59)

    }
