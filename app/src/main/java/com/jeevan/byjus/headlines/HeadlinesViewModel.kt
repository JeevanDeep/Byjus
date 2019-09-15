package com.jeevan.byjus.headlines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeevan.byjus.headlines.home.response.headlines.Article
import com.jeevan.byjus.network.NetworkResult
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import javax.inject.Inject

class HeadlinesViewModel @Inject constructor(private val headlinesRepo: HeadlinesRepo) :
    ViewModel() {

    private val _headlinesList = MutableLiveData<List<Article>?>()
    val headlinesList: LiveData<List<Article>?>
        get() = _headlinesList

    fun getHeadlines() {
        viewModelScope.launch {
            val response = headlinesRepo.getHeadlines()
            when (response) {
                is NetworkResult.Success -> {
                    val list = response.data
                    _headlinesList.value = list
                }

                is NetworkResult.Error -> {
                    if (response.exception !is CancellationException) {
                        _headlinesList.value = null
                    }
                }
            }
        }
    }
}