package com.zebra.zds

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import com.google.android.material.color.MaterialColors
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class ZdsExtendedFAB @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ExtendedFloatingActionButton(context, attrs) {

    init {
        isEnabled = isEnabled
    }

    override fun setEnabled(enabled: Boolean) {

        if (enabled) {
            val colorStateList = ColorStateList.valueOf(
                MaterialColors.getColor(
                    context,
                    R.attr.iconTint,
                    Color.BLACK
                )
            )
            iconTint = colorStateList
            setTextColor(colorStateList)
        } else {
            val colorStateList = ColorStateList.valueOf(resources.getColor(R.color.textDisabled))
            iconTint = colorStateList
            setTextColor(colorStateList)
        }

        super.setEnabled(enabled)
    }
}