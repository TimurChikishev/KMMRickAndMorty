package com.swallow.kmmrickandmorty.domain.repository

import com.swallow.kmmrickandmorty.data.models.common.JsonInfo
import com.swallow.kmmrickandmorty.data.models.common.JsonWrapper

interface GetRepository<Model : Any> {
    suspend fun get(jsonInfo: JsonInfo? = null) : JsonWrapper<Model>
}