package com.shaileedemo.mvimovies.data

import androidx.paging.DataSource
import com.shaileedemo.mvimovies.data.database.DatabaseBuilder
import com.shaileedemo.mvimovies.data.mapper.DataFavoriteMapper
import com.shaileedemo.mvimovies.domain.boundary.DataGateway
import com.shaileedemo.mvimovies.domain.entities.Movie
import javax.inject.Inject

class MovieData @Inject constructor(
    private val databaseBuilder: DatabaseBuilder,
    private val favoriteMovieMapper: DataFavoriteMapper
) : DataGateway {

    override suspend fun saveFavoriteMovie(favoriteMovie: Movie.Favorite) {
        databaseBuilder
            .favoriteMovieDao()
            .insertFavoriteMovie(
                with(favoriteMovieMapper) { favoriteMovie.toData() }
            )
    }

    override fun getFavoriteMovies(): DataSource.Factory<Int, Movie.Favorite> = databaseBuilder
        .favoriteMovieDao()
        .getFavoriteMovies()
        .map { dataFavoriteMovie ->
            with(favoriteMovieMapper) { dataFavoriteMovie.toFavorite() }
        }
}
