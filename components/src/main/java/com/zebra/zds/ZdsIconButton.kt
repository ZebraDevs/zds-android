package com.zebra.zds

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import com.google.android.material.button.MaterialButton
import com.google.android.material.color.MaterialColors

class ZdsIconButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : MaterialButton(context, attrs, defStyle) {

    init {
        isEnabled = isEnabled
    }

    override fun setEnabled(enabled: Boolean) {

        iconTint = if (enabled) {
            val colorStateList = ColorStateList.valueOf(
                MaterialColors.getColor(
                    context,
                    R.attr.iconTint,
                    Color.BLACK
                )
            )
            colorStateList
        } else {
            val colorStateList = ColorStateList.valueOf(resources.getColor(R.color.textDisabled))
            colorStateList
        }

        super.setEnabled(enabled)
    }
}