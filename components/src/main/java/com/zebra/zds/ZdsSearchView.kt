package com.zebra.zds

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.SearchView

class ZdsSearchView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : SearchView(context, attrs) {

    init {
        setBackgroundResource(R.drawable.searchview_bg)
        setOnQueryTextFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                setBackgroundResource(R.drawable.searchview_bg_selected)
            } else {
                setBackgroundResource(R.drawable.searchview_bg)
            }
        }
    }

}