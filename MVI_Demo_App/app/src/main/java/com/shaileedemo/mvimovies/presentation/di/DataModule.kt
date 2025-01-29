package com.shaileedemo.mvimovies.presentation.di

import android.content.Context
import com.shaileedemo.mvimovies.data.MovieData
import com.shaileedemo.mvimovies.data.database.DatabaseBuilder
import com.shaileedemo.mvimovies.domain.boundary.DataGateway
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindDataRepository(movieData: MovieData): DataGateway

    companion object {
        @Provides
        fun providesDataBase(@ApplicationContext context: Context): DatabaseBuilder {
            return DatabaseBuilder.getInstance(context)
        }
    }
}
