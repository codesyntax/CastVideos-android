package com.codesyntax.jarrion.ui.widget

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.sample.cast.refplayer.R
import kotlinx.android.synthetic.main.dialog_fragment_filter.*

class FilterDialogFragment: BottomSheetDialogFragment() {

    var onOptionClicked: (Int) -> Unit = {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        video.setOnClickListener { onOptionClicked(1) }
        podcast.setOnClickListener { onOptionClicked(2) }
        tv.setOnClickListener { onOptionClicked(3) }
        radio.setOnClickListener { onOptionClicked(4) }
    }
}
