package com.tfandkusu.tryphotoview

import android.net.Uri
import android.view.View
import com.squareup.picasso.Picasso
import com.tfandkusu.tryphotoview.databinding.ListItemImageBinding
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem

class ImageGroupieItem(private val imageUrl: String) : BindableItem<ListItemImageBinding>() {
    override fun bind(viewBinding: ListItemImageBinding, position: Int) {
        Picasso.get().load(Uri.parse(imageUrl)).into(viewBinding.photoView)
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
