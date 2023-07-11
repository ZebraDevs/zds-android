package com.zebra.zds

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.materialswitch.MaterialSwitch


class ZdsSwitch @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : MaterialSwitch(context, attrs) {
    init {
        setEnforceSwitchWidth(true)
    }
}