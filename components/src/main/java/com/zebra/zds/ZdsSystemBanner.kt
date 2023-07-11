package com.zebra.zds

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat


class ZdsSystemBanner : FrameLayout {

    var titleString: String? = null
        set(value) {
            field = value
            title?.text = value
        }

    var arrowImage: ZdsIconButton? = null
    var titleImage: AppCompatImageView? = null
    var title: AppCompatTextView? = null

    enum class Style {
        DEFAULT, POSITIVE, WARNING, NEGATIVE
    }

    var style: Style = Style.DEFAULT
        set(value) {
            field = value
            applyStyle(field)
        }

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
        val inflatedView = View.inflate(context, R.layout.system_banner, null)
        val layoutParams =
            LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        addView(inflatedView, layoutParams)

        title = findViewById(R.id.title)
        titleImage = findViewById(R.id.image)
        arrowImage = findViewById(R.id.arrow)

        attrs?.let {
            val a: TypedArray = context.obtainStyledAttributes(it, R.styleable.ZdsSystemBanner)

            // Banner style
            when (a.getInt(R.styleable.ZdsSystemBanner_system_banner_style, 0)) {
                0 -> style = Style.DEFAULT
                1 -> style = Style.POSITIVE
                2 -> style = Style.WARNING
                3 -> style = Style.NEGATIVE
            }

            // Title property
            titleString = a.getString(R.styleable.ZdsSystemBanner_title)

            // Title centered property
            val titleCentered = a.getBoolean(R.styleable.ZdsSystemBanner_title_centered, false)
            centerTitle(titleCentered)

            a.recycle()
        }

        applyStyle(style)
    }

    fun centerTitle(titleCentered: Boolean) {
        val mainLayout = findViewById<ConstraintLayout>(R.id.background)
        if (titleCentered) {
            val constraintSet = ConstraintSet()
            constraintSet.clone(mainLayout)
            constraintSet.connect(
                R.id.titleLayout,
                ConstraintSet.END,
                PARENT_ID,
                ConstraintSet.END,
                0
            )
            constraintSet.applyTo(mainLayout)
        } else {
            val constraintSet = ConstraintSet()
            constraintSet.clone(mainLayout)
            constraintSet.clear(
                R.id.titleLayout,
                ConstraintSet.END
            )
            constraintSet.applyTo(mainLayout)
        }
    }

    private fun applyStyle(style: Style) {
        var colorTint = ContextCompat.getColor(context, R.color.textPrimary)
        var colorBackground = ContextCompat.getColor(context, R.color.zebra_blue_enabled)
        var iconResId = R.drawable.ic_error

        when (style) {
            Style.DEFAULT -> {
                colorTint = ContextCompat.getColor(context, R.color.textPrimary)
                colorBackground = ContextCompat.getColor(context, R.color.zebra_blue_enabled)
                iconResId = R.drawable.ic_error
            }
            Style.POSITIVE -> {
                colorTint = ContextCompat.getColor(context, R.color.textPrimary)
                colorBackground = ContextCompat.getColor(context, R.color.zebra_green_system_banner)
                iconResId = R.drawable.ic_check_circle
            }
            Style.WARNING -> {
                colorTint = ContextCompat.getColor(context, R.color.textPrimaryVariant)
                colorBackground =
                    ContextCompat.getColor(context, R.color.zebra_yellow_system_banner)
                iconResId = R.drawable.ic_round_warning
            }
            Style.NEGATIVE -> {
                colorTint = ContextCompat.getColor(context, R.color.textPrimary)
                colorBackground = ContextCompat.getColor(context, R.color.zebra_red_enabled)
                iconResId = R.drawable.ic_error
            }
        }

        titleImage?.imageTintList = ColorStateList.valueOf(colorTint)
        titleImage?.setImageResource(iconResId)
        title?.setTextColor(colorTint)
        arrowImage?.iconTint = ColorStateList.valueOf(colorTint)
        findViewById<ConstraintLayout>(R.id.background).setBackgroundColor(colorBackground)
    }
}