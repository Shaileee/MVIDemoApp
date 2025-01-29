package com.shaileedemo.mvimovies.domain.boundary

import com.shaileedemo.mvimovies.domain.entities.Movie
import com.shaileedemo.mvimovies.domain.posters.pager.PagingInfo

interface RemoteFacade {
    val pageSize: Int
    suspend fun findMoviePostersByName(name: String, page: Int): PagingInfo
    suspend fun getMovieDetailById(movieId: String): Movie.Information
}