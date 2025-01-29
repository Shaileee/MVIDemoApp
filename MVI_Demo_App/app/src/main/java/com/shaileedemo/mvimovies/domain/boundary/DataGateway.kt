package com.shaileedemo.mvimovies.domain.boundary

import androidx.paging.DataSource
import com.shaileedemo.mvimovies.domain.entities.Movie

interface DataGateway {
    suspend fun saveFavoriteMovie(favoriteMovie: Movie.Favorite)
    fun getFavoriteMovies(): DataSource.Factory<Int, Movie.Favorite>
}
