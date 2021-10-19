package com.hamsterdev.subscriber.domain.useCase.getAvailableSuscriptions

import com.hamsterdev.subscriber.common.ApiResult
import com.hamsterdev.subscriber.data.remote.dto.toSubscription
import com.hamsterdev.subscriber.domain.repository.SubscriptionsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetAvailableSubsUseCase @Inject constructor(
    private val subsRepo: SubscriptionsRepository
) {
    operator fun invoke(): Flow<ApiResult> = flow {
        try {
            emit(ApiResult.Loading())
            val subs = subsRepo.getSubscriptions()
            emit(ApiResult.Success(subs.map { it.toSubscription() }))
        } catch (e: HttpException) {
            emit(ApiResult.Error(e.localizedMessage ?: "Http error"))
        } catch (e: IOException) {
            emit(ApiResult.Error("Internet error"))
        }
    }
}