package com.zebra.zds

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.radiobutton.MaterialRadioButton


class ZdsRadioButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : MaterialRadioButton(context, attrs) {

    init {
        isEnabled = isEnabled
        setOnCheckedChangeListener { _, _ ->
            setButton(isEnabled)
        }
    }

    override fun setEnabled(enabled: Boolean) {
        setButton(enabled)
        super.setEnabled(enabled)
    }

    private fun setButton(enabled: Boolean) {
        if (enabled || isChecked) {
            setButtonDrawable(R.drawable.abc_btn_radio_material_anim)
        } else {
            setButtonDrawable(R.drawable.radio_disabled_unchecked)
        }
    }
}