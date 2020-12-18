package com.nytsample.presentation.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nytsample.data.local.dao.MostPopularDao
import com.nytsample.data.local.entity.MostPopular
import com.nytsample.presentation.util.SingleLiveEvent

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MostPopularDetailsViewModel @ViewModelInject constructor(private val mostPopularDao:  MostPopularDao) :
    BaseViewModel() {
    val mostPopularLiveData=MutableLiveData<MostPopular>()
    val onFabCLick= SingleLiveEvent<String>();
    fun getUserData(id: Long?) {
        id?.let {
            viewModelScope.launch (Dispatchers.IO){
                mostPopularLiveData.postValue(mostPopularDao.findById(it))

            }

        }

    }
    fun  onDetailsFabClick(){
        onFabCLick.postValue(mostPopularLiveData.value?.url)
    }
}