package com.zebra.zds

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.color.MaterialColors
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.progressindicator.CircularProgressIndicator

class ZdsCircularProgressIndicator : FrameLayout {

    var labelString: String? = null

    var labelText: AppCompatTextView? = null
    var progressIndicator: CircularProgressIndicator? = null
    var actionView: ShapeableImageView? = null

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
        val inflatedView = View.inflate(context, R.layout.circular_progress_indicator, null)
        val layoutParams =
            LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        addView(inflatedView, layoutParams)

        labelText = inflatedView.findViewById(R.id.textLabel)
        progressIndicator = inflatedView.findViewById(R.id.progressIndicator)
        actionView = inflatedView.findViewById(R.id.actionView)

        attrs?.let {
            val a: TypedArray =
                context.obtainStyledAttributes(it, R.styleable.ZdsCircularProgressIndicator)

            // Label property
            labelString = a.getString(R.styleable.ZdsCircularProgressIndicator_label)
            setLabel(labelString)

            // progress/max
            val max = a.getInt(R.styleable.ZdsCircularProgressIndicator_max, 0)
            progressIndicator?.max = max

            val progress = a.getInt(R.styleable.ZdsCircularProgressIndicator_progress, 0)
            progressIndicator?.progress = progress

            // indeterminate
            val indeterminate =
                a.getBoolean(R.styleable.ZdsCircularProgressIndicator_indeterminate, false)
            progressIndicator?.isIndeterminate = indeterminate

            a.recycle()
        }

        actionView?.imageTintList = ColorStateList.valueOf(
            MaterialColors.getColor(
                context,
                R.attr.colorOnSurfaceVariant,
                Color.BLACK
            )
        )

        actionView?.setBackgroundColor(
            MaterialColors.getColor(
                context,
                R.attr.colorOnSurface,
                Color.BLACK
            )
        )
    }

    fun setLabel(label: String?) {
        labelString = label
        labelText?.text = labelString
        labelText?.visibility = if (labelString.isNullOrBlank()) GONE else VISIBLE
    }

    fun setLabel(labelResId: Int) {
        labelString = context.getString(labelResId)
        setLabel(labelString)
    }

    fun setProgress(progress: Int) {
        progressIndicator?.progress = progress
    }

    fun enableActionView(enable: Boolean) {
        actionView?.visibility = if (enable) VISIBLE else GONE
        labelText?.visibility = if (!enable) VISIBLE else GONE
    }

    fun setActionListener(listener: OnClickListener) {
        actionView?.setOnClickListener(listener)
    }
}