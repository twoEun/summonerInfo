package com.kkc.entity.util

fun notCompleteImageUrlCompletetion(url: String?): String? {
    return if (url.isNullOrEmpty()) {
        null
    } else {
        if (url.startsWith("https")) {
            url
        } else {
            "https://${url}"
        }
    }
}