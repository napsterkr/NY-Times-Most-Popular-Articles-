package com.nytsample.data.repository

import androidx.lifecycle.LiveData
import com.nytsample.data.common.Resource
import com.nytsample.data.common.ResultState
import com.nytsample.data.dataSource.performGetOperation

import com.nytsample.data.local.dao.MostPopularDao
import com.nytsample.data.local.entity.MostPopular
import com.nytsample.data.local.entity.map
import com.nytsample.data.remote.api.IMostPopularApi
import com.nytsample.data.remote.dto.CommonResponseDto

class MostPopularRepositoryImpl (val api: IMostPopularApi, val mostPopularDao: MostPopularDao):BaseRepositoryImpl(),com.nytsample.data.repository.MostPopularRepository {

    private  fun getData(section: String,period:String,apiKey: String) = performGetOperation(
        databaseQuery = {
            mostPopularDao.select() },
        networkCall = {getMostPopularList(section,period,apiKey) },saveCallResult = {
            mostPopularDao.insertAll(it.map().getMostPopularList)}
    )
    override suspend fun getMostPopularList(section: String,period:String,apiKey: String): ResultState<CommonResponseDto.ResponseArticleList> {
        return try {
            val response = api.getMostPopularApi(section,period,apiKey)
            ResultState.Success(response)
        } catch (e: Exception) {
            handleErrorReturn(e) as ResultState<CommonResponseDto.ResponseArticleList>
        }
    }

    override  fun getLiveData(section: String,period:String,apiKey: String): LiveData<Resource<List<MostPopular>>> {
        return getData(section,period,apiKey)
    }
}