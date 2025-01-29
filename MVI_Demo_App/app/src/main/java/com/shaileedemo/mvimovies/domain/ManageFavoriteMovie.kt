package com.shaileedemo.mvimovies.domain

import androidx.paging.DataSource
import com.shaileedemo.mvimovies.domain.boundary.DataGateway
import com.shaileedemo.mvimovies.domain.entities.Movie

class ManageFavoriteMovie(private val dataGateway: DataGateway) {
    lateinit var favoriteMovies: DataSource.Factory<Int, Movie.Favorite>

    fun fetchFavoriteMovies() {
        favoriteMovies = dataGateway.getFavoriteMovies()
    }

    suspend fun saveFavoriteMovie(favoriteMovie: Movie.Favorite?) {
        requireNotNull(favoriteMovie)
        return dataGateway.saveFavoriteMovie(favoriteMovie)
    }
}
