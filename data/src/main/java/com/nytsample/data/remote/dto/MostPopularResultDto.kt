package com.nytsample.data.remote.dto

import com.google.gson.annotations.SerializedName

sealed  class MostPopularResultDto{

data class Results(
    val uri:String,
    val url:String,
    val id:Long,
    val asset_id:Long,
    val published_date:String,
    val updated:String,
    val section:String,
    val abstract:String,
    val subsection:String,
    val adx_keywords:String,
    val column:String,
    val byline:String,
    val type:String,
    val title:String,
    val des_facet:List<String>,
    val org_facet:List<String>,
    val per_facet:List<String>,
    val media:List<MediaData>,
    val eta_id:String
)
data class MediaData(val type:String, val subtype:String, val caption:String, val copyright:String,
                     @SerializedName("media-metadata") val mediaMetadata:List<MediaMetaData>)
 data class MediaMetaData(val url:String,val format:String,val height :Int,val width:Int)

}