package com.nytsample.data.repository

import androidx.lifecycle.LiveData
import com.nytsample.data.common.Resource
import com.nytsample.data.common.ResultState
import com.nytsample.data.local.entity.MostPopular
import com.nytsample.data.remote.dto.CommonResponseDto

interface MostPopularRepository :BaseRepository {
   suspend fun getMostPopularList(section: String,period:String,apiKey: String): ResultState<CommonResponseDto.ResponseArticleList>
    fun getLiveData(section: String,period:String,apiKey: String): LiveData<Resource<List<MostPopular>>>
}