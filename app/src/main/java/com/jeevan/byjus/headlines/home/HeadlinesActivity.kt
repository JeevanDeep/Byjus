package com.jeevan.byjus.headlines.home

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.jeevan.byjus.ByjusApp
import com.jeevan.byjus.R
import com.jeevan.byjus.di.ViewModelFactory
import com.jeevan.byjus.headlines.HeadlinesViewModel
import com.jeevan.byjus.headlines.detail.HeadlineDetailActivity
import com.jeevan.byjus.headlines.home.response.headlines.Article
import kotlinx.android.synthetic.main.activity_headlines.*
import javax.inject.Inject

class HeadlinesActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewmodel: HeadlinesViewModel by viewModels { viewModelFactory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_headlines)
        ByjusApp.applicationComponent.inject(this)

        viewmodel.getHeadlines()
        viewmodel.headlinesList.observe(this) { list ->
            progressLayout.visibility = View.GONE
            setupAdapter(list)
        }
    }

    private fun setupAdapter(list: List<Article>) {
        val adapter = HeadlinesAdapter(list, onClick = { article ->
            startActivity(HeadlineDetailActivity.newInstance(this, article))
        })
        headlinesRecyclerView.adapter = adapter
    }
}
