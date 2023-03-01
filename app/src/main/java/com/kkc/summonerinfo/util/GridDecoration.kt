package com.kkc.summonerinfo.util

import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class GridDecoration(
    private val topPadding: Int,
    private val leftPadding: Int,
    private val spanCount: Int,
    @ColorInt private val color: Int
) : RecyclerView.ItemDecoration() {
    private val paint = Paint()

    init {
        paint.color = color
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val column = position % spanCount + 1

        if (position >= spanCount){
            outRect.top = topPadding
        }

        if (column != 1){
            outRect.left = leftPadding
        }
    }
}
