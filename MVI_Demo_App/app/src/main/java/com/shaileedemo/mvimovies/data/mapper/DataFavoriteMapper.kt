package com.shaileedemo.mvimovies.data.mapper

import com.shaileedemo.mvimovies.data.model.DataFavoriteMovie
import com.shaileedemo.mvimovies.domain.entities.Movie
import javax.inject.Inject

class DataFavoriteMapper @Inject constructor() {

    fun DataFavoriteMovie.toFavorite() = Movie.Favorite(
        movieId = id,
        title = title,
        year = year,
        genre = genre,
        poster = poster,
    )

    fun Movie.Favorite.toData() = DataFavoriteMovie(
        id = movieId,
        title = title,
        year = year,
        rated = "",
        released = "",
        runtime = "",
        genre = genre,
        director = "",
        writer = "",
        actors = "",
        plot = "",
        language = "",
        country = "",
        awards = "",
        poster = poster,
        metascore = "",
        rating = "",
        votes = "",
        type = "",
        dvd = "",
        boxOffice = "",
        production = "",
        website = ""
    )
}
