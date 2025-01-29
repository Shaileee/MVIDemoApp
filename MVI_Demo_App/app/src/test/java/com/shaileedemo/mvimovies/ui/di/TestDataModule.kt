package com.shaileedemo.mvimovies.ui.di

import com.shaileedemo.mvimovies.domain.boundary.DataGateway
import dagger.Module
import dagger.Provides
import io.mockk.mockk
import javax.inject.Singleton

@Module
object TestDataModule {

    @Provides
    @JvmStatic
    @Singleton
    fun providesDataRepository(): DataGateway {
        return mockk()
    }
}
