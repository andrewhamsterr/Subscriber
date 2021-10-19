package com.hamsterdev.subscriber.domain.repository

import com.hamsterdev.subscriber.data.remote.dto.SubscriptionDto

interface SubscriptionsRepository {
    suspend fun getSubscriptions(): List<SubscriptionDto>
}