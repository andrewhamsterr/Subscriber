package com.hamsterdev.subscriber.data.remote.dto

import com.hamsterdev.subscriber.domain.model.Subscription

data class SubscriptionDto(
    val id: String,
    val name: String,
    val icon: String
)

fun SubscriptionDto.toSubscription(): Subscription {
    return Subscription(id, name, icon)
}