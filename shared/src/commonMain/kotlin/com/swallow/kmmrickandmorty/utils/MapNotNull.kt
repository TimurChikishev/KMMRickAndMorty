package com.swallow.kmmrickandmorty.utils


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull as mapNotNullFlow

/*
 * Original mapNotNull accepts suspend function and we can't pass a non-suspend function by reference as of now
 */
inline fun <T, R: Any> Flow<T>.mapNotNull(crossinline mapper: (T) -> R?): Flow<R> =
    mapNotNullFlow { mapper(it) }