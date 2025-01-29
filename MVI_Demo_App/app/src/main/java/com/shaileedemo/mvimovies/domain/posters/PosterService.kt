package com.shaileedemo.mvimovies.domain.posters

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.shaileedemo.mvimovies.domain.boundary.RemoteFacade
import com.shaileedemo.mvimovies.domain.entities.Movie
import com.shaileedemo.mvimovies.domain.posters.pager.PostingPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class PosterService(
    private val remoteFacade: RemoteFacade,
    private val movie: Movie,
) {
    var pagingPosters: Flow<PagingData<Movie.Poster>> = emptyFlow()
        private set

    fun findByTitle(title: String?): Flow<PagingData<Movie.Poster>> {
        val verifiedTitle = movie.verifyTitleAndGetTrimValue(title)
        return Pager(
            config = PagingConfig(
                pageSize = remoteFacade.pageSize,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PostingPagingSource(remoteFacade, verifiedTitle)
            }
        ).flow
    }
}
