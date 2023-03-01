package com.kkc.summonerinfo.util

import android.content.Context
import android.util.TypedValue

fun convertDpToPx(context: Context, dpValue: Float): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.resources.displayMetrics).toInt()
}