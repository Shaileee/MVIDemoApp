package com.shaileedemo.mvimovies.factory

import com.shaileedemo.mvimovies.domain.entities.Movie
import com.shaileedemo.mvimovies.network.model.RemoteMovieDetail

object MovieDetailFactory {

    fun makeRemoteMovieDetail() = RemoteMovieDetail(
        title = RandomFactory.generateString(),
        year = RandomFactory.generateString(),
        rated = RandomFactory.generateString(),
        released = RandomFactory.generateString(),
        runtime = RandomFactory.generateString(),
        genre = RandomFactory.generateString(),
        director = RandomFactory.generateString(),
        writer = RandomFactory.generateString(),
        actors = RandomFactory.generateString(),
        plot = RandomFactory.generateString(),
        language = RandomFactory.generateString(),
        country = RandomFactory.generateString(),
        awards = RandomFactory.generateString(),
        poster = RandomFactory.generateString(),
        ratings = emptyList(),
        metascore = RandomFactory.generateString(),
        imdbRating = RandomFactory.generateString(),
        imdbVotes = RandomFactory.generateString(),
        imdbId = RandomFactory.generateString(),
        type = RandomFactory.generateString(),
        dvd = RandomFactory.generateString(),
        boxOffice = RandomFactory.generateString(),
        production = RandomFactory.generateString(),
        website = RandomFactory.generateString(),
        response = RandomFactory.generateString()
    )

    fun randomMovieInformation() = Movie.Information(
        title = RandomFactory.generateString(),
        year = RandomFactory.generateString(),
        rated = RandomFactory.generateString(),
        released = RandomFactory.generateString(),
        runtime = RandomFactory.generateString(),
        genre = RandomFactory.generateString(),
        director = RandomFactory.generateString(),
        writer = RandomFactory.generateString(),
        actors = RandomFactory.generateString(),
        plot = RandomFactory.generateString(),
        language = RandomFactory.generateString(),
        country = RandomFactory.generateString(),
        awards = RandomFactory.generateString(),
        image = RandomFactory.generateString(),
        metascore = RandomFactory.generateString(),
        ratings = RandomFactory.generateString(),
        imdbVotes = RandomFactory.generateString(),
        imdbRating = RandomFactory.generateString(),
       // votes = RandomFactory.generateString(),
        type = RandomFactory.generateString(),
        dvd = RandomFactory.generateString(),
        boxOffice = RandomFactory.generateString(),
        production = RandomFactory.generateString(),
        website = RandomFactory.generateString()
    )
}
