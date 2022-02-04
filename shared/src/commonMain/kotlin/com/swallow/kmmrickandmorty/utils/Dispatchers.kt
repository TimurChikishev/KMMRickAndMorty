package com.swallow.kmmrickandmorty.utils

import kotlinx.coroutines.CoroutineDispatcher

internal expect val mainDispatcher: CoroutineDispatcher

internal expect val ioDispatcher: CoroutineDispatcher
