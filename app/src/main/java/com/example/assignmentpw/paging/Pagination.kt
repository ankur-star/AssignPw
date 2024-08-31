package com.dev_ankur.infoappmvvm.paging

interface Pagination<Key, Item> {
    suspend fun loadNextPage()
    fun reset()
}