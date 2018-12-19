package com.google.sample.cast.refplayer.data.model

import com.google.sample.cast.refplayer.domain.model.Livestream

interface LivestreamDataModelMapper {

    fun map(source: LivestreamResponse): Livestream
}
