package com.zebra.zds

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class ZdsListItem {

    companion object {
        fun getListItem(viewGroup: ViewGroup): View {
            return LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_item, viewGroup, false)
        }
    }

    class ZdsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var content: MaterialTextView
        var descriptor: MaterialTextView
        var meta: MaterialTextView
        var iconLeft: ShapeableImageView
        var iconRight: ShapeableImageView
        var actionView: ZdsCheckBox

        init {
            content = view.findViewById(R.id.content)
            descriptor = view.findViewById(R.id.descriptor)
            meta = view.findViewById(R.id.meta)
            iconLeft = view.findViewById(R.id.iconLeft)
            iconRight = view.findViewById(R.id.iconRight)
            actionView = view.findViewById(R.id.action)
        }

        fun showIconLeft(resId: Int) {
            iconLeft.setImageResource(resId)
            iconLeft.visibility = VISIBLE
        }

        fun hideIconLeft() {
            iconLeft.visibility = GONE
        }

        fun showIconRight(resId: Int) {
            iconRight.setImageResource(resId)
            iconRight.visibility = VISIBLE
            meta.visibility = GONE
            actionView.visibility = GONE
        }

        fun hideIconRight() {
            iconRight.visibility = GONE
        }

        fun setMeta(text: String) {
            meta.text = text
            meta.visibility = if (text.isNotBlank()) VISIBLE else GONE
            iconRight.visibility = if (text.isNotBlank()) GONE else iconRight.visibility
            actionView.visibility = if (text.isNotBlank()) GONE else actionView.visibility
        }

        fun showActionView() {
            iconRight.visibility = GONE
            meta.visibility = GONE
            actionView.visibility = VISIBLE
        }

        fun hideActionView() {
            actionView.visibility = GONE
        }
    }
}