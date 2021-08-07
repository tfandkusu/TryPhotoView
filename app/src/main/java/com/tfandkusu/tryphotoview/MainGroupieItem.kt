package com.tfandkusu.tryphotoview

import android.view.View
import coil.load
import com.tfandkusu.tryphotoview.databinding.ListItemMainBinding
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem

class MainGroupieItem(
    private val index: Int,
    private val imageUrl: String,
    private val onClick: (index: Int) -> Unit
) :
    BindableItem<ListItemMainBinding>() {
    override fun bind(viewBinding: ListItemMainBinding, position: Int) {
        val context = viewBinding.root.context
        viewBinding.imageView.load(imageUrl)
        viewBinding.imageView.contentDescription =
            context.getString(R.string.content_description_image, index)
        viewBinding.root.setOnClickListener {
            onClick(index)
        }
    }

    override fun getLayout() = R.layout.list_item_main

    override fun initializeViewBinding(view: View) = ListItemMainBinding.bind(view)

    override fun isSameAs(other: Item<*>): Boolean {
        return if (other is MainGroupieItem) {
            index == other.index &&
                    imageUrl == other.imageUrl
        } else {
            false
        }
    }

    override fun hasSameContentAs(other: Item<*>): Boolean {
        return if (other is MainGroupieItem) {
            index == other.index &&
                    imageUrl == other.imageUrl
        } else {
            false
        }
    }
}
