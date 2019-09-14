package com.jeevan.byjus.headlines.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.jeevan.byjus.R
import com.jeevan.byjus.headlines.home.response.headlines.Article
import kotlinx.android.synthetic.main.activity_headline_detail.*

class HeadlineDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_headline_detail)

        val article: Article? = intent.getParcelableExtra(ARTICLE_ITEM)
        if (article == null) {
            // this should never happen
            Log.e("HeadlinesDetail", "article null from intent")
            return
        }

        populateUI(article)
    }

    private fun populateUI(article: Article) {
        articleHeadline.text = article.title
        sourceTextView.text = article.source.name
        articleDescription.text = article.description
        Glide.with(this).load(article.urlToImage).into(headlinesImage)
        backArrowBg.setOnClickListener { onBackPressed() }
    }

    companion object {
        private const val ARTICLE_ITEM = "article item"
        fun newInstance(context: Context, article: Article) =
            Intent(context, HeadlineDetailActivity::class.java).apply {
                putExtra(ARTICLE_ITEM, article)
            }
    }
}
