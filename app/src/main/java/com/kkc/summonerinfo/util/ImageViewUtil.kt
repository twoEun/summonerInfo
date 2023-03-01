package com.kkc.summonerinfo.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("glideImage")
fun ImageView.setGlideImage(url: String?) {
    url?.let {
        Glide.with(this.context)
            .load(url)
            .into(this)
    }
}

@BindingAdapter("circleImage")
fun ImageView.setCircleCropImage(url: String?) {
    url?.let {
        Glide.with(this.context)
            .load(url)
            .circleCrop()
            .into(this)
    }
}

fun ImageView.setRoundedImage(url: String?, cornerRadius: Int) {
    url?.let {
        val requestOption = RequestOptions()
        requestOption.transform(CenterCrop(), RoundedCorners(cornerRadius))
        Glide.with(this.context)
            .load(it)
            .apply(requestOption)
            .into(this)
    }
}

@BindingAdapter("smallRoundImage")
fun ImageView.setSmallRoundImage(url: String?) {
    url?.let {
        val cornerRadius = convertDpToPx(this.context, 4f)
        val requestOption = RequestOptions()
        requestOption.transform(CenterCrop(), RoundedCorners(cornerRadius))
        Glide.with(this.context)
            .load(it)
            .apply(requestOption)
            .into(this)
    }
}
