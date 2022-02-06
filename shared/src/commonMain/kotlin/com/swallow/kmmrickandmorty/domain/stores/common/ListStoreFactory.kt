package com.swallow.kmmrickandmorty.domain.stores.common

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.swallow.kmmrickandmorty.domain.repository.GetRepository
import com.swallow.kmmrickandmorty.domain.stores.common.ListStore.*
import com.swallow.kmmrickandmorty.utils.mainDispatcher
import kotlinx.coroutines.CoroutineDispatcher

class ListStoreFactory<Model :Any>(
    private val storeFactory: StoreFactory,
    private val repository: GetRepository<Model>,
    private val mainContext: CoroutineDispatcher = mainDispatcher
) {

    fun create(): ListStore<Model> =
        object : ListStore<Model>, Store<Intent, State<Model>, Label> by storeFactory.create(
            name = CHARACTERS_STORE_NAME,
            initialState = State(),
            bootstrapper = BootstrapperImpl(),
            executorFactory = { ExecutorImpl(repository, mainContext) },
            reducer = ReducerImpl()
        ) {}

    companion object {
        private const val CHARACTERS_STORE_NAME = "CHARACTERS_STORE_NAME"
    }
}