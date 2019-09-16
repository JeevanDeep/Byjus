package com.jeevan.byjus.headlines.home

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
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

        viewmodel.headlinesList.observe(this) { list ->
            progressLayout.visibility = View.GONE
            if (list == null) {
                errorTextView.visibility = View.VISIBLE
            } else {
                setupAdapter(list)
            }
        }

        if (savedInstanceState == null)
            viewmodel.getHeadlines()
        else {
            val position = savedInstanceState.getInt(RECYCLERVIEW_ITEM_POSITION)
            headlinesRecyclerView.scrollToPosition(position)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val lm = headlinesRecyclerView.layoutManager as LinearLayoutManager
        outState.putInt(RECYCLERVIEW_ITEM_POSITION, lm.findFirstCompletelyVisibleItemPosition())
    }

    private fun setupAdapter(list: List<Article>) {
        val adapter = HeadlinesAdapter(list, onClick = { article ->
            startActivity(HeadlineDetailActivity.newInstance(this, article))
        })
        headlinesRecyclerView.adapter = adapter
    }

    companion object {
        private const val RECYCLERVIEW_ITEM_POSITION = "recyclerview item position"
    }
}
