package com.kkc.summonerinfo.util // ktlint-disable filename

import android.os.Build
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("numberText")
fun TextView.setNumberText(number: Int?) {
    number?.let {
        this.text = it.toString()
    }
}

@BindingAdapter("textColor")
fun TextView.setTextColor(colorRes: Int?) {
    colorRes?.let {
        this.setTextColor(this.context.getColor(it))
    }
}

@BindingAdapter("spannedText")
fun TextView.setSpannedText(originText: String) {
    val spannedText = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(originText, FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(originText)
    }

    this.text = spannedText
}
