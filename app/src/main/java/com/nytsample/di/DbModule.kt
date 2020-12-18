package com.nytsample.di

import android.content.Context
import androidx.room.Room
import com.nytsample.data.local.dao.MostPopularDao
import com.nytsample.data.local.database.AppDb


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)

class DbModule {

    @Provides
    @Singleton
    internal fun provideAppDatabase(@ApplicationContext context: Context): AppDb {
        return Room.databaseBuilder(context, AppDb::class.java, "nytsample.db").build()
    }

    @Provides
    @Singleton
    internal fun provideMostPopularDao(appDb: AppDb): MostPopularDao {
        return appDb.mostPopularDao()
    }
}