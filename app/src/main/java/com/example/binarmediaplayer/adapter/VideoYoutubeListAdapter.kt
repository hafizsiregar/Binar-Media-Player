package com.example.binarmediaplayer.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.example.binarmediaplayer.DetailVideoYoutubeActivity
import com.example.binarmediaplayer.R
import com.example.binarmediaplayer.model.VideoYoutubeModel
import jp.wasabeef.glide.transformations.BlurTransformation

class VideoYoutubeListAdapter(private val listVideoYoutube: ArrayList<VideoYoutubeModel>) :
RecyclerView.Adapter<VideoYoutubeListAdapter.ListViewHolder>(){

    inner class ListViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.iv_item_photo)
        var tvChannel: TextView = itemView.findViewById(R.id.tv_channel)
        var tvSpeaker: TextView = itemView.findViewById(R.id.tv_speaker)
        var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VideoYoutubeListAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_video_youtube, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoYoutubeListAdapter.ListViewHolder, position: Int) {
        val video = listVideoYoutube[position]

        holder.tvChannel.text = video.channel
        holder.tvSpeaker.text = video.speaker
        holder.tvTitle.text = video.title

        Glide.with(holder.itemView.context)
            .load(video.thumbnail)

            .apply(bitmapTransform(BlurTransformation(10, 1)))
            .into(holder.imgPhoto)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailVideoYoutubeActivity::class.java)
            intent.putExtra(DetailVideoYoutubeActivity.EXTRA_VIDEO_YOUTUBE, video)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listVideoYoutube.size
    }

}