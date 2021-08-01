package com.tfandkusu.tryphotoview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tfandkusu.tryphotoview.databinding.ActivityMainBinding
import com.xwray.groupie.GroupieAdapter

class MainActivity : AppCompatActivity() {

    companion object {
        /**
         * 表示する画像リスト。
         * 画像はいらすとやさんより。
         */
        private val IMAGE_URLS = listOf(
            "https://1.bp.blogspot.com/-LDQjratJYoM/YHDkNRgd1XI/AAAAAAABdl8/h5yxEkLKmBcXC6-GXJsoOIzJsCDWd5sMACNcBGAsYHQ/s845/landmark_tausyubetsu_bridge.png",
            "https://1.bp.blogspot.com/-tN6cxEx1kvM/X7zMFOAnmQI/AAAAAAABcX4/4UjrbGfFHIE59wHINvkF03bzXmL3FzMSACNcBGAsYHQ/s1920/bg_lavender_flower.jpg",
            "https://1.bp.blogspot.com/-0XUYPcO40n8/X5OcHdsaQTI/AAAAAAABb5M/9FW4NZlp5oklDgUSqAa9i3cekGp8PjGQACNcBGAsYHQ/s1920/bg_natural_river.jpg",
            "https://1.bp.blogspot.com/-YnNw0nmy5WY/X5OcdKUoDhI/AAAAAAABb-w/Ws-6a4R4Io4IAWwuxtx8ilCxY9RgmKGHgCNcBGAsYHQ/s1005/nature_ocean_kaisou.png"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = GroupieAdapter()
        binding.viewPager.adapter = adapter
        adapter.update(IMAGE_URLS.map {
            ImageGroupieItem(it)
        })
    }
}
