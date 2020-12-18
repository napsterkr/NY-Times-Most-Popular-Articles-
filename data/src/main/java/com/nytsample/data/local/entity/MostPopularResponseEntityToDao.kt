package com.nytsample.data.local.entity

import com.nytsample.data.mapper.DaoEntityMapper
import com.nytsample.data.remote.dto.CommonResponseDto
import com.nytsample.data.remote.dto.MostPopularResultDto

fun CommonResponseDto.ResponseArticleList.map()= DaoEntityMapper.MostPopularResultDao(
    results.map { it.map() })


fun MostPopularResultDto.Results.map()=MostPopular(
    id=id,
    url=url,
    uri=uri,
    adx_keywords = adx_keywords,
    asset_id =asset_id,
    published_date =published_date,
    byline = byline,
    updated = updated,
    section = section,
    subsection = subsection,
    column = column,
    type = type,
    title = title,
    abstract = abstract,
    eta_id = eta_id,
    des_facet = des_facet,
    org_facet = org_facet,
    per_facet = per_facet,
    media = media

)
