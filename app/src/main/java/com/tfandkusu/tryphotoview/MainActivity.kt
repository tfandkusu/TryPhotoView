package com.tfandkusu.tryphotoview

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.tfandkusu.tryphotoview.databinding.ActivityMainBinding
import com.xwray.groupie.GroupieAdapter

class MainActivity : AppCompatActivity() {

    companion object {
        /**
         * 表示する画像リスト。
         * 画像はいらすとやさんより。
         */
        private val IMAGE_URLS = listOf(
            "https://2.bp.blogspot.com/-4SSFZUa0ab4/Vg57ivCMfhI/" +
                "AAAAAAAAyzQ/Pm4eBFxAaOc/s800/sweets_fruit_pafe.png",
            "https://1.bp.blogspot.com/-F1EaVL5t2zM/XZR9ftwga3I/" +
                "AAAAAAABVTY/t174NxuHwvghxBTg4Q31qNVon6FKuSBywCNcBGAsYHQ/s1600/" +
                "landmark_hokkaidou_kyuuhonchousya.png",
            "https://2.bp.blogspot.com/-PtiUwbxAtNc/U5hUb0EU7UI/" +
                "AAAAAAAAhJY/V0XJK0hKoEk/s800/food_jingisukan_genghis_khan.png",
            "https://4.bp.blogspot.com/-dN9u5FvIFg4/UrEgH7TCr_I/" +
                "AAAAAAAAb4I/Z_mQivZxrjI/s800/suizokukan_jinbeizame.png"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.addItemDecoration(MainItemDecoration())
        val adapter = GroupieAdapter()
        binding.recyclerView.adapter = adapter
        adapter.update(
            IMAGE_URLS.mapIndexed { index, imageUrl ->
                MainGroupieItem(index, imageUrl) { index, transitionView ->
                    callImageActivity(index, transitionView)
                }
            }
        )
    }

    private fun callImageActivity(index: Int, transitionView: View) {
        val intent = Intent(this, ImageActivity::class.java)
        intent.putStringArrayListExtra(ImageActivity.EXTRA_IMAGE_URLS, ArrayList(IMAGE_URLS))
        intent.putExtra(ImageActivity.EXTRA_INDEX, index)
        val options = ActivityOptions
            .makeSceneTransitionAnimation(this, transitionView, "image")
        startActivity(intent, options.toBundle())
    }
}
