package com.shaileedemo.mvimovies.network

import com.shaileedemo.mvimovies.domain.boundary.RemoteFacade
import com.shaileedemo.mvimovies.domain.entities.Movie
import com.shaileedemo.mvimovies.domain.posters.pager.PagingInfo
import com.shaileedemo.mvimovies.network.mapper.NetMovieInfoMapper
import com.shaileedemo.mvimovies.network.mapper.NetMoviePosterMapper
import com.shaileedemo.mvimovies.network.retrofit.WebServiceRetrofit
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieNetwork @Inject constructor(
    private val webServiceRetrofit: WebServiceRetrofit,
    private val movieMapper: NetMoviePosterMapper,
    private val detailMapper: NetMovieInfoMapper,
    private val dispatcher: CoroutineDispatcher,
) : RemoteFacade {
    override val pageSize: Int
        get() = PAGE_SIZE

    override suspend fun findMoviePostersByName(name: String, page: Int): PagingInfo {
        val searchRemote = withContext(dispatcher) {
            webServiceRetrofit.getPostersByTitle(query = name, page = page)
        }
        return with(movieMapper) { searchRemote.toPagingInfo() }
    }

    override suspend fun getMovieDetailById(movieId: String): Movie.Information =
        with(detailMapper) {
            webServiceRetrofit.getMovieDetailById(movieId).toInformation()
        }

    companion object {
        const val PAGE_SIZE = 10
    }
}
