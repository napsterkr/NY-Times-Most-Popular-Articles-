package com.nytsample.data.remote.dto


sealed   class CommonResponseDto{
 data class ResponseArticleList (  val results: List<MostPopularResultDto.Results>)

}


