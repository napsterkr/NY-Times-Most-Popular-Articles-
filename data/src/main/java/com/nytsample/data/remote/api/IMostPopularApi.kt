package com.nytsample.data.remote.api

import com.nytsample.data.remote.dto.CommonResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IMostPopularApi {

    @GET("mostviewed/{section}/{period}.json")
    suspend  fun getMostPopularApi(@Path("section")  section:String, @Path("period")  period:String, @Query("api-key")  apiKey:String ): CommonResponseDto.ResponseArticleList

}