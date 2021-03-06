package com.swallow.kmmrickandmorty.domain.common

sealed class LoadState {
    object LoadingList : LoadState()
    object SuccessList : LoadState()
    object ErrorList : LoadState()
    object LoadingPage : LoadState()
    object NextPageSuccess : LoadState()
    object NextPageError : LoadState()
}
