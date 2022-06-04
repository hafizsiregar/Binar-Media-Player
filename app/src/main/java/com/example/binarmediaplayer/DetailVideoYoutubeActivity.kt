package com.example.binarmediaplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.binarmediaplayer.databinding.ActivityDetailVideoYoutubeBinding
import com.example.binarmediaplayer.model.VideoYoutubeModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class DetailVideoYoutubeActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_VIDEO_YOUTUBE = "extra_video_kajian"
    }

    private lateinit var binding: ActivityDetailVideoYoutubeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailVideoYoutubeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val video = intent.getParcelableExtra<VideoYoutubeModel>(EXTRA_VIDEO_YOUTUBE) as VideoYoutubeModel
        initView(video)
    }

    private fun initView(video: VideoYoutubeModel) {
        val youtubePlayerView: YouTubePlayerView = findViewById(R.id.player_video)
        lifecycle.addObserver(youtubePlayerView)

        youtubePlayerView.addYouTubePlayerListener(object :
            AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(video.urlVideo, 0f)
            }
        })

        binding.tvChannel.text = video.channel
        binding.tvTitle.text = video.title
        binding.tvSpeaker.text = video.speaker
        binding.tvSummary.text = video.summary

        binding.ivShare.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(
                Intent.EXTRA_TEXT,
                "Kajian dengan judul \"${video.title}\" dibawakan oleh \"${video.speaker}\" dan dari channel \"${video.channel}\" \n\n\n Link Video : https://www.youtube.com/watch?v=${video.urlVideo}"
            )
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }
    }
}