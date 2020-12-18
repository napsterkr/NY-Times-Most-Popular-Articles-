package com.nytsample.data.local.entity

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.nytsample.data.common.Converters
import com.nytsample.data.remote.dto.MostPopularResultDto
import java.util.*


@Entity(tableName = "MostPopular")
@TypeConverters(Converters::class)

data class MostPopular(

    @PrimaryKey
    var id:Long,
    var uri:String? = null,
    var url:String? = null,
    var asset_id:Long? = null,
    var published_date:String? = null,
    var updated:String? = null,
    var section:String? = null,
    var subsection:String? = null,
    var adx_keywords:String? = null,
    var column:String? = null,
    var byline:String? = null,
    var type:String? = null,
    var title:String? = null,
      var eta_id:String? = null,
    val abstract:String? = null,
var des_facet:List<String>?=null,
var org_facet:List<String>?=null,
var per_facet:List<String>?=null,
var media:List<MostPopularResultDto.MediaData>?=null

){
    constructor(): this(0, "", "",0,"","","","","","","","","","","",Collections.emptyList(),Collections.emptyList(),Collections.emptyList(),Collections.emptyList())
}