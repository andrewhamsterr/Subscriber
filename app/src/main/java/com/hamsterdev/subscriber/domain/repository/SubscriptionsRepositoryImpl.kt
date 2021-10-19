package com.hamsterdev.subscriber.domain.repository

import com.hamsterdev.subscriber.data.remote.SubscriptionsApi
import com.hamsterdev.subscriber.data.remote.dto.SubscriptionDto
import javax.inject.Inject

class SubscriptionsRepositoryImpl @Inject constructor(
    private val subsApi: SubscriptionsApi
) : SubscriptionsRepository {
    override suspend fun getSubscriptions(): List<SubscriptionDto> {
        return subsApi.getAvailableSubscriptions()
    }

}