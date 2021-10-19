package com.hamsterdev.subscriber.data.remote

import com.hamsterdev.subscriber.data.remote.dto.SubscriptionDto
import retrofit2.http.GET

interface SubscriptionsApi {
    @GET("subscribes.json")
    suspend fun getAvailableSubscriptions(): List<SubscriptionDto>
}