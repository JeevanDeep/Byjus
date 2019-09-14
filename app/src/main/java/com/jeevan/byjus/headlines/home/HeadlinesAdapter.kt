package com.jeevan.byjus.headlines.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.jeevan.byjus.R
import com.jeevan.byjus.headlines.home.response.headlines.Article

class HeadlinesAdapter(private val list: List<Article>, private val onClick: (Article) -> Unit) :
    RecyclerView.Adapter<HeadlinesAdapter.HeadlinesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlinesViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.headlines_item_view, parent, false)
        return HeadlinesViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HeadlinesViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class HeadlinesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val source: TextView = itemView.findViewById(R.id.sourceTextView)
        private val headline: TextView = itemView.findViewById(R.id.headlineTextView)
        private val backgroundImage: ImageView = itemView.findViewById(R.id.articleBackgroundImage)

        fun bind(article: Article) {
            source.text = article.source.name
            headline.text = article.title

            Glide.with(itemView)
                .load(article.urlToImage)
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(backgroundImage)

            itemView.setOnClickListener { onClick.invoke(article) }
        }
    }
}