package com.nytsample.di


import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)

class Interceptors {

@Provides
@Singleton
fun networkConnectionInterceptor(@ApplicationContext context: Context): NetworkConnectionInterceptor = NetworkConnectionInterceptor(context)


}