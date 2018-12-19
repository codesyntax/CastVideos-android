package com.google.sample.cast.refplayer.data.model

import com.google.gson.annotations.SerializedName

data class LivestreamDataModel(
    val description: String,
    val image: ImageDataModel,
    @SerializedName("livestream_begin") val begin: String,
    @SerializedName("livestream_end") val end: String,
    @SerializedName("livestream_source_url") val url: String,
    val title: String
)
