package com.shaileedemo.mvimovies.presentation.di

import com.shaileedemo.mvimovies.domain.boundary.RemoteFacade
import com.shaileedemo.mvimovies.network.MovieNetwork
import com.shaileedemo.mvimovies.network.config.RetrofitWebServiceBuilder
import com.shaileedemo.mvimovies.network.config.WebServiceConfig
import com.shaileedemo.mvimovies.network.retrofit.WebServiceRetrofit
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {
    @Binds
    fun bindNetworkGateway(movieNetwork: MovieNetwork): RemoteFacade

    companion object {
        @Provides
        fun providesDispatcher(): CoroutineDispatcher = Dispatchers.IO

        @Provides
        fun provideWebServiceRetrofit(): WebServiceRetrofit {
            return RetrofitWebServiceBuilder<WebServiceRetrofit>().makeRemoteRestApi(
                isDebug = true,
                tClass = WebServiceRetrofit::class.java,
                baseUrl = WebServiceConfig.BASE_URL
            )
        }
    }
}