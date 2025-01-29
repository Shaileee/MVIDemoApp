package com.shaileedemo.mvimovies.presentation.moviedetail

import com.shaileedemo.mvimovies.domain.SeeMovieDetail
import com.shaileedemo.mvimovies.presentation.favorites.UserIntent


class EnterDetailSection(private val seeMovieDetail: SeeMovieDetail) : UserIntent {
    var movieId: String? = null
    override suspend fun execute() {
        seeMovieDetail.getMovieDetailById(movieId = movieId)
    }
}