package com.nytsample.data.common

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nytsample.data.remote.dto.MostPopularResultDto
import java.lang.reflect.Type
import java.util.*


class Converters {
    var gson = Gson()

   @TypeConverter
    fun stringToSomeStringList(data: String?): List<String> {
        if (data == null ||data.equals("null")) {
            return Collections.emptyList()
        }
        val listType: Type =
            object : TypeToken<List<String>>() {}.getType()
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun StringListToString(someObjects: List<String>?): String? {
        return gson.toJson(someObjects)
    }
    @TypeConverter
    fun stringToSomeObjectList(data: String): List<MostPopularResultDto.MediaData?> {
        if (data == null || data=="null") {
            return Collections.emptyList()
        }
        val listType: Type =
            object : TypeToken<List<MostPopularResultDto.MediaData>>() {}.getType()
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<MostPopularResultDto.MediaData?>?): String {
        return gson.toJson(someObjects)
    }
}
