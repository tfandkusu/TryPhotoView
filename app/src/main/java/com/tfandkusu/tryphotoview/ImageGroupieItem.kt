package com.tfandkusu.tryphotoview

import android.view.View
import coil.load
import com.tfandkusu.tryphotoview.databinding.ListItemImageBinding
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem

class ImageGroupieItem(private val imageUrl: String) : BindableItem<ListItemImageBinding>() {
    override fun bind(viewBinding: ListItemImageBinding, position: Int) {
        viewBinding.photoView.load(imageUrl) {
            crossfade(true)
        }
    }

    override fun getLayout() = R.layout.list_item_image

    override fun initializeViewBinding(view: View) = ListItemImageBinding.bind(view)

    override fun isSameAs(other: Item<*>): Boolean {
        return if (other is ImageGroupieItem) {
            imageUrl == other.imageUrl
        } else {
            false
        }
    }

    override fun hasSameContentAs(other: Item<*>): Boolean {
        return if (other is ImageGroupieItem) {
            imageUrl == other.imageUrl
        } else {
            false
        }
    }
}
