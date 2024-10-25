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
import androidx.core.content.ContextCompat
import com.google.android.material.card.MaterialCardView

class ZdsBanner : FrameLayout {

    var titleString: String? = null
        set(value) {
            field = value
            title?.text = value
        }
    var messageString: String? = null
        set(value) {
            field = value
            message?.text = value
        }

    var card: MaterialCardView? = null
    var titleImage: AppCompatImageView? = null
    var title: AppCompatTextView? = null
    var message: AppCompatTextView? = null

    var closeButton: ZdsIconButton? = null
    var closeAction: OnClickListener? = null

    var actionButtonOne: ZdsButton? = null
    var actionButtonTwo: ZdsButton? = null


    enum class Style {
        DEFAULT, INFO, POSITIVE, WARNING, NEGATIVE
    }

    var style: Style = Style.DEFAULT
        set(value) {
            field = value
            applyStyle(field)
        }

    var isSharp: Boolean = false
        set(value) {
            field = value
            applySharpStyle(field)
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
        val inflatedView = View.inflate(context, R.layout.banner, null)
        val layoutParams =
            LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        addView(inflatedView, layoutParams)

        card = findViewById(R.id.bannerCard)
        title = findViewById(R.id.title)
        message = findViewById(R.id.message)
        titleImage = findViewById(R.id.image)
        closeButton = findViewById(R.id.close)
        actionButtonOne = findViewById(R.id.actionOne)
        actionButtonTwo = findViewById(R.id.actionTwo)

        actionButtonOne?.visibility = GONE
        actionButtonTwo?.visibility = GONE

        attrs?.let {
            val a: TypedArray = context.obtainStyledAttributes(it, R.styleable.ZdsBanner)

            // Banner style
            when (a.getInt(R.styleable.ZdsBanner_banner_style, 0)) {
                0 -> style = Style.DEFAULT
                1 -> style = Style.INFO
                2 -> style = Style.POSITIVE
                3 -> style = Style.WARNING
                4 -> style = Style.NEGATIVE
            }

            // Sharp style
            isSharp = a.getBoolean(R.styleable.ZdsBanner_isSharp, false)

            // Message property
            messageString = a.getString(R.styleable.ZdsBanner_message)

            // Title property
            titleString = a.getString(R.styleable.ZdsBanner_title)

            a.recycle()
        }

        applyStyle(style)
        applySharpStyle(isSharp)

        closeButton?.setOnClickListener { v ->
            closeAction?.onClick(v)
        }
    }

    private fun applyStyle(style: Style) {
        var colorTint = ContextCompat.getColor(context, R.color.zebra_control)
        var colorStroke = ContextCompat.getColor(context, R.color.zebra_grey_subtle_stroke)
        var colorBackground = ContextCompat.getColor(context, R.color.zebra_control_inverse)
        var iconResId = R.drawable.ic_info_sharp

        when (style) {
            Style.DEFAULT -> {
                colorTint = ContextCompat.getColor(context, R.color.zebra_control)
                colorStroke = ContextCompat.getColor(context, R.color.zebra_grey_subtle_stroke)
                colorBackground = ContextCompat.getColor(context, R.color.zebra_control_inverse)
                iconResId = R.drawable.ic_info_sharp
            }

            Style.INFO -> {
                colorTint = ContextCompat.getColor(context, R.color.zebra_purple)
                colorStroke = ContextCompat.getColor(context, R.color.zebra_purple_stroke)
                colorBackground = ContextCompat.getColor(context, R.color.zebra_purple_banner)
                iconResId = R.drawable.ic_info_sharp
            }

            Style.POSITIVE -> {
                colorTint = ContextCompat.getColor(context, R.color.zebra_green)
                colorStroke = ContextCompat.getColor(context, R.color.zebra_green_stroke)
                colorBackground = ContextCompat.getColor(context, R.color.zebra_green_banner)
                iconResId = R.drawable.ic_check_circle_sharp
            }

            Style.WARNING -> {
                colorTint = ContextCompat.getColor(context, R.color.zebra_yellow_enabled)
                colorStroke = ContextCompat.getColor(context, R.color.zebra_yellow_stroke)
                colorBackground = ContextCompat.getColor(context, R.color.zebra_yellow_banner)
                iconResId = R.drawable.ic_warning_round
            }

            Style.NEGATIVE -> {
                colorTint = ContextCompat.getColor(context, R.color.zebra_red_enabled)
                colorStroke = ContextCompat.getColor(context, R.color.zebra_red_stroke)
                colorBackground =
                    ContextCompat.getColor(context, R.color.zebra_red_error_background)
                iconResId = R.drawable.ic_info_sharp
            }
        }

        titleImage?.imageTintList = ColorStateList.valueOf(colorTint)
        titleImage?.setImageResource(iconResId)
        findViewById<ConstraintLayout>(R.id.background).setBackgroundColor(colorBackground)
        card?.setStrokeColor(ColorStateList.valueOf(colorStroke))
        card?.invalidate()
    }

    private fun applySharpStyle(isSharp: Boolean) {
        card?.radius =
            if (isSharp) 0f else resources.getDimensionPixelSize(R.dimen.text_input_corner_radius) * 1f
        card?.invalidate()
    }

    fun setActionOne(text: String, action: OnClickListener?) {
        actionButtonOne?.text = text
        if (action != null) {
            actionButtonOne?.visibility = VISIBLE
            actionButtonOne?.setOnClickListener {
                action.onClick(it)
            }
        } else {
            actionButtonOne?.visibility = GONE
        }
    }

    fun setActionTwo(text: String, action: OnClickListener?) {
        actionButtonTwo?.text = text
        if (action != null) {
            actionButtonTwo?.visibility = VISIBLE
            actionButtonTwo?.setOnClickListener {
                action.onClick(it)
            }
        } else {
            actionButtonTwo?.visibility = GONE
        }
    }
}