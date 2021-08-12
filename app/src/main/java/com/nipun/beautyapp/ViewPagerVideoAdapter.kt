package com.nipun.beautyapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nipun.beautyapp.model.ArticleItem



class ViewPagerVideoAdapter(private val videos: List<ArticleItem>, private val context: Context) :
    RecyclerView.Adapter<VideoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val currentVideo = videos[position]
        currentVideo?.let { holder.bindVideo(it) }
    }

    override fun getItemCount(): Int {
        return videos.size
    }
}