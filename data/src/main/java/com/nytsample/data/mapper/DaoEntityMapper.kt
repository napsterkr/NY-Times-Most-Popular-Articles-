package com.nytsample.data.mapper

import com.nytsample.data.local.entity.MostPopular

sealed class DaoEntityMapper {
     data class MostPopularResultDao( val getMostPopularList:List<MostPopular>):DaoEntityMapper()
}