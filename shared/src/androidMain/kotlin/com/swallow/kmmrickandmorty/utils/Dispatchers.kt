package com.swallow.kmmrickandmorty.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal actual val mainDispatcher: CoroutineDispatcher = Dispatchers.Main.immediate

internal actual val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
