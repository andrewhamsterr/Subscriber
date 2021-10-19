package com.hamsterdev.subscriber.data.di

import com.hamsterdev.subscriber.common.NetworkConstants
import com.hamsterdev.subscriber.data.remote.SubscriptionsApi
import com.hamsterdev.subscriber.domain.repository.SubscriptionsRepository
import com.hamsterdev.subscriber.domain.repository.SubscriptionsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSubscriptionApi(): SubscriptionsApi {
        return Retrofit.Builder()
            .baseUrl(NetworkConstants.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SubscriptionsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSubsRepository(subsApi: SubscriptionsApi): SubscriptionsRepository {
        return SubscriptionsRepositoryImpl(subsApi)
    }
}