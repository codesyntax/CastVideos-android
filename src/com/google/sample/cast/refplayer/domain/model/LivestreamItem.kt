package com.google.sample.cast.refplayer.domain.model

import java.util.Date

data class LivestreamItem(val name: String, val description: String, val coverURL: String, val mosaicCoverURL: String, val begin: Date?,
                          val end: Date?, val url: String)
