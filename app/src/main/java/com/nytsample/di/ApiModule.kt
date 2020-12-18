package com.nytsample.di


import com.nytsample.data.remote.api.IMostPopularApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
@InstallIn(ApplicationComponent::class)

class ApiModule {

    @Provides
    @Singleton
    fun provideMostPopularApi(retrofit: Retrofit): IMostPopularApi {
        return retrofit.create(IMostPopularApi::class.java)
    }



}