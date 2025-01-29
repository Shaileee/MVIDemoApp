package com.shaileedemo.mvimovies.presentation.favorites

import com.shaileedemo.mvimovies.domain.ManageFavoriteMovie

class EnterFavoriteSection(private val manageFavoriteMovie: ManageFavoriteMovie) : UserIntent {
    override suspend fun execute() {
        manageFavoriteMovie.fetchFavoriteMovies()
    }
}
