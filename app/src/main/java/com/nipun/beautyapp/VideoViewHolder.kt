package com.nipun.beautyapp

import android.view.View

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nipun.beautyapp.model.ArticleItem
import kotlinx.android.synthetic.main.item_layout.view.*

class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindVideo(video: ArticleItem) {
            itemView.apply {
                Glide.with(ivImage).load(video.image).into(ivImage)
                val tvDesc = video.reco
                recommendation.text = tvDesc
                val Summary = video.summary
                tvSummary.text = Summary
                val title = video.title
                tvTitle.text = title
                val time = video.date
                tvTime.text = time
                val source = video.source
                tvSource.text = source
            }
        }
    }