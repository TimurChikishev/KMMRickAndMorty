package com.swallow.kmmrickandmorty.domain.stores.common

import com.swallow.kmmrickandmorty.data.models.common.JsonWrapper
import com.swallow.kmmrickandmorty.domain.common.LoadState

sealed class Result {
    data class Loaded<Model : Any>(val items: JsonWrapper<Model>) : Result()
    data class LoadedPage<Model : Any>(val items: JsonWrapper<Model>) : Result()
    data class UpdateLoadState(val loadState: LoadState) : Result()
}