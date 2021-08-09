package com.tfandkusu.tryphotoview

import android.os.Bundle
import android.transition.Transition
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import coil.load
import com.tfandkusu.tryphotoview.databinding.ActivityImageBinding
import com.xwray.groupie.GroupieAdapter

class ImageActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_IMAGE_URLS = "imageUrls"

        const val EXTRA_INDEX = "index"
    }

    private lateinit var binding: ActivityImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.apply {
            decorView.systemUiVisibility =
                // コンテンツをステータスバーの背後に表示する
                // https://developer.android.com/training/system-ui/status#behind
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                // コンテンツをナビゲーション バーの背後に表示する
                // https://developer.android.com/training/system-ui/navigation#behind
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        }

        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val imageUrls = intent.getStringArrayListExtra(EXTRA_IMAGE_URLS) ?: listOf<String>()
        val initialIndex = intent.getIntExtra(EXTRA_INDEX, 0)
        val adapter = GroupieAdapter()
        binding.viewPager.adapter = adapter
        adapter.update(
            imageUrls.map {
                ImageGroupieItem(it)
            }
        )
        binding.viewPager.offscreenPageLimit = 3
        binding.viewPager.setCurrentItem(initialIndex, false)

        window.sharedElementEnterTransition.addListener(object : Transition.TransitionListener {

            private var open: Boolean = true

            override fun onTransitionStart(p0: Transition?) {
                binding.viewPager.isVisible = false
                if (open) {
                    binding.transitionImageView.load(imageUrls[initialIndex])
                }
                val index = binding.viewPager.currentItem
                if (initialIndex == index) {
                    binding.transitionImageView.alpha = 1.0f
                }
            }

            override fun onTransitionEnd(p0: Transition?) {
                if (open) {
                    binding.viewPager.isVisible = true
                    binding.transitionImageView.alpha = 0.0f
                }
                open = false
            }

            override fun onTransitionCancel(p0: Transition?) {
            }

            override fun onTransitionPause(p0: Transition?) {
            }

            override fun onTransitionResume(p0: Transition?) {
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            finishAfterTransition()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}
