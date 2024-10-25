package com.zebra.zds

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.materialswitch.MaterialSwitch


class ZdsSwitch @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : MaterialSwitch(context, attrs) {
    init {
        setEnforceSwitchWidth(true)
        isEnabled = isEnabled
    }

    override fun setEnabled(enabled: Boolean) {

        if (!enabled) {
            thumbTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.textDisabled))
            trackTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.surfaceDisabled))
        }

        super.setEnabled(enabled)
    }
}