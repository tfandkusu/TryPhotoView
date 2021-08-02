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
            "https://2.bp.blogspot.com/-4SSFZUa0ab4/Vg57ivCMfhI/AAAAAAAAyzQ/Pm4eBFxAaOc/s800/sweets_fruit_pafe.png",
            "https://1.bp.blogspot.com/-F1EaVL5t2zM/XZR9ftwga3I/AAAAAAABVTY/t174NxuHwvghxBTg4Q31qNVon6FKuSBywCNcBGAsYHQ/s1600/landmark_hokkaidou_kyuuhonchousya.png",
            "https://2.bp.blogspot.com/-PtiUwbxAtNc/U5hUb0EU7UI/AAAAAAAAhJY/V0XJK0hKoEk/s800/food_jingisukan_genghis_khan.png",
            "https://4.bp.blogspot.com/-dN9u5FvIFg4/UrEgH7TCr_I/AAAAAAAAb4I/Z_mQivZxrjI/s800/suizokukan_jinbeizame.png"
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
        binding.viewPager.offscreenPageLimit = 3
    }
}
