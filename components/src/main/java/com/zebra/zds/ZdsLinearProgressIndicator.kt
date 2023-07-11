package com.zebra.zds

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import com.google.android.material.progressindicator.LinearProgressIndicator

class ZdsLinearProgressIndicator : FrameLayout {

    var labelString: String? = null

    var labelText: AppCompatTextView? = null
    var progressIndicator: LinearProgressIndicator? = null
    var progressLayout: LinearLayoutCompat? = null

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
        val inflatedView = View.inflate(context, R.layout.linear_progress_indicator, null)
        val layoutParams =
            LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        addView(inflatedView, layoutParams)

        labelText = inflatedView.findViewById(R.id.textLabel)
        progressIndicator = inflatedView.findViewById(R.id.progressIndicator)
        progressLayout = inflatedView.findViewById(R.id.progressLayout)

        attrs?.let {
            val a: TypedArray =
                context.obtainStyledAttributes(it, R.styleable.ZdsLinearProgressIndicator)

            // Label property
            labelString = a.getString(R.styleable.ZdsLinearProgressIndicator_label)
            setLabel(labelString)

            // progress/max
            val max = a.getInt(R.styleable.ZdsLinearProgressIndicator_max, 0)
            progressIndicator?.max = max

            val progress = a.getInt(R.styleable.ZdsLinearProgressIndicator_progress, 0)
            progressIndicator?.progress = progress

            // indeterminate
            val indeterminate =
                a.getBoolean(R.styleable.ZdsLinearProgressIndicator_indeterminate, false)
            progressIndicator?.isIndeterminate = indeterminate

            // buffering
            val buffering: Boolean =
                a.getBoolean(R.styleable.ZdsLinearProgressIndicator_buffering, false)
            progressLayout?.visibility = if (buffering) VISIBLE else GONE

            // track thickness
            val trackThickness =
                a.getDimensionPixelSize(R.styleable.ZdsLinearProgressIndicator_trackThickness, 0)
            progressIndicator?.trackThickness = trackThickness

            a.recycle()
        }
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
}