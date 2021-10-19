package com.hamsterdev.subscriber.presentation.main.activeSubscriptions

import com.hamsterdev.subscriber.domain.model.Subscription

data class ActiveSubsState(
    val isLoading: Boolean = false,
    val subs: List<Subscription> = emptyList(),
    val error: String? = null
)