package com.zebra.zds

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.Window
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.cardview.widget.CardView
import com.google.android.material.button.MaterialButton

class ZdsDialog(context: Context) : Dialog(context) {

    class ZdsDialogClickListener(
        val dialog: ZdsDialog,
        private val clickListener: View.OnClickListener?
    ) :
        View.OnClickListener {
        override fun onClick(view: View) {
            clickListener?.onClick(view)
            dialog.dismiss()
        }
    }

    class Builder(val context: Context) {

        private var title: String? = null
        private var iconResId: Int? = null
        private var titleGravity: Int = Gravity.CENTER

        private var content: String? = null

        private var positiveText: String? = null
        private var positiveClickListener: View.OnClickListener? = null

        private var negativeText: String? = null
        private var negativeClickListener: View.OnClickListener? = null

        private var neutralText: String? = null
        private var neutralClickListener: View.OnClickListener? = null

        private var isSharp: Boolean = false

        fun setTitle(title: String): Builder {
            this.title = title
            return this
        }

        fun setIcon(iconResId: Int):Builder {
            this.iconResId = iconResId
            return this
        }

        fun setTitleGravity(gravity: Int):Builder {
            this.titleGravity = gravity
            return this
        }

        fun setContent(content: String):Builder {
            this.content = content
            return this
        }

        fun setPositiveAction(
            positiveAction: String,
            positiveActionClickListener: View.OnClickListener?
        ):Builder {
            this.positiveText = positiveAction
            this.positiveClickListener = positiveActionClickListener
            return this
        }

        fun setNegativeAction(
            negativeAction: String,
            negativeActionClickListener: View.OnClickListener?
        ):Builder {
            this.negativeText = negativeAction
            this.negativeClickListener = negativeActionClickListener
            return this
        }

        fun setNeutralAction(
            neutralAction: String,
            neutralActionClickListener: View.OnClickListener?
        ):Builder {
            this.neutralText = neutralAction
            this.neutralClickListener = neutralActionClickListener
            return this
        }

        fun setIsSharp(isSharp: Boolean):Builder {
            this.isSharp = isSharp
            return this
        }

        fun build(): ZdsDialog {
            val dialog = ZdsDialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setContentView(R.layout.dialog_wrapper)

            val mainLayout = dialog.findViewById<LinearLayoutCompat>(R.id.mainLayout)
            if (this.isSharp) {
                dialog.findViewById<CardView>(R.id.cardLayout).radius = 0f
            }

            // Setup title
            val titleLayout = LayoutInflater.from(dialog.context)
                .inflate(R.layout.dialog_title, mainLayout, false)
            val icon = titleLayout.findViewById<AppCompatImageView>(R.id.titleIcon)
            val titleText = titleLayout.findViewById<AppCompatTextView>(R.id.titleText)

            if (this.iconResId != null) {
                icon.setImageResource(this.iconResId!!)
                icon.visibility = VISIBLE
                icon.layoutParams.apply {
                    (this as LinearLayoutCompat.LayoutParams).gravity = titleGravity
                }
            } else {
                icon.visibility = GONE
            }

            titleText.text = this.title
            titleText.layoutParams.apply {
                (this as LinearLayoutCompat.LayoutParams).gravity = titleGravity
            }

            mainLayout.addView(titleLayout)

            // Setup content
            val contentLayout = LayoutInflater.from(dialog.context)
                .inflate(R.layout.dialog_content, mainLayout, false)
            contentLayout.findViewById<AppCompatTextView>(R.id.contentText).text = this.content
            mainLayout.addView(contentLayout)

            // Setup actions
            var actionsResId = -1
            if (this.positiveText != null) {
                actionsResId = R.layout.dialog_action_one

                if (this.negativeText != null) {
                    actionsResId = R.layout.dialog_action_two

                    if (this.neutralText != null) {
                        actionsResId = R.layout.dialog_action_three
                    }
                }
            }

            if (actionsResId > 0) {
                val actionLayout =
                    LayoutInflater.from(dialog.context).inflate(actionsResId, mainLayout, false)

                val positiveButton = actionLayout.findViewById<ZdsButton>(R.id.positiveButton)
                positiveButton?.setOnClickListener(
                    ZdsDialogClickListener(
                        dialog,
                        this.positiveClickListener
                    )
                )
                positiveButton?.text = this.positiveText

                val neutralButton = actionLayout.findViewById<ZdsButton>(R.id.neutralButton)
                neutralButton?.setOnClickListener(
                    ZdsDialogClickListener(
                        dialog,
                        this.neutralClickListener
                    )
                )
                neutralButton?.text = this.neutralText

                val negativeButton = actionLayout.findViewById<MaterialButton>(R.id.negativeButton)
                negativeButton?.setOnClickListener(
                    ZdsDialogClickListener(
                        dialog,
                        this.negativeClickListener
                    )
                )
                negativeButton?.text = this.negativeText

                if (this.isSharp) {
                    positiveButton?.cornerRadius = 0
                    neutralButton?.cornerRadius = 0
                    negativeButton?.cornerRadius = 0
                }

                mainLayout.addView(actionLayout)
            }

            return dialog
        }
    }
}