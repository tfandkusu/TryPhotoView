package com.tfandkusu.tryphotoview

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView

class MainItemDecoration :
    RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        val dp = parent.resources.displayMetrics.density
        if (itemPosition % 2 == 0) {
            outRect.left = (16 * dp).toInt()
            outRect.right = (2 * dp).toInt()
        } else {
            outRect.left = (2 * dp).toInt()
            outRect.right = (16 * dp).toInt()
        }
        if (itemPosition < 2) {
            outRect.top = (16 * dp).toInt()
        } else {
            outRect.top = (4 * dp).toInt()
        }
    }
}
