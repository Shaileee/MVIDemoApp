package com.shaileedemo.mvimovies.presentation.di

import com.shaileedemo.mvimovies.domain.ManageFavoriteMovie
import com.shaileedemo.mvimovies.domain.SeeMovieDetail
import com.shaileedemo.mvimovies.domain.boundary.DataGateway
import com.shaileedemo.mvimovies.domain.boundary.RemoteFacade
import com.shaileedemo.mvimovies.domain.entities.Movie
import com.shaileedemo.mvimovies.domain.entities.TomatoMeter
import com.shaileedemo.mvimovies.domain.posters.PosterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    fun providesTomatoMeterEntity() = TomatoMeter()

    @Provides
    fun providesMovieEntity(tomatoMeter: TomatoMeter) = Movie(tomatoMeter = tomatoMeter)

    @Provides
    fun providesFindMoviesByNameUseCase(remoteFacade: RemoteFacade, movie: Movie) = PosterService(
        remoteFacade = remoteFacade,
        movie = movie
    )

    @Provides
    fun providesManageFavoriteMovies(dataGateway: DataGateway) = ManageFavoriteMovie(
        dataGateway = dataGateway
    )

    @Provides
    fun providesGetMovieDetail(
        remoteFacade: RemoteFacade,
        movie: Movie
    ): SeeMovieDetail = SeeMovieDetail(
        remoteFacade = remoteFacade,
        movie = movie
    )
}