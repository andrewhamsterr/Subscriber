package com.hamsterdev.subscriber.common

import com.hamsterdev.subscriber.domain.model.Subscription

sealed class ApiResult {
    class Success(val subsList:List<Subscription>) : ApiResult()
    class Loading() : ApiResult()
    class Error(val message: String) : ApiResult()
}
