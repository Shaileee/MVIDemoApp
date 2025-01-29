package com.shaileedemo.mvimovies.domain.posters.pager

import com.shaileedemo.mvimovies.domain.entities.Movie

data class PagingInfo(
    val posters: List<Movie.Poster>?,
    val totalResults: Int?,
)
