package com.zebra.zds

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Color
import android.text.Editable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import com.google.android.material.color.MaterialColors
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textfield.TextInputLayout.END_ICON_CUSTOM


class ZdsTextInput : FrameLayout {

    var labelString: String? = null
    var errorString: String? = null
    var hintString: String? = null

    enum class LabelStyle {
        DEFAULT, MANDATORY, OPTIONAL
    }

    var labelStyle: LabelStyle = LabelStyle.DEFAULT

    var labelText: AppCompatTextView? = null
    var errorText: AppCompatTextView? = null
    var infoIcon: AppCompatImageView? = null
    var textInputLayout: TextInputLayout? = null
    var textInputEditText: TextInputEditText? = null
    var connectLeftLayout: LinearLayoutCompat? = null

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
        val inflatedView = View.inflate(context, R.layout.text_input, null)
        val layoutParams =
            LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        addView(inflatedView, layoutParams)

        labelText = inflatedView.findViewById(R.id.textLabel)
        errorText = inflatedView.findViewById(R.id.textError)
        infoIcon = inflatedView.findViewById(R.id.info_icon)
        textInputLayout = inflatedView.findViewById(R.id.textInputLayout)
        textInputEditText = inflatedView.findViewById(R.id.textInputEditText)
        connectLeftLayout = inflatedView.findViewById(R.id.connectLeftLayout)

        attrs?.let {
            val a: TypedArray = context.obtainStyledAttributes(it, R.styleable.ZdsTextInput)

            // Label style
            when (a.getInt(R.styleable.ZdsTextInput_label_style, 0)) {
                0 -> labelStyle = LabelStyle.DEFAULT
                1 -> labelStyle = LabelStyle.MANDATORY
                2 -> labelStyle = LabelStyle.OPTIONAL
            }

            // Label property
            labelString = a.getString(R.styleable.ZdsTextInput_label)
            setLabel(labelString)

            // Hint property
            hintString = a.getString(R.styleable.ZdsTextInput_hint)
            setHint(hintString)

            // Prefix and suffix texts
            val prefix = a.getString(R.styleable.ZdsTextInput_prefixText)
            val suffix = a.getString(R.styleable.ZdsTextInput_suffixText)
            textInputLayout?.prefixText = prefix
            textInputLayout?.suffixText = suffix

            // Icons
            val startIconResId = a.getResourceId(R.styleable.ZdsTextInput_startIconDrawable, 0)
            val endIconResId = a.getResourceId(R.styleable.ZdsTextInput_endIconDrawable, 0)

            if (startIconResId != 0) {
                textInputLayout?.setStartIconDrawable(startIconResId)
                textInputLayout?.setStartIconTintList(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.textDisabled
                    )
                )
            }

            if (endIconResId != 0) {
                textInputLayout?.endIconMode = END_ICON_CUSTOM
                textInputLayout?.setEndIconDrawable(endIconResId)
                textInputLayout?.setEndIconTintList(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.textDisabled
                    )
                )
            }

            a.recycle()
        }

        textInputLayout?.prefixTextView?.layoutParams?.apply {
            width = resources.getDimensionPixelSize(R.dimen.prefix_max_width)
        }
        textInputLayout?.suffixTextView?.layoutParams?.apply {
            width = resources.getDimensionPixelSize(R.dimen.prefix_max_width)
        }
    }

    fun setLabel(label: String?) {
        labelString = label

        when (labelStyle) {
            LabelStyle.DEFAULT -> labelText?.text = labelString
            LabelStyle.MANDATORY -> {
                val labelStringMandatory = SpannableString("$labelString*")
                labelStringMandatory.setSpan(
                    ForegroundColorSpan(resources.getColor(R.color.zebra_red_enabled)),
                    labelStringMandatory.length - 1,
                    labelStringMandatory.length,
                    Spanned.SPAN_INCLUSIVE_INCLUSIVE
                )
                labelText?.text = labelStringMandatory
            }
            LabelStyle.OPTIONAL -> {
                val optionalString = context.getString(R.string.optional)
                val labelStringOptional = SpannableString("$labelString $optionalString")
                labelStringOptional.setSpan(
                    ForegroundColorSpan(resources.getColor(R.color.textDisabled)),
                    labelStringOptional.length - optionalString.length,
                    labelStringOptional.length,
                    Spanned.SPAN_INCLUSIVE_INCLUSIVE
                )
                labelText?.text = labelStringOptional
            }
        }
    }

    fun setLabel(labelResId: Int) {
        labelString = context.getString(labelResId)
        setLabel(labelString)
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

    fun connectViewLeft(view: View) {
        while ((connectLeftLayout?.childCount ?: 0) > 1) {
            connectLeftLayout?.removeViewAt(0)
        }
        connectLeftLayout?.addView(view, 0)

        val radius = resources.getDimensionPixelSize(R.dimen.text_input_corner_radius) * 1f
        textInputLayout?.setBoxCornerRadii(0f, radius, 0f, radius)
    }

    fun removeConnectedViewLeft() {
        while ((connectLeftLayout?.childCount ?: 0) > 1) {
            connectLeftLayout?.removeViewAt(0)
        }
        val radius = resources.getDimensionPixelSize(R.dimen.text_input_corner_radius) * 1f
        textInputLayout?.setBoxCornerRadii(radius, radius, radius, radius)
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