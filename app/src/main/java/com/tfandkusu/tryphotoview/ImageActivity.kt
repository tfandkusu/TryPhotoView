package com.tfandkusu.tryphotoview

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.tfandkusu.tryphotoview.databinding.ActivityImageBinding
import com.xwray.groupie.GroupieAdapter

class ImageActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_IMAGE_URLS = "imageUrls"

        const val EXTRA_INDEX = "index"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val imageUrls = intent.getStringArrayListExtra(EXTRA_IMAGE_URLS) ?: listOf<String>()
        val index = intent.getIntExtra(EXTRA_INDEX, 0)
        val adapter = GroupieAdapter()
        binding.viewPager.adapter = adapter
        adapter.update(
            imageUrls.map {
                ImageGroupieItem(it)
            }
        )
        binding.viewPager.offscreenPageLimit = 3
        binding.viewPager.setCurrentItem(index, false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}
