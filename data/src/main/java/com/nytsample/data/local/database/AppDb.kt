package com.nytsample.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nytsample.data.local.dao.MostPopularDao
import com.nytsample.data.local.entity.MostPopular


@Database(entities = [MostPopular::class], version = 1, exportSchema = false)
abstract class AppDb: RoomDatabase() {

    abstract fun mostPopularDao() : MostPopularDao
}