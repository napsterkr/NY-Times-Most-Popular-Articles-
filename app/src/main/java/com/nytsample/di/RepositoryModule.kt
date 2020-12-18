package com.nytsample.di
import com.nytsample.data.local.dao.MostPopularDao
import com.nytsample.data.remote.api.IMostPopularApi
import com.nytsample.data.repository.MostPopularRepository
import com.nytsample.data.repository.MostPopularRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(includes = [ApiModule::class])
@InstallIn(ApplicationComponent::class)

class RepositoryModule {

    @Provides
    fun provideMostPopularRepository(api: IMostPopularApi, gitUsersDao: MostPopularDao): MostPopularRepository {
        return MostPopularRepositoryImpl(api,gitUsersDao)
    }


}