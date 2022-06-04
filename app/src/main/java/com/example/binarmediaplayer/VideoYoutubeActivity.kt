package com.example.binarmediaplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.binarmediaplayer.adapter.VideoYoutubeListAdapter
import com.example.binarmediaplayer.data.VideoYoutubeData
import com.example.binarmediaplayer.databinding.ActivityVideoYoutubeBinding
import com.example.binarmediaplayer.model.VideoYoutubeModel

class VideoYoutubeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoYoutubeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoYoutubeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initNavMenu()
    }

    private fun initNavMenu() {
        val list: ArrayList<VideoYoutubeModel> = arrayListOf()
        binding.rvVideoYoutube.setHasFixedSize(true)
        list.addAll(VideoYoutubeData.listData)
        binding.rvVideoYoutube.layoutManager = LinearLayoutManager(this)
        val listVideoAdapter = VideoYoutubeListAdapter(list)
        binding.rvVideoYoutube.adapter = listVideoAdapter
    }
}