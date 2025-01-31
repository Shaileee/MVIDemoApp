package com.shaileedemo.mvimovies.presentation.moviedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shaileedemo.mvimovies.domain.ManageFavoriteMovie
import com.shaileedemo.mvimovies.domain.SeeMovieDetail
import com.shaileedemo.mvimovies.domain.entities.Movie
import com.shaileedemo.mvimovies.presentation.mapper.UiMovieDetailMapper
import com.shaileedemo.mvimovies.presentation.navigation.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val seeMovieDetail: SeeMovieDetail,
    private val mapper: UiMovieDetailMapper,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val movieId = savedStateHandle.get<String>(Destination.Argument.Name.MOVIE_ID)

    suspend fun getMovieInformation(): DetailUserInterface = try {
        val information = seeMovieDetail.getMovieDetailById(movieId)
        DetailUserInterface(attributes = with(mapper) { information.toAttributes() })
    } catch (e: Exception) {
        DetailUserInterface(errorMessage = e.localizedMessage)
    }

}
