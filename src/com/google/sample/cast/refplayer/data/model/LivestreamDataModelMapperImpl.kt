package com.google.sample.cast.refplayer.data.model

import com.google.gson.internal.bind.util.ISO8601Utils
import com.google.sample.cast.refplayer.domain.model.Livestream
import com.google.sample.cast.refplayer.domain.model.LivestreamItem
import java.text.ParseException
import java.text.ParsePosition
import java.util.Date
import javax.inject.Inject

class LivestreamDataModelMapperImpl @Inject constructor(): LivestreamDataModelMapper {

    override fun map(source: LivestreamResponse): Livestream {
        return Livestream(source.image.sizes.first { it.name == "display" }.url, source.image.sizes.first { it.name == "mosaic" }.url, map(source.items))
    }

    private fun map(source: List<LivestreamDataModel>): List<LivestreamItem> {
        return source.map {
            LivestreamItem(it.title, it.description, it.image.sizes.first { it.name == "display" }.url, it.image.sizes.first { it.name == "mosaic" }.url, getDate(it.begin), getDate(it.end), it.url)
        }
    }

    private fun getDate(date: String?): Date? {
        if (date == null) {
            return null
        }
        var result: Date? = null
        val parsePosition = ParsePosition(0)
        try {
            result = ISO8601Utils.parse(date, parsePosition)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return result
    }
}
