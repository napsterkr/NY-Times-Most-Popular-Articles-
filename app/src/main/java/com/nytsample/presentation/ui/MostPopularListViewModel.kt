package com.nytsample.presentation.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.nytsample.R
import com.nytsample.BR
import com.nytsample.BaseApplication
import com.nytsample.data.common.Resource

import com.nytsample.data.local.dao.MostPopularDao
import com.nytsample.data.local.entity.MostPopular
import com.nytsample.data.repository.MostPopularRepository
import com.nytsample.presentation.ui.listner.OnItemClickListener
import me.tatarka.bindingcollectionadapter2.ItemBinding

class MostPopularListViewModel @ViewModelInject constructor(val mostPopularRepository: MostPopularRepository, val mostPopularDao: MostPopularDao) :
    BaseViewModel() {

    private var period: Int=1
    val isLoading = MutableLiveData<Boolean>()
    private val loadTrigger = MutableLiveData<Int>()

    val isError = MutableLiveData<Boolean>()
    var errorString = MutableLiveData<String>()
    var userList: MutableLiveData<List<MostPopular>> = MutableLiveData()
    //  var responseData: LiveData<Resource<List<GitUsers>>> = MutableLiveData()
    var id=MutableLiveData<Long>()
    val gitUserListBinding = ItemBinding.of<MostPopular> { todoListBinding, _, _ ->
        todoListBinding.set(BR.item, R.layout.item_most_popular_list).
        bindExtra(BR.listener,object : OnItemClickListener<MostPopular> {
            override fun onItemClick(option: MostPopular) {
                id.postValue(option.id)
            }

        })

    }
    fun uiHandler(resourceData: Resource<List<MostPopular>>) {
        when(resourceData.status){
            Resource.Status.LOADING->{
                isLoading.postValue(true)
                isError.postValue(false)
            }
            Resource.Status.SUCCESS -> {
                if (!resourceData.data.isNullOrEmpty()) {


                    isLoading.postValue(false)
                    isError.postValue(false)
                    userList.postValue(resourceData.data)

                }
            }
            Resource.Status.ERROR->{
                isLoading.postValue(false)
                isError.postValue(true)
                errorString.postValue(resourceData.message)
            }
        }
    }
    fun  getUserListData() {
        isLoading.postValue(true)
        loadTrigger.value=period

    }

    fun getData(period:Int) {
        this.period=period
        isLoading.postValue(true)
        loadTrigger.value=period
    }

    val responseData: LiveData<Resource<List<MostPopular>>> = loadTrigger.switchMap {
        mostPopularRepository.getLiveData("all-sections",it.toString(), "GYjeRDZjVJ8R6Rp84EZzx91DewaQPT9c")    }


}