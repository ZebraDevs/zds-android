package com.zebra.zds

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.color.MaterialColors

open class ZdsButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : MaterialButton(context, attrs, defStyle) {

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
            val colorStateList =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.textDisabled))
            setTextColor(colorStateList)
            iconTint = colorStateList
            backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.surfaceDisabled))
        }

        super.setEnabled(enabled)
    }
}