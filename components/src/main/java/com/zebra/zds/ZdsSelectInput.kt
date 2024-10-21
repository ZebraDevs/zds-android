package com.zebra.zds

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Color
import android.text.Editable
import android.util.AttributeSet
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.google.android.material.color.MaterialColors
import com.google.android.material.textfield.TextInputLayout


class ZdsSelectInput : FrameLayout {

    var errorString: String? = null
    var hintString: String? = null

    var errorText: AppCompatTextView? = null
    var infoIcon: AppCompatImageView? = null
    var textInputLayout: TextInputLayout? = null
    var textInputEditText: AutoCompleteTextView? = null

    constructor(context: Context) : super(context) {
        initialize(context, null, 0, 0)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initialize(context, attrs, 0, 0)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initialize(context, attrs, defStyleAttr, 0)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        initialize(context, attrs, defStyleAttr, defStyleRes)
    }

    private fun initialize(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) {
        val inflatedView = View.inflate(context, R.layout.select_input, null)
        val layoutParams =
            LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        addView(inflatedView, layoutParams)

        errorText = inflatedView.findViewById(R.id.textError)
        infoIcon = inflatedView.findViewById(R.id.info_icon)
        textInputLayout = inflatedView.findViewById(R.id.textInputLayout)
        textInputEditText = inflatedView.findViewById(R.id.textInputEditText)

        textInputLayout?.setEndIconTintList(
            ColorStateList.valueOf(
                ContextCompat.getColor(
                    context,
                    R.color.zebra_control
                )
            )
        )

        attrs?.let {
            val a: TypedArray = context.obtainStyledAttributes(it, R.styleable.ZdsSelectInput)

            // Hint property
            hintString = a.getString(R.styleable.ZdsSelectInput_hint)
            setHint(hintString)

            // Icons
            val startIconResId = a.getResourceId(R.styleable.ZdsSelectInput_startIconDrawable, 0)

            if (startIconResId != 0) {
                textInputLayout?.setStartIconDrawable(startIconResId)
                textInputLayout?.setStartIconTintList(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.textDisabled
                    )
                )
            }
            a.recycle()
        }
    }

    fun setError(error: String?) {
        errorString = error

        if (errorString?.isNotEmpty() == true) {
            errorText?.text = errorString
            errorText?.setTextColor(context.resources.getColor(R.color.zebra_red_enabled))
            errorText?.visibility = View.VISIBLE

            infoIcon?.imageTintList =
                ColorStateList.valueOf(resources.getColor(R.color.zebra_red_enabled))
            infoIcon?.visibility = View.VISIBLE

            textInputLayout?.boxStrokeColor = context.resources.getColor(R.color.zebra_red_enabled)
            textInputLayout?.setBoxBackgroundColorResource(R.color.zebra_red_error_background)
        } else if (hintString?.isNotEmpty() == true) {
            setHint(hintString)
        } else {
            errorText?.text = null
            errorText?.setTextColor(context.resources.getColor(R.color.textDisabled))
            errorText?.visibility = View.GONE

            infoIcon?.imageTintList =
                ColorStateList.valueOf(resources.getColor(R.color.textDisabled))
            infoIcon?.visibility = View.GONE

            textInputLayout?.boxStrokeColor = MaterialColors.getColor(
                context,
                R.attr.colorPrimary,
                Color.BLACK
            )
            textInputLayout?.boxBackgroundColor = Color.TRANSPARENT
        }
    }

    fun setHint(hint: String?) {
        hintString = hint

        if (hintString?.isNotEmpty() == true) {
            errorText?.text = hintString
            errorText?.setTextColor(context.resources.getColor(R.color.textDisabled))
            errorText?.visibility = View.VISIBLE

            infoIcon?.imageTintList =
                ColorStateList.valueOf(resources.getColor(R.color.textDisabled))
            infoIcon?.visibility = View.VISIBLE
        } else {
            errorText?.text = null
            errorText?.visibility = View.GONE
            infoIcon?.visibility = View.GONE
        }

        textInputLayout?.boxStrokeColor = MaterialColors.getColor(
            context,
            R.attr.colorPrimary,
            Color.BLACK
        )
        textInputLayout?.boxBackgroundColor = Color.TRANSPARENT
    }

    fun setText(text: Editable?) {
        textInputEditText?.text = text
    }

    fun getText(): Editable? {
        return textInputEditText?.text
    }

    fun setPlaceholder(placeholder: String?) {
        textInputEditText?.hint = placeholder
    }
}