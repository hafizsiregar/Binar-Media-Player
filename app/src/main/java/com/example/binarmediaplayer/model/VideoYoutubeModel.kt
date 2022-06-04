package com.example.binarmediaplayer.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoYoutubeModel(
    var thumbnail: Int = 0,
    var channel: String = "",
    var speaker: String = "",
    var title: String = "",
    var urlVideo: String = "",
    var summary: String = ""
) :Parcelable
