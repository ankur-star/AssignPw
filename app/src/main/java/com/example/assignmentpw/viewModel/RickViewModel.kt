package com.dev_ankur.infoappmvvm.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentpw.models.ResultS
import com.dev_ankur.infoappmvvm.paging.PaginationFactory
import kotlinx.coroutines.launch

class RickViewModel : ViewModel() {

    private val repository = Repository()
    var staterika by mutableStateOf(ScreenStateRika())
    var id by mutableIntStateOf(0)


    private val paginationRika = PaginationFactory(
        initialPage = staterika.page,
        onLoadUpdated = {
            staterika = staterika.copy(
                isLoading = it
            )
        },
        onRequest = {nextPage ->
            repository.getRikaMorty(nextPage)
        },
        getNextKey = {
            staterika.page + 1
        },
        onError = {
            staterika = staterika.copy(error = it?.localizedMessage)
        },
        onSuccess = {items, newPage ->
            staterika = staterika.copy(
                resultData = staterika.resultData + items.results,
                page = newPage,
                endReached = staterika.page == 20
            )
        }
    )

    init {
        loadNextItems()
    }

    fun loadNextItems() {
        viewModelScope.launch {
            paginationRika.loadNextPage()
        }
    }


    fun getRikaDetailsById() {
        viewModelScope.launch {
            try {
                val response = repository.getRikaDetail(id = id)
                if (response.isSuccessful) {
                   /* staterika = staterika.copy(
                        result = response.body()!!,
                    )*/
                }
            } catch (e: Exception) {
                staterika = staterika.copy(
                    error = e.message
                )
            }
        }
    }
}


data class ScreenStateRika(
    val resultData: List<ResultS> = emptyList(),
    val page: Int = 1,
    val endReached: Boolean = false,
    val error: String? = null,
    val isLoading: Boolean = false
)