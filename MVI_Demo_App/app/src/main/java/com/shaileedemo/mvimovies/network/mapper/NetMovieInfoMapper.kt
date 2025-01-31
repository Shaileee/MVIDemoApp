package com.shaileedemo.mvimovies.network.mapper

import com.shaileedemo.mvimovies.domain.entities.Movie
import com.shaileedemo.mvimovies.network.model.RemoteMovieDetail
import javax.inject.Inject

class NetMovieInfoMapper @Inject constructor() {

    fun RemoteMovieDetail.toInformation() = Movie.Information(
        title = title,
        year = year,
        rated = rated,
        released = released,
        runtime = runtime,
        genre = genre,
        director = director,
        writer = writer,
        actors = actors,
        plot = plot,
        language = language,
        country = country,
        awards = awards,
        image = poster,
        metascore = metascore,
        imdbVotes = imdbVotes,
        imdbRating = imdbRating,
        ratings = ratings.toString(),
        type = type,
        dvd = dvd,
        boxOffice = boxOffice,
        production = production,
        website = website
    )
}
