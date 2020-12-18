package com.nytsample.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nytsample.data.local.entity.MostPopular


@Dao
interface MostPopularDao   {

    @Query("SELECT * FROM MostPopular")
      fun select(): LiveData<List<MostPopular>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(obj: MostPopular)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAll(obj: List<MostPopular>?)
    @Query("SELECT * FROM MostPopular WHERE id = :id")
     fun findById(id: Long): MostPopular

    @Delete
     fun delete(obj: MostPopular)



}