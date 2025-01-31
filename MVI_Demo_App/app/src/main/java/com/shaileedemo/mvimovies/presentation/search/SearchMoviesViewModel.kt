package com.shaileedemo.mvimovies.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.shaileedemo.mvimovies.domain.entities.Movie
import com.shaileedemo.mvimovies.domain.posters.PosterService
import com.shaileedemo.mvimovies.presentation.navigation.NavActions
import com.shaileedemo.mvimovies.presentation.search.SearchSideEffect.UnexpectedError
import com.shaileedemo.mvimovies.presentation.search.SearchUserIntent.FindByTitle
import com.shaileedemo.mvimovies.presentation.search.SearchUserIntent.SelectPosterAsFavorite
import com.shaileedemo.mvimovies.presentation.search.SearchUserIntent.TapOnPoster
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchMoviesViewModel @Inject constructor(private val posterService: PosterService) : ViewModel() {
    var posters: Flow<PagingData<Movie.Poster>> = emptyFlow()
        private set
    private val _userInterface = MutableStateFlow(SearchUserInterface.defaultUi())
    val userInterface: StateFlow<SearchUserInterface> = _userInterface
    val _sideEffect = MutableSharedFlow<SearchSideEffect>()
    val sideEffect = _sideEffect
        .shareIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000)
        )
    var navActions: NavActions? = null
    private var job: Job? = null

    fun processUserIntent(userIntent: SearchUserIntent, coroutineScope: CoroutineScope = viewModelScope) {
        job?.cancel()
        job = coroutineScope.launch {
            when (userIntent) {
                is FindByTitle -> searchByTitle(title = userIntent.query)
                SelectPosterAsFavorite -> TODO("Not implemented")
                is TapOnPoster -> navActions?.goToMovieDetail(movieId = userIntent.posterId)
            }
        }
    }

 

    private suspend fun searchByTitle(title: String) {
        _userInterface.value = _userInterface.value.copy(loading = true, error = null)
        try {      
		posters = posterService.findByTitle(title = title)
            _userInterface.value = SearchUserInterface(loading = false,isEmptyScreen = false)
        } catch (e: Exception) {
            _userInterface.value =
                SearchUserInterface(loading = false, error = e.message ?: "Error fetching movies")
            _sideEffect.emit(
                UnexpectedError(message = e.localizedMessage.orEmpty())
            )
        }
    }

       // private suspend fun searchByTitle(title: String) {
    //     try {
    //         posters = posterService.findByTitle(title = title)
    //         _userInterface.update {
    //             SearchUserInterface(isEmptyScreen = false)
    //         }
    //     } catch (e: Exception) 
    //         _sideEffect.emit(
    //             UnexpectedError(message = e.localizedMessage.orEmpty())
    //         )
    //     }
    // }
}
