package com.google.sample.cast.refplayer.domain.interactor

import com.google.sample.cast.refplayer.domain.model.Livestream

interface GetLivestreamInteractor {
    fun execute(callback: Callback)

    interface Callback {
        fun onSuccess(livestream: Livestream)
    }
}
